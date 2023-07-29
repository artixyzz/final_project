package com.example.final_project.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@NonNull
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subjectName;

    private LocalDate subjectStartDate;

    private int subjectDurationInHours;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Lesson> lessons;



}
