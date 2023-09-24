package com.example.back;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class BackApplicationTests {

    @Test
    void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Code");
        message.setText("Code: " + 11111);
        message.setFrom("renxinhaha2023@162.com");
        message.setTo("cissyrenxin@icloud.com");

    }

}
