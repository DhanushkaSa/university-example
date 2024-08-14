package com.university.universityInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.universityInfo.entity.Subject;
import com.university.universityInfo.repository.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    public SubjectRepository subjectRepository;

    @Override
    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public List<Subject> getAllSubject() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject getSubject(Long SubjectId) {
        return subjectRepository.findById(SubjectId).orElse(null);
    }

    @Override
    public Subject updateSubject(Long SubjectId, Subject subject) {
        Subject updateSubject = subjectRepository.findById(SubjectId).orElse(null);
        if (updateSubject == null) {
            return null;
        } else {
            updateSubject.setName(subject.getName());
            updateSubject.setCredits(subject.getCredits());
            Subject update=subjectRepository.save(updateSubject);
            return update;
        }
    }

    @Override
    public void deleteSubject(Long SubjectId) {
        subjectRepository.deleteById(SubjectId);
    }

}
