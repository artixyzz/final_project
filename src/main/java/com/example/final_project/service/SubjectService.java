package com.example.final_project.service;

import com.example.final_project.dto.CourseDto;
import com.example.final_project.dto.SubjectDto;
import com.example.final_project.model.Course;
import com.example.final_project.model.Lesson;
import com.example.final_project.model.Subject;
import com.example.final_project.reposiroty.CourseRepository;
import com.example.final_project.reposiroty.LessonRepository;
import com.example.final_project.reposiroty.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final LessonRepository lessonRepository;


    public List<Subject> findAllCourses() {
        return subjectRepository.findAll();
    }
    public Subject findById(long id) {
        return subjectRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public void save(SubjectDto subjectDto){
        List<Lesson> lessons = lessonRepository.findAllById(subjectDto.getLessons());
        Subject subject = Subject
                .builder()
                .subjectName(subjectDto.getSubjectName())
                .subjectStartDate(subjectDto.getSubjectStartDate())
                .subjectDurationInHours(subjectDto.getSubjectDurationInHours())
                .lessons(lessons)
                .build();
        subjectRepository.save(subject);
    }

    public void deleteCourseById(long id) {
        subjectRepository.deleteById(id);
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
