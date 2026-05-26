package com.enough.issuebe.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * devAreaCd + ownerCd 기준 그룹 (프론트 usageList 중첩 구조)
 */
@Getter
@Setter
public class DevAreaRevOwnerGroupResponse {

    private String devAreaCd;
    private String ownerCd;
    private Integer finalRev;
    private List<DevAreaRevUsageItemResponse> usageList = new ArrayList<>();
}
