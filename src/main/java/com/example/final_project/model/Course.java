package com.example.final_project.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@NonNull

public class Course {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String courseName;

    private LocalDate courseStartDate;

    private int courseDurationInHours;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Subject> subjects;



}
