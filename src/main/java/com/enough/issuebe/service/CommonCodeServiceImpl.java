package com.enough.issuebe.service;

import com.enough.issuebe.domain.CommonCode;
import com.enough.issuebe.dto.CommonCodeListResponse;
import com.enough.issuebe.dto.CommonCodeResponse;
import com.enough.issuebe.mapper.CommonCodeMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@RequiredArgsConstructor
public class CommonCodeServiceImpl implements CommonCodeService {

    private static final String USAGE_GROUP_CODE = "USAGE_CD";

    private final CommonCodeMapper commonCodeMapper;

    @Override
    public CommonCodeListResponse getCommonCodeList(List<String> groupCodes) {
        List<String> targetGroupCodes = CollectionUtils.isEmpty(groupCodes)
                ? List.of(USAGE_GROUP_CODE)
                : groupCodes;

        List<CommonCode> commonCodes = commonCodeMapper.selectCommonCodeList(targetGroupCodes);
        List<CommonCodeResponse> usageCodeList = commonCodes.stream()
                .filter(code -> USAGE_GROUP_CODE.equals(code.getGroupCd()))
                .map(CommonCodeResponse::from)
                .collect(Collectors.toList());

        CommonCodeListResponse response = new CommonCodeListResponse();
        response.setUsageCodeList(usageCodeList);
        return response;
    }
}
