package com.example.final_project;

import com.example.final_project.model.User;
import com.example.final_project.reposiroty.UserRepository;
import com.example.final_project.service.PasswordUtil;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@AllArgsConstructor
@SpringBootApplication
public class FinalProjectApplication implements CommandLineRunner {

    private final PasswordUtil passwordUtil;
    private final UserRepository userRepository;


    public static void main(String[] args) {
        SpringApplication.run(FinalProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        userRepository.save(
                User
                        .builder()
                        .roles("USER ADMIN")
                        .email("ewa@sda.pl")
                        .hashedPassword(passwordUtil.bcryptEncryptor("password"))
                        .enabled(true)
                        .build()

        );
    }
}