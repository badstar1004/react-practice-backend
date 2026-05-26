package com.enough.issuebe.controller;

import com.enough.issuebe.dto.CommonCodeListResponse;
import com.enough.issuebe.service.CommonCodeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/common-code")
public class CommonCodeController {

    private final CommonCodeService commonCodeService;

    @GetMapping
    public CommonCodeListResponse getCommonCodeList(
            @RequestParam(required = false) List<String> groupCodes,
            @RequestParam(value = "groupCodes[]", required = false) List<String> groupCodesWithBracket) {
        List<String> resolvedGroupCodes = groupCodes != null && !groupCodes.isEmpty()
                ? groupCodes
                : groupCodesWithBracket;
        return commonCodeService.getCommonCodeList(resolvedGroupCodes);
    }
}
