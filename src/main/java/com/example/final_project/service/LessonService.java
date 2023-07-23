package com.example.final_project.service;
import com.example.final_project.dto.LessonDto;
import com.example.final_project.model.Lesson;
import com.example.final_project.reposiroty.LessonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@AllArgsConstructor
@Service
public class LessonService {
    private final LessonRepository lessonRepository;
    public List<Lesson> findAllLessons() {
        return lessonRepository.findAll();
    }
    public Lesson findById(long id) {
        return lessonRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }
    public void save(LessonDto lessonDto) {
        Lesson lesson = Lesson
                .builder()
                .lessonName(lessonDto.getLessonName())
                .lessonStartDate(lessonDto.getLessonStartDate())
                .lessonDurationInHours(lessonDto.getLessonDurationInHours())
                .build();
        lessonRepository.save(lesson);
    }
    public void deleteLessonById(long id) {
        lessonRepository.deleteById(id);
    }
    public void updateLesson(LessonDto lessonDto) {
        if (lessonDto.getId() == null) {
            throw new RuntimeException("Id can not be null");
        }
        Lesson lesson = Lesson
                .builder()
                .lessonName(lessonDto.getLessonName())
                .lessonStartDate(lessonDto.getLessonStartDate())
                .lessonDurationInHours(lessonDto.getLessonDurationInHours())
                .build();
        lessonRepository.save(lesson);
    }
}













