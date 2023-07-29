package com.example.final_project.controller;
import com.example.final_project.dto.CourseDto;
import com.example.final_project.dto.RequestCourseDto;
import com.example.final_project.service.CourseService;
import com.example.final_project.service.SubjectService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.xml.sax.Attributes;

@AllArgsConstructor
@Controller
public class HomeController {
    private final CourseService courseService;
    private final SubjectService subjectService;
    @GetMapping("/")
    public String homePage() {
        return "homePage";
    }
    @GetMapping("/ourMission")
    public String showOurMission() {
        return "ourMission";
    }
    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
    @GetMapping("/courses")
    public String findAllCourses(Model model) {
        model.addAttribute("courses", courseService.findAllCourses());
        return "courses";
    }
    @GetMapping("/subjects")
    public String findAllSubjects(Model model) {
        model.addAttribute("subjects", subjectService.findAllSubjects());
        return "subjects/1";
    }
    @GetMapping("/courses/create")
    public String createCourse(Model model) {
        model.addAttribute("subject", subjectService.findAllSubjects());
        model.addAttribute("course", RequestCourseDto.builder().build());
        return "courseCreate";
    }
    @PostMapping("/courses/create")
    public String saveCourse(Model model, @Valid @ModelAttribute RequestCourseDto requestCourseDto) {
        courseService.save(requestCourseDto);
        model.addAttribute("courses", courseService.findAllCourses());
        return "/courses";
    }
    @GetMapping("/courses/update")
    public String updateCourse(Model model) {
        model.addAttribute("subject", subjectService.findAllSubjects());
        model.addAttribute("course", CourseDto.builder().build());
        return "courseUpdate";
    }
    @PostMapping("/courses/update")
    public String saveUpdatedCourse(Model model, @Valid @ModelAttribute CourseDto CourseDto) {
        courseService.updateCourse(CourseDto);
        model.addAttribute("courses", courseService.findAllCourses());
        return "/courses";
    }
    @GetMapping("/courses/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourseById(id);
//            attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
//            attributes.addAttribute("attribute", "redirectWithRedirectView");
//            return new RedirectView("courses");
        return "redirect:/courses";
    }
    @GetMapping("/subjects/1")
    public String subjects1(Model model) {
        model.addAttribute("subject", subjectService.findAllSubjects());
        return "MySQL";
    }
    @GetMapping("/subjects/2")
    public String subjects2(Model model) {
        model.addAttribute("subject", subjectService.findAllSubjects());
        return "JavaBasic";
    }
    @GetMapping("/subjects/3")
    public String subjects3(Model model) {
        model.addAttribute("subject", subjectService.findAllSubjects());
        return "JavaAdvanced";
    }
    @GetMapping("/subjects/4")
    public String subjects4(Model model) {
        model.addAttribute("subject", subjectService.findAllSubjects());
        return "PythonBasic";
    }
    @GetMapping("/subjects/5")
    public String subjects5(Model model) {
        model.addAttribute("subject", subjectService.findAllSubjects());
        return "PythonAdvanced";
    }
    @GetMapping("/subjects/6")
    public String subjects6(Model model) {
        model.addAttribute("subject", subjectService.findAllSubjects());
        return "C++Basic";
    }
    @GetMapping("/subjects/7")
    public String subjects7(Model model) {
        model.addAttribute("subject", subjectService.findAllSubjects());
        return "C++Advanced";
    }
}