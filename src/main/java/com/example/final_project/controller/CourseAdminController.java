package com.example.final_project.controller;

import com.example.final_project.service.AdminCourseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/course")
public class CourseAdminController implements WebMvcConfigurer {


@GetMapping("/login")
public String index() {
    return "Zaloguj się!";
}
}


