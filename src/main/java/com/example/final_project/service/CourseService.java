package com.example.final_project.service;
import com.example.final_project.dto.CourseDto;
import com.example.final_project.dto.RequestCourseDto;
import com.example.final_project.model.Course;
import com.example.final_project.model.Subject;
import com.example.final_project.reposiroty.CourseRepository;
import com.example.final_project.reposiroty.SubjectRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service

public class CourseService {
    private final CourseRepository courseRepository;
    private final SubjectRepository subjectRepository;


    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }
    public Course findById(long id) {
        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public void save(RequestCourseDto requestCourseDto){
        List<Subject> subjects = subjectRepository.findAllById(requestCourseDto.getSubjects());
        Course course = Course
                .builder()
                .courseName(requestCourseDto.getCourseName())
                .courseStartDate(requestCourseDto.getCourseStartDate())
                .courseDurationInHours(requestCourseDto.getCourseDurationInHours())
                .subjects(subjects)
                .build();
        courseRepository.save(course);
    }

    public void deleteCourseById(long id) {
        courseRepository.deleteById(id);
    }
    public void updateCourse(CourseDto courseDto){
        if (courseDto.getId() == null){
            throw new RuntimeException("Id can not be null");
        }
        List<Subject> subjects = subjectRepository.findAllById(courseDto.getSubjects());
        Course course = Course
                .builder()
                .id(courseDto.getId())
                .courseName(courseDto.getCourseName())
                .courseStartDate(courseDto.getCourseStartDate())
                .courseDurationInHours(courseDto.getCourseDurationInHours())
                .subjects(subjects)
                .build();
        courseRepository.save(course);
    }
}