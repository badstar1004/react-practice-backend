package com.enough.issuebe.service;

import com.enough.issuebe.dto.DevAreaResponse;
import com.enough.issuebe.dto.DevAreaRevInfResponse;
import com.enough.issuebe.dto.DevAreaRevSearchRequest;
import java.util.List;

public interface DevAreaRevService {

    List<DevAreaResponse> getDevAreaList();

    /**
     * devAreaCd 기준 Rev 전체 목록 (프론트 saga resolveFinalRevRows에서 최종 Rev 필터)
     */
    List<DevAreaRevInfResponse> getDevAreaRevList(DevAreaRevSearchRequest request);
}
