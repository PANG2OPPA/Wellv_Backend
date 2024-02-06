package com.HealthCare.HealthyLife_Backend.repository;

import com.HealthCare.HealthyLife_Backend.dto.ExerciseDto;
import com.HealthCare.HealthyLife_Backend.dto.FoodDto;
import com.HealthCare.HealthyLife_Backend.entity.Exercise;
import com.HealthCare.HealthyLife_Backend.entity.Food;
import com.HealthCare.HealthyLife_Backend.utils.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    Page<Exercise> findAll(Pageable pageable);
    @Query("SELECT DISTINCT f FROM Exercise f " +
            "WHERE (:name IS NULL OR f.name LIKE %:name%) " +
            "AND (:muscle IS NULL OR f.muscle LIKE %:muscle%) " +
            "AND (:difficulty IS NULL OR f.difficulty LIKE %:difficulty%)")
    Page<Exercise> findByConditions(@Param("name") String name,
                                 @Param("muscle") String muscle,
                                 @Param("difficulty") String difficulty,
                                 Pageable pageable);

    ExerciseDto findByName(String keyword);

}