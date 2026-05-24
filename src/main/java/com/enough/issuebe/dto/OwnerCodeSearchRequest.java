package com.enough.issuebe.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OwnerCodeSearchRequest {

    private String ownerCd;
    private String usageCd;
    private Boolean noUsage;
}
