package umc.umcMission.apiPayload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.umcMission.apiPayload.code.BaseCode;
import umc.umcMission.apiPayload.code.status.SuccessStatus;

@Getter @AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public class ApiResponse<T> {

    @JsonProperty("isSuccess")
    private final Boolean isSuccess; // 성공인지 아닌지 알려주는 필드

    private final String code; // HTTP 상태코드 너머, 좀 더 세부적인 응답 상황을 알려주기 위한 필드
    private final String message; // code에 추가적으로 세부적인 응답 상황을 알려주기 위한 필드

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result; // 실제로 클라이언트에게 필요한 데이터가 담김
        //result는 어떤 값이 올지 모르므로 generic으로 해줌


    // 성공한 경우 응답 생성

    public static <T> ApiResponse<T> onSuccess(T result){
        return new ApiResponse<>(true, SuccessStatus._OK.getCode() , SuccessStatus._OK.getMessage(), result);
    }

    public static <T> ApiResponse<T> of(BaseCode code, T result){
            return new ApiResponse<>(true, code.getReasonHttpStatus().getCode() , code.getReasonHttpStatus().getMessage(), result);
    }

    // 실패한 경우 응답 생성
    public static <T> ApiResponse<T> onFailure(String code, String message, T data){
        return new ApiResponse<>(true, code, message, data);
    }

}
