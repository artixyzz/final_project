package com.example.final_project.service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordUtil {

    private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String bcryptEncryptor(String plainText) {
        return passwordEncoder.encode(plainText);
    }

    public Boolean doPasswordsMatch(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}

