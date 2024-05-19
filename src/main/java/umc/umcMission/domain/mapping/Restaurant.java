package umc.umcMission.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.umcMission.domain.enums.FoodType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String imgUrl;

    @Column(nullable = false)
    private boolean status; // 현재 주문 가능한지

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FoodType foodType;

    @OneToMany(mappedBy = "restaurant")
    private List<Menu> restaurantMenuList = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant")
    private List<Mission> restaurantMissionList = new ArrayList<>();
}
