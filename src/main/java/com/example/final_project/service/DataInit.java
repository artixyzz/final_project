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
import java.util.List;

@Component
@AllArgsConstructor
public class DataInit {
    private final PasswordUtil passwordUtil;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final SubjectRepository subjectRepository;
    private final LessonRepository lessonRepository;


    @PostConstruct
    public void init (){


        initUser();
        initCourses();
        initSubjects();
        initLesson();

    }


    private void initUser() {
        List<User> users = List.of(User
                        .builder()
                        .roles("USER ADMIN")
                        .email("ewa@sda.pl")
                        .hashedPassword(passwordUtil.bcryptEncryptor("password"))
                        .enabled(true)
                        .build(),
                User
                        .builder()
                        .roles("USER")
                        .email("ania@sda.pl")
                        .hashedPassword(passwordUtil.bcryptEncryptor("password"))
                        .enabled(true)
                        .build());
        userRepository.saveAll(users);
    }


    private void initCourses() {
        List<Course> courses = List.of(Course
                        .builder()
                        .courseName("Java")
                        .courseStartDate(LocalDate.of(2023,10,1))
                        .courseDurationInHours(350)
                        .build(),
                Course
                        .builder()
                        .courseName("Python")
                        .courseStartDate(LocalDate.of(2023,1,5))
                        .courseDurationInHours(400)
                        .build(),
                Course
                        .builder()
                        .courseName("C++")
                        .courseStartDate(LocalDate.of(2023,5,3))
                        .courseDurationInHours(380)
                        .build());
        courseRepository.saveAll(courses);

    }

    private void initSubjects(){
        List<Subject> subjects = List.of(Subject
                        .builder()
                        .subjectName("MySQL")
                        .subjectStartDate(LocalDate.of(2023, 11, 2))
                        .subjectDurationInHours(20)
                        .build(),
                Subject
                        .builder()
                        .subjectName("JavaBasic")
                        .subjectStartDate(LocalDate.of(2023, 12, 1))
                        .subjectDurationInHours(25)
                        .build(),
                Subject
                        .builder()
                        .subjectName("JavaAdvanced")
                        .subjectStartDate(LocalDate.of(2024, 3, 1))
                        .subjectDurationInHours(30)
                        .build(),
                Subject
                        .builder()
                        .subjectName("PythonBasic")
                        .subjectStartDate(LocalDate.of(2024, 6, 3))
                        .subjectDurationInHours(15)
                        .build(),
                Subject
                        .builder()
                        .subjectName("PythonAdvanced")
                        .subjectStartDate(LocalDate.of(2024, 8, 1))
                        .subjectDurationInHours(15)
                        .build(),
                Subject
                        .builder()
                        .subjectName("C++Basic")
                        .subjectStartDate(LocalDate.of(2024, 6, 3))
                        .subjectDurationInHours(15)
                        .build(),
                Subject
                        .builder()
                        .subjectName("C++Advanced")
                        .subjectStartDate(LocalDate.of(2024, 8, 1))
                        .subjectDurationInHours(15)
                        .build());
        subjectRepository.saveAll(subjects);

    };

    private void initLesson() {
        List<Lesson> lessons = List.of(Lesson
                        .builder()
                        .lessonName("Introduction")
                        .lessonStartDate(LocalDate.of(2023, 10, 16))
                        .lessonDurationInHours(32)
                        .build(),

                Lesson
                        .builder()
                        .lessonName("Extension")
                        .lessonStartDate(LocalDate.of(2023, 6, 14))
                        .lessonDurationInHours(16)
                        .build(),
                Lesson
                        .builder()
                        .lessonName("Practise")
                        .lessonStartDate(LocalDate.of(2023, 9, 18))
                        .lessonDurationInHours(32)
                        .build());
        lessonRepository.saveAll(lessons);
    }

    }