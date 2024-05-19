package umc.umcMission.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.umcMission.domain.common.BaseEntity;
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String imgUrl;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private boolean isSuccess; // 미션 성공 여부

    @Column(nullable = false)
    private int point;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;
}
