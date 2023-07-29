package com.example.final_project.service;

import com.example.final_project.dto.RequestSubjectDto;
import com.example.final_project.dto.SubjectDto;
import com.example.final_project.model.Lesson;
import com.example.final_project.model.Subject;
import com.example.final_project.reposiroty.LessonRepository;
import com.example.final_project.reposiroty.SubjectRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final LessonRepository lessonRepository;


    public List<Subject> findAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject findById(long id) {
        return subjectRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public void save(@Valid RequestSubjectDto subjectDto) {
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

    public void updateSubject(SubjectDto subjectDto) {
        if (subjectDto.getId() == null) {
            throw new RuntimeException("Id can not be null");
        }
        List<Lesson> lessons = lessonRepository.findAllById(subjectDto.getLessons());
        Subject subject = Subject
                .builder()
                .id(subjectDto.getId())
                .subjectName(subjectDto.getSubjectName())
                .subjectStartDate(subjectDto.getSubjectStartDate())
                .subjectDurationInHours(subjectDto.getSubjectDurationInHours())
                .lessons(lessons)
                .build();
        subjectRepository.save(subject);
    }
}

