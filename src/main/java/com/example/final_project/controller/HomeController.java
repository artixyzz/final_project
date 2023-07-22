package com.example.final_project.controller;

import com.example.final_project.model.Course;
import com.example.final_project.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {

    private final CourseService courseService;

    public HomeController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/")
    public String homePage (){
        return "homepage";
    }


//    @GetMapping("/courses")
//        public ResponseEntity<List<Course>>findAllCourses(@RequestParam(required = false) String courseName) {
//
//        List<Course> courses = new ArrayList<Course>();
//
//        return "courses";
//
//    }

}
