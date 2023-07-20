package com.example.final_project.service;

import com.example.final_project.model.Course;
import com.example.final_project.reposiroty.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminCourseServiceJpa  implements AdminCourseService {

    private final CourseRepository courseRepository;

    public AdminCourseServiceJpa(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }
}
