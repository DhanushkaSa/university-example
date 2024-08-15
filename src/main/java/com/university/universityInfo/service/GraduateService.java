package com.university.universityInfo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.university.universityInfo.entity.Graduate;

@Service
public interface GraduateService  {

    public Graduate createGraduate(Graduate graduate);

    public List<Graduate> getAllGraduate();

    public Graduate getGraduate(Long graduateId);

    public Graduate updateGraduate(Long graduateId, Graduate graduate);

    public void deleteGraduate(Long graduateId);

}
