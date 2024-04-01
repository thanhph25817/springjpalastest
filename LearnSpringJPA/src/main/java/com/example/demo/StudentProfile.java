package com.example.demo;

import com.example.demo.student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student_profile")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String bio;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
