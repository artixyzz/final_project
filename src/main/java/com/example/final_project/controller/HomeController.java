package com.example.final_project.controller;
import com.example.final_project.dto.RequestCourseDto;
import com.example.final_project.service.CourseService;
import com.example.final_project.service.SubjectService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class HomeController {
    private final CourseService courseService;
    private final SubjectService subjectService;
    @GetMapping("/")
    public String homePage() {
        return "homePage";
    }
    @GetMapping("/courses")
    public String findAllCourses(Model model) {
        model.addAttribute("courses", courseService.findAllCourses());
        return "courses";
    }
    @GetMapping("/courses/create")
    public String createCourse(Model model){
        model.addAttribute("subject", subjectService.findAllSubjects());
        model.addAttribute("course", RequestCourseDto.builder().build());
        return "courseCreate";
    }
    @PostMapping("/courses/create")
    public String saveCourse(Model model, @Valid @ModelAttribute RequestCourseDto requestCourseDto){
        courseService.save(requestCourseDto);
        model.addAttribute("courses", courseService.findAllCourses());
        return "/courses";
    }
}


