package com.example.final_project.controller;
import com.example.final_project.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@AllArgsConstructor
@Controller
public class HomeController {
    private final CourseService courseService;
    @GetMapping("/")
    public String homePage() {
        return "homePage";
    }
    @GetMapping("/courses")
    public String findAllCourses(Model model) {
        model.addAttribute("courses", courseService.findAllCourses());
        return "courses";
    }
}