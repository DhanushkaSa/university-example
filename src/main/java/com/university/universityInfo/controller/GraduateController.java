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

import com.university.universityInfo.dto.GraduateDto;
import com.university.universityInfo.entity.Graduate;
import com.university.universityInfo.entity.University;
import com.university.universityInfo.service.GraduateService;
import com.university.universityInfo.service.UniversityService;

@RestController
public class GraduateController {

    @Autowired
    public GraduateService graduateService;

    @Autowired
    public UniversityService universityService;

    @PostMapping("/graduate")
    public ResponseEntity<?> createGraduate(@RequestBody GraduateDto graduateDto) {
        Graduate createGraduate = new Graduate();
        createGraduate.setName(graduateDto.getName());
        createGraduate.setAge(graduateDto.getAge());

        University university = universityService.getUni(graduateDto.getId());
        if (university == null) {
            return ResponseEntity.status(404).body("University not found");
        } else {
            createGraduate.setUniversity(university);
            return ResponseEntity.status(201).body(graduateService.createGraduate(createGraduate));
        }
    }

    @GetMapping("/graduate")
    public ResponseEntity<List<Graduate>> getAllGraduate() {
        return ResponseEntity.status(200).body(graduateService.getAllGraduate());
    }

    @GetMapping("/graduate/{graduateId}")
    public ResponseEntity<?> getGraduate(@PathVariable Long graduateId) {
        Graduate graduate = graduateService.getGraduate(graduateId);
        if (graduate == null) {
            return ResponseEntity.status(404).body("Graduate not found");
        } else {
            return ResponseEntity.status(200).body(graduate);
        }
    }

    @PutMapping("/graduate/{graduateId}")
    public ResponseEntity<?> updateGraduate(@PathVariable Long graduateId, @RequestBody GraduateDto graduateDto) {
        Graduate createGraduate = new Graduate();
        createGraduate.setName(graduateDto.getName());
        createGraduate.setAge(graduateDto.getAge());

        University university = universityService.getUni(graduateDto.getId());
        if (university == null) {
            return ResponseEntity.status(404).body("University not found");
        } else {
            createGraduate.setUniversity(university);
            return ResponseEntity.status(201).body(graduateService.updateGraduate(graduateId, createGraduate));
        }
    }

    @DeleteMapping("/graduate/{graduateId}")
    public void deleteGraduate(@PathVariable Long graduateId) {
        graduateService.deleteGraduate(graduateId);
    }
}
