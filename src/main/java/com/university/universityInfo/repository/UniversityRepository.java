package com.university.universityInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.universityInfo.entity.University;

@Repository
public interface UniversityRepository extends  JpaRepository<University,Long>{
    
}
