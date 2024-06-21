package umc.umcMission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umcMission.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
