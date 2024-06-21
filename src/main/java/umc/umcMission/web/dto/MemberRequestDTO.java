package umc.umcMission.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.umcMission.validation.annotation.ExistCategories;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto{
        @NotNull
        String name;
        @NotNull
        Integer gender;
        @NotNull
        String birthday;
        @NotNull
        String address;
        @ExistCategories
        List<Long> preferFoodCategory;
    }

}
