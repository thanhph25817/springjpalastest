package com.example.demo.student;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDto {

    @NotEmpty(message = "gg")
    private String firstName;

    private String lastName;

    private String email;

    Integer schoolId;
}
