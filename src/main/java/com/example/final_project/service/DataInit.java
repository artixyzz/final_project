package com.example.final_project.service;

import com.example.final_project.model.Course;
import com.example.final_project.model.Lesson;
import com.example.final_project.model.Subject;
import com.example.final_project.model.User;
import com.example.final_project.reposiroty.CourseRepository;
import com.example.final_project.reposiroty.LessonRepository;
import com.example.final_project.reposiroty.SubjectRepository;
import com.example.final_project.reposiroty.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class DataInit {
    private final PasswordUtil passwordUtil;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final SubjectRepository subjectRepository;
    private final LessonRepository lessonRepository;

    private List<Lesson> savedLessons;
    private List<Lesson> savedLessons2;
    private List<Lesson> savedLessons3;
    private List<Subject> savedSubjects;
    private List<Subject> savedSubjects2;
    private List<Subject> savedSubjects3;
    private List<Subject> savedSubjects4;
    private List<Subject> savedSubjects5;
    private List<Subject> savedSubjects6;
    private List<Subject> savedSubjects7;
    private List<Course> savedCourses;
    private List<Course> savedCourses2;
    private List<Course> savedCourses3;


    @PostConstruct
    public void init() {

        initLesson();
        initSubjects();
        initCourses();
        initUser();

    }

    private void initUser() {
        List<User> users = List.of(User
                        .builder()
                        .roles("ADMIN")
                        .email("ewa@sda.pl")
                        .hashedPassword(passwordUtil.bcryptEncryptor("password"))
                        .enabled(true)
                        .build(),
                User
                        .builder()
                        .roles("STUDENT")
                        .email("ania@sda.pl")
                        .hashedPassword(passwordUtil.bcryptEncryptor("password"))
                        .enabled(true)
                        .build(),
                User
                        .builder()
                        .roles("PROFESSOR")
                        .email("kazik@sda.pl")
                        .hashedPassword(passwordUtil.bcryptEncryptor("password"))
                        .enabled(true)
                        .build());
        userRepository.saveAll(users);
    }

    private void initCourses() {
        List<Course> courses = List.of(Course
                        .builder()
                        .subjects(Stream.of(savedSubjects, savedSubjects2, savedSubjects3).flatMap(Collection::stream).collect(Collectors.toList()))
                        .courseName("Java")
                        .courseStartDate(LocalDate.of(2023, 10, 1))
                        .courseDurationInHours(350)
                        .build());
        savedCourses =courseRepository.saveAll(courses);

        List<Course> courses2 = List.of(Course
                        .builder()
                        .subjects(Stream.of(savedSubjects, savedSubjects4, savedSubjects5).flatMap(Collection::stream).collect(Collectors.toList()))
                        .courseName("Python")
                        .courseStartDate(LocalDate.of(2023,1,5))
                        .courseDurationInHours(400)
                        .build());
        savedCourses2 = courseRepository.saveAll(courses2);

        List<Course> courses3 = List.of(Course
                        .builder()
                        .subjects(Stream.of(savedSubjects, savedSubjects6, savedSubjects7).flatMap(Collection::stream).collect(Collectors.toList()))
                        .courseName("C++")
                        .courseStartDate(LocalDate.of(2023,5,3))
                        .courseDurationInHours(380)
                        .build());
        savedCourses3 = courseRepository.saveAll(courses3);

    }


    private void initSubjects() {
        List<Subject> subjects = List.of(Subject
                .builder()
                .lessons(savedLessons.stream().filter(lesson -> {
                    return lesson.getLessonName().contains("Introduction") || lesson.getLessonName().contains("Extension");
                }).collect(Collectors.toList()))
                .subjectName("MySQL")
                .subjectStartDate(LocalDate.of(2023, 11, 2))
                .subjectDurationInHours(20)
                .build());
        savedSubjects = subjectRepository.saveAll(subjects);

        List<Subject> subjects2 = List.of(Subject
                .builder()
                .lessons(Stream.of(savedLessons, savedLessons2, savedLessons3).flatMap(Collection::stream).collect(Collectors.toList()))
                .subjectName("JavaBasic")
                .subjectStartDate(LocalDate.of(2023, 12, 1))
                .subjectDurationInHours(25)
                .build());
        savedSubjects2 = subjectRepository.saveAll(subjects2);

        List<Subject> subjects3 = List.of(Subject
                .builder()
                .lessons(Stream.of(savedLessons, savedLessons2, savedLessons3).flatMap(Collection::stream).collect(Collectors.toList()))
                .subjectName("JavaAdvanced")
                .subjectStartDate(LocalDate.of(2024, 3, 1))
                .subjectDurationInHours(30)
                .build());
        savedSubjects3 = subjectRepository.saveAll(subjects3);

        List<Subject> subjects4 = List.of(Subject
                .builder()
                .lessons(Stream.of(savedLessons, savedLessons2, savedLessons3).flatMap(Collection::stream).collect(Collectors.toList()))
                .subjectName("PythonBasic")
                .subjectStartDate(LocalDate.of(2024, 6, 3))
                .subjectDurationInHours(15)
                .build());
        savedSubjects4 = subjectRepository.saveAll(subjects4);

        List<Subject> subjects5 = List.of(Subject
                .builder()
                .lessons(Stream.of(savedLessons, savedLessons2, savedLessons3).flatMap(Collection::stream).collect(Collectors.toList()))
                .subjectName("PythonAdvanced")
                .subjectStartDate(LocalDate.of(2024, 8, 1))
                .subjectDurationInHours(15)
                .build());
        savedSubjects5 = subjectRepository.saveAll(subjects5);

        List<Subject> subjects6 = List.of(Subject
                .builder()
                .lessons(Stream.of(savedLessons, savedLessons2, savedLessons3).flatMap(Collection::stream).collect(Collectors.toList()))
                .subjectName("C++Basic")
                .subjectStartDate(LocalDate.of(2024, 6, 3))
                .subjectDurationInHours(15)
                .build());
        savedSubjects6 = subjectRepository.saveAll(subjects6);
        List<Subject> subjects7 = List.of(Subject
                .builder()
                .lessons(Stream.of(savedLessons, savedLessons2, savedLessons3).flatMap(Collection::stream).collect(Collectors.toList()))
                .subjectName("C++Advanced")
                .subjectStartDate(LocalDate.of(2024, 8, 1))
                .subjectDurationInHours(15)
                .build());
        savedSubjects7 = subjectRepository.saveAll(subjects7);

    }

    ;

    private void initLesson() {
        List<Lesson> lessons = List.of(Lesson
                        .builder()
                        .lessonName("Introduction")
                        .lessonStartDate(LocalDate.of(2023, 10, 16))
                        .lessonDurationInHours(32)
                        .build());

        savedLessons = lessonRepository.saveAll(lessons);
        List<Lesson> lessons2 = List.of(Lesson
                        .builder()
                        .lessonName("Extension")
                .lessonStartDate(LocalDate.of(2023, 6, 14))
                .lessonDurationInHours(16)
                .build());
        savedLessons2 = lessonRepository.saveAll(lessons2);

        List<Lesson> lessons3 = List.of(Lesson
                .builder()
                .lessonName("Practise")
                .lessonStartDate(LocalDate.of(2023, 9, 18))
                .lessonDurationInHours(32)
                .build());
        savedLessons3 = lessonRepository.saveAll(lessons3);



    }

}