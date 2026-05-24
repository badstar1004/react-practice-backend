package com.enough.issuebe.dto;

import com.enough.issuebe.domain.DevArea;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DevAreaResponse {

    private String devAreaCd;
    private String devAreaName;

    public static DevAreaResponse from(DevArea devArea) {
        DevAreaResponse response = new DevAreaResponse();
        response.setDevAreaCd(devArea.getDevAreaCd());
        response.setDevAreaName(devArea.getDevAreaName());
        return response;
    }
}
