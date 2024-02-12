package com.HealthCare.HealthyLife_Backend.entity.calendar;

import com.HealthCare.HealthyLife_Backend.dto.calendar.MealDto;
import com.HealthCare.HealthyLife_Backend.entity.Food;
import com.HealthCare.HealthyLife_Backend.entity.Member;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name = "meal_tb")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Meal {
    @Id
    @Column(name = "meal_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "meal_type")
    private String mealType; // 식사유형 (아침,점심,저녁)

    @Column(name = "meal_name")
    private String mealName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email", referencedColumnName = "email")
    private Member member;

    @Column(name = "reg_date")
    private String regDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "calendar_id")
    private Calendar calendar;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "name", referencedColumnName = "name")
    private Food food;


    public MealDto toMealDto() {
        return MealDto.builder()
                .mealType(this.getMealType())
                .mealName(this.getMealName())
                .member(this.getMember())
                .regDate(this.getRegDate())
                .build();
    }

}
