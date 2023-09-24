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

    @PostMapping("/valid-email")
    public RestBean<String> validateEmail(@Pattern(regexp = EMAIL_REGEXP) @RequestParam("email") String email,
                                          HttpSession session) {
        if ((authorizeService.sendVaildateEmail(email, session.getId())) == null) {
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
}
