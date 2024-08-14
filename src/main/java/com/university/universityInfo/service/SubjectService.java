package com.university.universityInfo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.university.universityInfo.entity.Subject;

@Service
public interface SubjectService {

    public Subject createSubject(Subject subject);

    public List<Subject> getAllSubject();

    public Subject getSubject(Long SubjectId);

    public Subject updateSubject(Long SubjectId, Subject subject);

    public void deleteSubject(Long SubjectId);
}
