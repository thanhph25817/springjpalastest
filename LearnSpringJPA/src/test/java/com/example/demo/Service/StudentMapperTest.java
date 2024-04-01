package com.example.demo.Service;

import com.example.demo.student.Student;
import com.example.demo.student.StudentDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private StudentMapper mappertest;

    @BeforeEach
    void setUp() {
        mappertest = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudentClass() {
        StudentDto sto = new StudentDto(
                "john",
                "thanh",
                "thanh@gmail.com",
                1);
        Student student = mappertest.toStudent(sto);

        Assertions.assertEquals(sto.getFirstName(), student.getFirstName());
        Assertions.assertEquals(sto.getLastName(), student.getLastName());
        Assertions.assertEquals(sto.getEmail(), student.getEmail());
        Assertions.assertNotNull(student.getSchool());
        assertEquals(sto.getSchoolId(), student.getSchool().getId());
    }

}