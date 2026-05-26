package com.enough.issuebe.dto;

import com.enough.issuebe.domain.DevAreaRevInf;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DevAreaRevUsageItemResponse {

    private String usageCd;
    private Integer finalRev;
    private String revStatus;
    private String revDesc;
    private String createUser;
    private String createDt;
    private String updateUser;
    private String updateDt;

    public static DevAreaRevUsageItemResponse from(DevAreaRevInf devAreaRevInf) {
        DevAreaRevUsageItemResponse response = new DevAreaRevUsageItemResponse();
        response.setUsageCd(devAreaRevInf.getUsageCd());
        response.setFinalRev(devAreaRevInf.getFinalRev());
        response.setRevStatus(devAreaRevInf.getRevStatus());
        response.setRevDesc(devAreaRevInf.getRevDesc());
        response.setCreateUser(devAreaRevInf.getCreateUser());
        response.setCreateDt(devAreaRevInf.getCreateDt());
        response.setUpdateUser(devAreaRevInf.getUpdateUser());
        response.setUpdateDt(devAreaRevInf.getUpdateDt());
        return response;
    }
}
