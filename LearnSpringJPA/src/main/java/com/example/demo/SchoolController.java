package com.example.demo;

import com.example.demo.Service.SchoolService;
import com.example.demo.repository.SchoolRepostory;
import com.example.demo.school.School;
import com.example.demo.school.SchoolDto;
import com.example.demo.school.SchoolRespone;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolController {
    private final SchoolRepostory schoolRepostory;
    private final SchoolService schoolService;

    public SchoolController(SchoolRepostory schoolRepostory, SchoolService schoolService) {
        this.schoolRepostory = schoolRepostory;
        this.schoolService = schoolService;
    }

    @PostMapping("/schools")
    public SchoolRespone create(
          @Valid @RequestBody SchoolDto school
    ) {
        return this.schoolService.createSchool(school);
    }


    @GetMapping("/school/get")
    public List<SchoolRespone> get(
    ) {
        return this.schoolService.getAlLSchool();
    }
}
