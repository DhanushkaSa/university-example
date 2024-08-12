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

import com.university.universityInfo.entity.University;
import com.university.universityInfo.service.UniversityService;

@RestController
public class UniversityController {

    @Autowired
    public UniversityService universityService;

    @PostMapping("/uni")
    public ResponseEntity<?> createUniversity(@RequestBody University university) {

        University newUniversity = universityService.createUni(university);
        if (newUniversity == null) {
            return ResponseEntity.status(404).body("Null value");
        } else {
            return ResponseEntity.status(201).body(newUniversity);
        }

    }

    @GetMapping("/uni")
    public ResponseEntity<List<University>> getAllUni() {
        return ResponseEntity.status(200).body(universityService.getAllUni());
    }

    @GetMapping("/uni/{uniId}")
    public ResponseEntity<?> getUni(@PathVariable Long uniId) {
        University university = universityService.getUni(uniId);
        if (university == null) {
            return ResponseEntity.status(404).body("University not found");
        } else {
            return ResponseEntity.status(200).body(university);
        }
    }

    @PutMapping("/uni/{uniId}")
    public ResponseEntity<?> updateUni(@PathVariable Long uniId, @RequestBody University university) {
        University updateUniversity = universityService.updateUni(uniId, university);
        if (updateUniversity == null) {
            return ResponseEntity.status(404).body("Update fail");
        }else{
            return ResponseEntity.status(200).body(updateUniversity);
        }
    }

    @DeleteMapping("/uni/{uniId}")
    public void deleteUni(@PathVariable Long uniId){
          universityService.deleteUni(uniId);
    }
}
