package umc.umcMission.apiPayload.exception.Handler;

import umc.umcMission.apiPayload.code.BaseErrorCode;
import umc.umcMission.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
