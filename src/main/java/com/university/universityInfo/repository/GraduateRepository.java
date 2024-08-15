package com.university.universityInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.universityInfo.entity.Graduate;

@Repository
public interface GraduateRepository extends  JpaRepository<Graduate, Long> {
        
}
