package com.example.demo.Service;

import com.example.demo.school.School;
import com.example.demo.student.Student;
import com.example.demo.student.StudentDto;
import com.example.demo.student.StudentResponeDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentMapper {
    public Student toStudent(StudentDto dto) {
        Student student = new Student();
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setEmail(dto.getEmail());
        School schoo = new School();
        schoo.setId(dto.getSchoolId());
        student.setSchool(schoo);
        return student;
    }

    public StudentResponeDto toStudentDto(Student student) {
        return new StudentResponeDto(
                student.getFirstName(),
                student.getFirstName(),
                student.getEmail()
        );
    }


}
