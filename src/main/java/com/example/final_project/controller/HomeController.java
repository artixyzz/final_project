package com.example.final_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage (){
        return "homepage";
    }

    @GetMapping("/Wszystkie kursy")
    public String allCourses() {
        return "allCourses";
    }

}
