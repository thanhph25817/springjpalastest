package com.example.demo.Service;

import com.example.demo.repository.SchoolRepostory;
import com.example.demo.school.School;
import com.example.demo.school.SchoolDto;
import com.example.demo.school.SchoolRespone;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class SchoolService {

    private final SchoolMapper schoolMapper;
    private final SchoolRepostory schoolRepostory;

    public SchoolService(SchoolMapper schoolMapper, SchoolRepostory schoolRepostory) {
        this.schoolMapper = schoolMapper;
        this.schoolRepostory = schoolRepostory;
    }

    public SchoolRespone createSchool(
            @RequestBody SchoolDto school
    ) {
        School school1 = this.schoolMapper.createSchoolDto(school);

        SchoolRespone schoolRespone = this.schoolMapper.responeSchool(school1);
        return schoolRespone;
    }

    public List<SchoolRespone> getAlLSchool(
    ) {
        return schoolRepostory.findAll().stream().map(schoolMapper::responeSchool).collect(Collectors.toList());
    }
}
