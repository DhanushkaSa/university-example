package com.university.universityInfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.university.universityInfo.entity.Subject;
import com.university.universityInfo.service.SubjectService;

@RestController
public class SubjectController {

    @Autowired
    public SubjectService subjectService;

    @PostMapping("/subjects")
    public ResponseEntity<?> createSubject(@RequestBody Subject subject) {
        if (subject.getName() == null || subject.getCredits() == null) {
            return ResponseEntity.status(404).body("All the attributes are required");
        } else {
            return ResponseEntity.status(201).body(subjectService.createSubject(subject));
        }
    }

    @GetMapping("/subjects")
    public ResponseEntity<List<Subject>> getAllSubjects() {
        return ResponseEntity.status(200).body(subjectService.getAllSubject());
    }

    @GetMapping("/subjects/{subjectId}")
    public ResponseEntity<?> getSubject(@PathVariable Long subjectId) {
        Subject subject = subjectService.getSubject(subjectId);
        
        if (subject == null) {
            return ResponseEntity.status(404).body("Subject not found");
        } else {
            return ResponseEntity.status(200).body(subject);
        }
    }

    @PutMapping("/subjects/{subjectId}")
    public ResponseEntity<?> updateSubject(@PathVariable Long subjectId, @RequestBody Subject subject) {
        Subject updateSubject = subjectService.updateSubject(subjectId, subject);

        if (updateSubject == null) {
            return ResponseEntity.status(404).body("Update fail");
        } else {
            return ResponseEntity.status(200).body(updateSubject);
        }
    }

    @DeleteMapping("/subjects/{subjectId}")
    public void deleteSubject(@PathVariable Long subjectId){
        subjectService.deleteSubject(subjectId);
    }
}
