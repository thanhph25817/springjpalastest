package com.example.demo.Service;

import com.example.demo.repository.StudentRepository;
import com.example.demo.student.Student;
import com.example.demo.student.StudentDto;
import com.example.demo.student.StudentResponeDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }


    public StudentResponeDto saveStudent(StudentDto dto) {
        Student student = studentMapper.toStudent(dto);
        StudentResponeDto student1 = studentMapper.toStudentDto(student);
        return student1;
    }

    public List<StudentResponeDto> getAllStudent(
           ) {
        return studentRepository.findAll().stream().map(studentMapper::toStudentDto).collect(Collectors.toList());
    }

    public Optional<Student> getId(
            @PathVariable("id") Long id
    ) {
        return studentRepository.findById(id);
    }

    public List<Student> getName(
            @PathVariable("student-name") String name
    ) {
        return studentRepository.findAllByFirstName(name);
    }

    public void delete(Integer id) {
        studentRepository.deleteById(Long.valueOf(id));
    }
}
