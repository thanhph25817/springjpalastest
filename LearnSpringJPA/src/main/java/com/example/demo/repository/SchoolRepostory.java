package com.example.demo.repository;

import com.example.demo.school.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepostory extends JpaRepository<School,Integer> {
}
