package com.enough.issuebe.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OwnerCodeSaveRequest {

    private String workAreaCd;
    private String ownerCd;
    private String usageCd;
}
