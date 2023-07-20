package com.example.final_project.service;

import com.example.final_project.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminCourseService {

    List<Course> findAllCourses();


}
