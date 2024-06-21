package umc.umcMission.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import umc.umcMission.domain.common.BaseEntity;
import umc.umcMission.domain.enums.Gender;
import umc.umcMission.domain.enums.MemberStatus;
import umc.umcMission.domain.enums.SocialType;
import umc.umcMission.domain.mapping.MemberAlarm;
import umc.umcMission.domain.mapping.MemberMission;
import umc.umcMission.domain.mapping.MemberPrefer;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Column
    private String imgUrl;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Integer myPoint;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private String birthday; // YYYY-MM-DD 형식

    @Column(nullable = false)
    private String address;

//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private List<FoodType> foodTypeList;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status;

    @Column // 소셜로그인 아직 구현하지 않은 상태이므로 nullable허용 후 진행
    private String email;

    @Column(nullable = false)
    private String phoneNum;

    @Column(nullable = false)
    private boolean alarmConfirmed; // 알람 설정 했는지

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAlarm> memberAlarmList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> memberReviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();
}
