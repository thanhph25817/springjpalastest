package com.example.demo;

import com.example.demo.Service.StudentMapper;
import com.example.demo.Service.StudentService;
import com.example.demo.repository.StudentRepository;
import com.example.demo.student.Student;
import com.example.demo.student.StudentDto;
import com.example.demo.student.StudentResponeDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;


@RestController
public class StudentController {
    private final StudentService studentService;
    private final StudentRepository studentRepository;
    private final StudentMapper mapper;

    public StudentController(StudentService studentService, StudentRepository studentRepository, StudentMapper mapper) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
        this.mapper = mapper;
    }


    @PostMapping("/post-student")
    public StudentResponeDto saveStudent(
            @Valid @RequestBody StudentDto studentdto
    ) {
        return this.studentService.saveStudent(studentdto);
    }


    @GetMapping("/student")
    public List<StudentResponeDto> paramVar(
    ) {
        return this.studentService.getAllStudent();
    }

    @GetMapping("/student/{id}")
    public Student getId(
            @PathVariable("id") Long id
    ) {
        return studentRepository.findById(id).orElse(new Student());
    }

    @GetMapping("/student/sea/{student-name}")
    public List<Student> getName(
            @PathVariable("student-name") String name
    ) {
        return this.studentService.getName(name);
    }

    @DeleteMapping("/students/{student-id}")
    public void delete(@PathVariable("student-id") Integer id) {
        this.studentService.delete(id);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMthodArgumentNotValidException(MethodArgumentNotValidException exp) {
        HashMap ers = new HashMap<String, String>();
        exp.getBindingResult().getAllErrors().forEach(errors -> {
            var fielName = ((FieldError) errors).getField();
            var errMess = errors.getDefaultMessage();
            ers.put(fielName, errMess);
        });
        return new ResponseEntity<>(ers, HttpStatus.BAD_REQUEST);
    }
}
