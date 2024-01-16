package com.HealthCare.HealthyLife_Backend.dto;

import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommunityCategoryDto {
    private Long categoryId;
    private String categoryName;
    private String email;
}