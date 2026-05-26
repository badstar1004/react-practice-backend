package com.enough.issuebe.controller;

import com.enough.issuebe.dto.DevAreaResponse;
import com.enough.issuebe.dto.DevAreaRevOwnerGroupResponse;
import com.enough.issuebe.dto.DevAreaRevSearchRequest;
import com.enough.issuebe.service.DevAreaRevService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dev-area-rev")
public class DevAreaRevController {

    private final DevAreaRevService devAreaRevService;

    @GetMapping("/dev-areas")
    public List<DevAreaResponse> getDevAreaList() {
        return devAreaRevService.getDevAreaList();
    }

    /**
     * devAreaCd 기준 Rev 목록 — ownerCd별 usageList 중첩 (프론트 devAreaRevGrid)
     */
    @GetMapping
    public List<DevAreaRevOwnerGroupResponse> getDevAreaRevList(DevAreaRevSearchRequest request) {
        return devAreaRevService.getDevAreaRevList(request);
    }
}
