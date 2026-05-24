package com.enough.issuebe.dto;

import com.enough.issuebe.domain.OwnerCodeInf;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OwnerCodeInfResponse {

    private String workAreaCd;
    private String ownerCd;
    private String usageCd;

    public static OwnerCodeInfResponse from(OwnerCodeInf ownerCodeInf) {
        OwnerCodeInfResponse response = new OwnerCodeInfResponse();
        response.setWorkAreaCd(ownerCodeInf.getWorkAreaCd());
        response.setOwnerCd(ownerCodeInf.getOwnerCd());
        response.setUsageCd(ownerCodeInf.getUsageCd());
        return response;
    }
}
