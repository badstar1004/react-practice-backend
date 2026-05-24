package com.enough.issuebe.dto;

import com.enough.issuebe.domain.DevAreaRevInf;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DevAreaRevInfResponse {

    private String devAreaCd;
    private String ownerCd;
    private String usageCd;
    private Integer finalRev;
    private String revStatus;
    private String revDesc;
    private String createUser;
    private String createDt;
    private String updateUser;
    private String updateDt;

    public static DevAreaRevInfResponse from(DevAreaRevInf devAreaRevInf) {
        DevAreaRevInfResponse response = new DevAreaRevInfResponse();
        response.setDevAreaCd(devAreaRevInf.getDevAreaCd());
        response.setOwnerCd(devAreaRevInf.getOwnerCd());
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
