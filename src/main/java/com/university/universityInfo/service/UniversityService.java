package com.university.universityInfo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.university.universityInfo.entity.University;

@Service
public interface UniversityService {
    
    public University createUni(University university);

    public List<University> getAllUni();

    public University getUni(Long uniId);

    public University updateUni(Long uniId,University university);

    public void deleteUni(Long uniId);

}
