package com.HealthCare.HealthyLife_Backend.entity;

import com.HealthCare.HealthyLife_Backend.dto.CalendarDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "calendar_tb")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Calendar {
    @Id
    @Column(name = "calendar_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "month")
    private int month;

    @Column(name = "title", nullable = false)
    private String title; //제목

    @Column(name = "detail", length = 1000)
    private String detail; // 내용

    @Column(name = "write_date", nullable = false)
    private LocalDate writeDate; //작성일자

    @Column(name = "points")
    private Integer points; // 포인트

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "body_id")
    private Body body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food;

    @OneToMany(mappedBy = "calendar", cascade = CascadeType.ALL)
    private List<SeasonRanking> seasonRankings;

    public CalendarDto toCalendarDto() {
        return CalendarDto.builder()
                .id(this.getId())
                .month(this.getMonth())
                .title(this.getTitle())
                .detail(this.getDetail())
                .writeDate(this.getWriteDate())
                .points(this.getPoints())
                .build();
    }
}
