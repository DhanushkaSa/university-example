package com.university.universityInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.university.universityInfo.entity.Graduate;
import com.university.universityInfo.repository.GraduateRepository;

@Service
public class GraduateServiceImpl implements GraduateService {

    @Autowired
    public GraduateRepository graduateRepository;

    @Override
    public Graduate createGraduate(Graduate graduate) {
        return graduateRepository.save(graduate);
    }

    @Override
    public List<Graduate> getAllGraduate() {
        return graduateRepository.findAll();
    }

    @Override
    public Graduate getGraduate(Long graduateId) {
        return graduateRepository.findById(graduateId).orElse(null);
    }

    @Override
    public Graduate updateGraduate(Long graduateId, Graduate graduate) {
        Graduate updateGraduate = graduateRepository.findById(graduateId).orElse(null);
        if (updateGraduate == null) {
            return null;
        } else {
            updateGraduate.setName(graduate.getName());
            updateGraduate.setAge(graduate.getAge());
            updateGraduate.setUniversity(graduate.getUniversity());
            Graduate update = graduateRepository.save(updateGraduate);
            return update;
        }

    }

    @Override
    public void deleteGraduate(Long graduateId) {
        graduateRepository.deleteById(graduateId);
    }

}
