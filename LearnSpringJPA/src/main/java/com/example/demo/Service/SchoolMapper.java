package com.example.demo.Service;

import com.example.demo.school.School;
import com.example.demo.school.SchoolDto;
import com.example.demo.school.SchoolRespone;
import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {

    public School createSchoolDto(SchoolDto schoolDto) {
        School school = new School();
        school.setName(schoolDto.getName());
        return school;
    }

    public SchoolRespone responeSchool(School school) {
        return new SchoolRespone(school.getName());
    }
}
