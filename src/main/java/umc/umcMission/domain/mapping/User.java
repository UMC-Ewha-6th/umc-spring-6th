package umc.umcMission.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.umcMission.domain.common.BaseEntity;
import umc.umcMission.domain.enums.FoodType;
import umc.umcMission.domain.enums.Gender;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String imgUrl;

    @Column(nullable = false)
    private int myPoint;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private LocalDateTime birthday;

    @Column(nullable = false)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FoodType foodType;

    @Column(nullable = false)
    private boolean status;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNum;

    @Column(nullable = false)
    private boolean alarmConfirmed; // 알람 설정 했는지

    @OneToMany(mappedBy = "user")
    private List<Alarm> userAlarmList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Review> userReviewList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Mission> userMissionList = new ArrayList<>();

}
