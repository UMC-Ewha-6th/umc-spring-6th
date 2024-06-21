package umc.umcMission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umcMission.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
