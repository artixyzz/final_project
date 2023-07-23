package com.example.final_project.dto;

import com.example.final_project.model.Subject;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

    private Long id;

    private String courseName;

    private LocalDate courseStartDate;

    private int courseDurationInHours;

    private List<Long> subjects;



}
