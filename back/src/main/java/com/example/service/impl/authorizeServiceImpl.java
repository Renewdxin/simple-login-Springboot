package com.example.service.impl;

import com.example.entity.Account;
import com.example.mapper.UserMapper;
import com.example.service.AuthorizeService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class authorizeServiceImpl implements AuthorizeService {
    @Value("${spring.mail.username}")
    String from;

    @Resource
    UserMapper userMapper;

    @Resource
    MailSender sender;
    @Resource
    StringRedisTemplate template;


    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username == null) {
            throw new UsernameNotFoundException("NOT EXIST");
        }
        Account account = userMapper.findByNameorEmail(username);

        if(account == null) {
            throw new UsernameNotFoundException("ERROR");
        }
        return User
                .withUsername(account.getUsername())
                .password(account.getPassword())
                .roles("user")
                .build();
    }

    /**
     * 1.生成并发送验证码
     * 2.将验证码和对应邮箱放入redis
     * 3.过期时间：60s，重新发送时间间隔：120s
     * 4。生成失败则删除数据
     * 5.用户注册时，取出对应键值对，看是否一致
     */
    @Override
    public String sendVaildateEmail(String email, String sessionId, boolean hasAccount) {
        String key = "email" + sessionId + ":" + email;
        if(Boolean.TRUE.equals(template.hasKey(key))) {
            Long expire = Optional.ofNullable(template.getExpire(key, TimeUnit.SECONDS)).orElse(0L) ;
            if(expire > 120) {
                return "请稍后再试";
            }
        }

        Account account = userMapper.findByNameorEmail(email);
        if(hasAccount && account == null) {
            return "没有该账户";
        }

        if(!hasAccount && account != null) {
            return "此账号已注册，请直接登录";
        }

        Random random = new Random();
        int code = random.nextInt(899999) + 100000;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(email);
        message.setSubject("Code");
        message.setText("Code: " + code);
        try{
            sender.send();
            template.opsForValue().set(key, String.valueOf(code), 3, TimeUnit.MINUTES);
            return "邮件发送成功";
        } catch (MailException e) {
            e.printStackTrace();
            return "发送失败";
        }
    }

    @Override
    public String validateAndRegister(String username, String password, String email, String code, String sessionId) {
        String key = "email" + sessionId + ":" + email + ":false";
        if(Boolean.TRUE.equals(template.hasKey(key))) {
            String s = template.opsForValue().get(key);
            if(s == null) {
                return "验证码失效";
            } else if (s.equals(code)) {
                password = encoder.encode(password);
                if((userMapper.createAccount(username, email, password)) > 0) {
                    return null;
                } else {
                    return "内部错误，请联系客服";
                }
            } else {
                return "验证码错误";
            }
        } else {
            return "请先获取验证码";
        }
    }

    @Override
    public String validateOnly(String email, String code, String sessionId) {
        String key = "email" + sessionId + ":" + email + ":true";
        if(Boolean.TRUE.equals(template.hasKey(key))) {
            String s = template.opsForValue().get(key);
            if(s == null) {
                return "验证码失效";
            } else if (s.equals(code)) {
                return null;
            }else {
                return "内部错误，请联系客服";
            }
        } else {
            return "请先获取验证码";
        }

    }

    @Override
    public boolean resetPassword(String email, String password) {
        password = encoder.encode(password);
        return userMapper.resetPasswordByEmail(password, email) > 0;
    }
}
