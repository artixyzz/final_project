package com.example.final_project.service;
import com.example.final_project.model.Course;
import com.example.final_project.reposiroty.CourseRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class CourseService {
    private final CourseRepository courseRepository;
    //    Dodać metodę assignCourse
    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }
    public Course findById(long id) {
        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

//    public Course saveCourse(Course course) {
//        if (course.getId() != 0) {
//            long id = course.getId();
//
//            for (int i = 0; i < courses.size(); i++)
//                if (id == courses.get(i).getId()) {
//                    courses.set(i, course);
//                    break;
//                }
//
//            return course;
//        }
//        courses.add(course);
//        return course;
//    }
//
//    public void deleteCourseById(long id) {
//        courses.removeIf(course -> id == course.getId());
//    }
}