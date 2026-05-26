package com.enough.issuebe.controller;

import com.enough.issuebe.dto.CommonCodeListResponse;
import com.enough.issuebe.dto.OwnerCodeInfResponse;
import com.enough.issuebe.dto.OwnerCodeSaveRequest;
import com.enough.issuebe.dto.OwnerCodeSaveResponse;
import com.enough.issuebe.dto.OwnerCodeSearchRequest;
import com.enough.issuebe.service.CommonCodeService;
import com.enough.issuebe.service.OwnerCodeInfService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/owner-code-inf")
public class OwnerCodeInfController {

    private final OwnerCodeInfService ownerCodeInfService;
    private final CommonCodeService commonCodeService;

    @GetMapping
    public List<OwnerCodeInfResponse> getOwnerCodeList(OwnerCodeSearchRequest request) {
        return ownerCodeInfService.getOwnerCodeList(request);
    }

    /** 프론트 commonCodeApi.js 호환 경로 */
    @GetMapping("/common-code-list")
    public CommonCodeListResponse getCommonCodeList(
            @RequestParam(required = false) List<String> groupCodes,
            @RequestParam(value = "groupCodes[]", required = false) List<String> groupCodesWithBracket) {
        return commonCodeService.getCommonCodeList(resolveGroupCodes(groupCodes, groupCodesWithBracket));
    }

    @PutMapping
    public OwnerCodeSaveResponse saveOwnerCodeRows(
            @RequestBody List<OwnerCodeSaveRequest> changedRows) {
        return ownerCodeInfService.saveOwnerCodeRows(changedRows);
    }

    private List<String> resolveGroupCodes(
            List<String> groupCodes,
            List<String> groupCodesWithBracket) {
        return groupCodes != null && !groupCodes.isEmpty() ? groupCodes : groupCodesWithBracket;
    }
}
