package com.university.universityInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.universityInfo.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {
    
}
