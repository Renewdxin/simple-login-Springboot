package com.example.service.impl;

import com.example.entity.account;
import com.example.mapper.UserMapper;
import com.example.service.AuthorizeService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class authorizeServiceImpl implements AuthorizeService {
    @Value("${spring.mail.username}")
    String from;

    @Resource
    UserMapper userMapper;

    @Resource
    MailSender sender;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username == null) {
            throw new UsernameNotFoundException("NOT EXIST");
        }
        account account = userMapper.findByNameorEmail(username);

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
    public boolean sendVaildateEmail(String email) {
        Random random = new Random();
        int code = random.nextInt(899999) + 100000;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(email);
        message.setSubject("Code");
        message.setText("Code: " + code);
        try{
            sender.send();
        } catch (MailException e) {
            e.printStackTrace();
        }

        return true;
    }
}
