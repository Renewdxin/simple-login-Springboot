package com.example.controller;

import com.example.entity.RestBean;
import com.example.entity.user.accountUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @GetMapping("/me")
    public RestBean<accountUser> me(@SessionAttribute("account") accountUser user) {
        return RestBean.success(user);
    }
}
