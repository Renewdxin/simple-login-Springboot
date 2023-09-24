package com.example.service;

import com.example.entity.account;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthorizeService extends UserDetailsService {
    String sendVaildateEmail(String email, String sessionId);
    String validateAndRegister(String username, String password, String email, String code, String sessionId);
}
