package com.cuiwz.encrypt;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JasyptTest {

    @Autowired
    StringEncryptor encryptor;

    @Test
    public void getPass() {
        String url = encryptor.encrypt("jdbc:mysql://localhost:3306/blog?characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2b8");
        String username = encryptor.encrypt("root");
        String password = encryptor.encrypt("123456");
        System.out.println("url: " + url);
        System.out.println("username: " + username);
        System.out.println("password: " + password);
    }

}