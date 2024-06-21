package umc.umcMission.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.umcMission.converter.MemberConverter;
import umc.umcMission.domain.Member;
import umc.umcMission.repository.MemberRepository;
import umc.umcMission.web.dto.MemberRequestDTO;

@Service @RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {
    private final MemberRepository memberRepository;

    @Override
    public Member joinMember(MemberRequestDTO.JoinDto request){

        return MemberConverter.toMember(request);
    }
}
