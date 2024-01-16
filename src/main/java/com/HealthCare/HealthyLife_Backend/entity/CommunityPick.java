package com.HealthCare.HealthyLife_Backend.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pick") // 실제 데이터베이스 테이블 이름에 맞게 지정해야 합니다.
@Getter
@Setter
@NoArgsConstructor
public class CommunityPick {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "communityId")
    private Community community;

    @Column(name = "ip")
    private String ip;

    @Column(name = "isPick")
    private boolean isPick; // true일 경우 추천, false일 경우 비추천
    @Column(name = "email")
    private String email;

}