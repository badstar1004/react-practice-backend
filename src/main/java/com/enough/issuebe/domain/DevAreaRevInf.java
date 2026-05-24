package com.enough.issuebe.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DevAreaRevInf {

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
}
