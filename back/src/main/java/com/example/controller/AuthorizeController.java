package com.example.controller;

import com.example.entity.RestBean;
import com.example.service.AuthorizeService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/auth")
public class AuthorizeController {
    private static final String EMAIL_REGEXP = "^(\\w+([-.][A-Za-z0-9]+)*){3,18}@\\w+([-.][A-Za-z0-9]+)*\\.\\w+([-.][A-Za-z0-9]+)*$";
    private static final String USERNAME_REGEXP = "^[a-zA-Z0-9\\u4e00-\\u9fa5]+$";

    @Resource
    AuthorizeService authorizeService;

    @PostMapping("/valid-register-email")
    public RestBean<String> validateRegisterEmail(@Pattern(regexp = EMAIL_REGEXP) @RequestParam("email") String email,
                                          HttpSession session) {
        if ((authorizeService.sendVaildateEmail(email, session.getId(), false)) == null) {
            return RestBean.success("SUCCESS");
        } else {
            return RestBean.failure(400,"FAILURE");
        }
    }

    @PostMapping("/valid-reset-email")
    public RestBean<String> validateResetEmail(@Pattern(regexp = EMAIL_REGEXP) @RequestParam("email") String email,
                                          HttpSession session) {
        if ((authorizeService.sendVaildateEmail(email, session.getId(), true)) == null) {
            return RestBean.success("SUCCESS");
        } else {
            return RestBean.failure(400,"FAILURE");
        }
    }

    @PostMapping("/register")
    public RestBean<String> registerUser(@Pattern(regexp = USERNAME_REGEXP) @Length(min = 2, max = 8) @RequestParam("username") String username,
                                         @RequestParam("password") @Length(min = 6, max = 16) String password,
                                         @Pattern(regexp = EMAIL_REGEXP)  @RequestParam("email") String email,
                                         @Length(min = 6, max = 6) @RequestParam("code") String code,
                                         HttpSession session) {
        String s = authorizeService.validateAndRegister(username,password,email,code, session.getId());
        if(s == null) {
            return RestBean.success("注册成功");
        } else {
            return RestBean.failure(400,s);
        }
    }

    /**
     * 1.发送验证邮件
     * 2.验证验证码,正确则在Session中村标记
     * 3。验证标记
     */
    @PostMapping("/start-reset")
    public RestBean<String> startReset( @Pattern(regexp = EMAIL_REGEXP)  @RequestParam("email") String email,
                                        @Length(min = 6, max = 6) @RequestParam("code") String code,
                                        HttpSession session) {
        String s = authorizeService.validateOnly(email,code,session.getId());
        if(s == null) {
            session.setAttribute("reset-password", email);
            return RestBean.success();
        } else {
            return RestBean.failure(400, s);
        }
    }

    @PostMapping("/do-reset")
    public RestBean<String> resetPassword(@RequestParam("password") @Length(min = 6, max = 16) String password,
                                          HttpSession session) {
        String email = (String) session.getAttribute("reset-password");
        if(email == null) {
            return RestBean.failure(401, "请先完成邮箱验证");
        } else if (authorizeService.resetPassword(email, password)) {
            session.removeAttribute("reset-password");
            return RestBean.success("密码重置成功");
        } else {
            return RestBean.failure(500, "请联系客服");
        }

    }
}
