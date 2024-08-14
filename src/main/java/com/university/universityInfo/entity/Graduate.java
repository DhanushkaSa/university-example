package com.university.universityInfo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Graduate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gid;

    private String name;

    private Integer age;

    @ManyToOne
    @JoinColumn(name = "universityid")
    private University university;

    @ManyToMany(mappedBy = "graduates")

    private List<Subject> graduateSubjects;

}
