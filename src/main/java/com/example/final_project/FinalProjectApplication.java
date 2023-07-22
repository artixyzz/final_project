package com.example.final_project;

import com.example.final_project.model.User;
import com.example.final_project.reposiroty.CourseRepository;
import com.example.final_project.reposiroty.UserRepository;
import com.example.final_project.service.PasswordUtil;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class FinalProjectApplication {


    public static void main(String[] args) {
        SpringApplication.run(FinalProjectApplication.class, args);
    }

}