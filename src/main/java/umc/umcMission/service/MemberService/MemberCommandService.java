package umc.umcMission.service.MemberService;

import umc.umcMission.domain.Member;
import umc.umcMission.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    public Member joinMember(MemberRequestDTO.JoinDto request);
    }
