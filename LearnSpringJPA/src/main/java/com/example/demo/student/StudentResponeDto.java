package com.example.demo.student;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.function.Function;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentResponeDto  {

    @NotNull(message = "khong null ")
    private String firstName;
    @NotEmpty
    private String lastName;

    private String email;
}
