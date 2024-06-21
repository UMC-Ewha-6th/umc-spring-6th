package umc.umcMission.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.umcMission.domain.Alarm;
import umc.umcMission.domain.Member;
import umc.umcMission.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class MemberAlarm extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alarm_id")
    private Alarm alarms;
}
