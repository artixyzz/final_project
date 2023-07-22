package com.example.final_project.service;

import com.example.final_project.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

//    Dodać metodę assignCourse
    static List<Course> courses = new ArrayList<Course>();

    public List<Course> findAllCourses() {
        return courses;
    }

    public Course findById(long id) {
        return courses.stream().filter(course-> id == course.getId()).findAny().orElse(null);
    }

    public Course saveCourse(Course course) {
        if (course.getId() != 0) {
            long id = course.getId();

            for (int i = 0; i < courses.size(); i++)
                if (id == courses.get(i).getId()) {
                    courses.set(i, course);
                    break;
                }

            return course;
        }
        courses.add(course);
        return course;
    }
       public void deleteCourseById (long id){
           courses.removeIf(course -> id == course.getId());
        }

}
