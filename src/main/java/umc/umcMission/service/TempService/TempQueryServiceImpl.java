package umc.umcMission.service.TempService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.umcMission.apiPayload.code.status.ErrorStatus;
import umc.umcMission.apiPayload.exception.Handler.TempHandler;

@Service @RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService {

    @Override
    public void CheckFlag(Integer flag) {
        if(flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}
