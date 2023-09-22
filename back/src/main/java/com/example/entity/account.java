package com.example.entity;

import lombok.Data;
import org.springframework.context.annotation.Bean;

@Data
public class account {
    int id;
    String username;
    String email;
    String password;
}
