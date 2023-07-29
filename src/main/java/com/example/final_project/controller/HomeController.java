package com.example.final_project.controller;
import com.example.final_project.dto.CourseDto;
import com.example.final_project.dto.RequestCourseDto;
import com.example.final_project.dto.RequestSubjectDto;
import com.example.final_project.service.CourseService;
import com.example.final_project.service.LessonService;
import com.example.final_project.service.SubjectService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@AllArgsConstructor
@Controller
public class HomeController {
    private final CourseService courseService;
    private final SubjectService subjectService;
    private final LessonService lessonService;
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
    //    @GetMapping("/subjects")
//    public String findAllSubjects(Model model) {
//        model.addAttribute("subjects", subjectService.findAllSubjects());
//        return "subjects/1";
//    }

    @GetMapping("/subject/create")
    public String createSubject(Model model) {
        model.addAttribute("lesson", lessonService.findAllLessons());
        model.addAttribute("subject", RequestSubjectDto.builder().build());
        return "subjectCreate";
    }
    @PostMapping("/subject/create")
    public String saveSubject(Model model, @Valid @ModelAttribute RequestSubjectDto requestSubjectDto) {
        subjectService.save(requestSubjectDto);
        model.addAttribute("subject", subjectService.findAllSubjects());
        return "redirect:/courses/create";
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
    @GetMapping("/subjects/{id}")
    public String subjects(Model model,@PathVariable Long id) {
        model.addAttribute("subject", subjectService.findById(id));
        return "subject";
    }
}







