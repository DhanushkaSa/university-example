package com.university.universityInfo.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GraduateDto {
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private Integer age;

    private Long id;
}
