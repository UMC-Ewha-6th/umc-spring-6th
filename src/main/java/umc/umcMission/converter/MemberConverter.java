package umc.umcMission.converter;

import umc.umcMission.domain.Member;
import umc.umcMission.domain.enums.Gender;
import umc.umcMission.web.dto.MemberRequestDTO;
import umc.umcMission.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO joinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();

    }

    public static Member toMember(MemberRequestDTO.JoinDto request){

        Gender gender = null;

        switch(request.getGender()) {
            case 1:
                gender = Gender.MALE; break;
            case 2:
                gender = Gender.FEMALE; break;
        }

        return Member.builder()
                .birthday(request.getBirthday())
                .address(request.getAddress())
                .memberPreferList(new ArrayList<>())
                .gender(gender)
                .name(request.getName())
                .build();
    }
}
