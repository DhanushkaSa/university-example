package com.university.universityInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.universityInfo.entity.University;
import com.university.universityInfo.repository.UniversityRepository;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    public UniversityRepository universityRepository;

    @Override
    public University createUni(University university) {
        return universityRepository.save(university);
    }

    @Override
    public List<University> getAllUni() {
        return universityRepository.findAll();
    }

    @Override
    public University getUni(Long uniId) {
        return universityRepository.findById(uniId).orElse(null);
    }

    @Override
    public University updateUni(Long uniId, University university) {
        University updateUniversity = universityRepository.findById(uniId).orElse(null);
        if (updateUniversity == null) {
            return null;
        } else {
            updateUniversity.setName(university.getName());
            updateUniversity.setLocation(university.getLocation());
            University saveUpdate = universityRepository.save(updateUniversity);
            return saveUpdate;
        }
    }

    @Override
    public void deleteUni(Long uniId) {
        universityRepository.deleteById(uniId);
    }

}
