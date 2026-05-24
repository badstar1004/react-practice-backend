package com.enough.issuebe.dto;

import com.enough.issuebe.domain.CommonCode;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonCodeResponse {

    private String code;
    private String name;

    public static CommonCodeResponse from(CommonCode commonCode) {
        CommonCodeResponse response = new CommonCodeResponse();
        response.setCode(commonCode.getCode());
        response.setName(commonCode.getName());
        return response;
    }

    public static List<CommonCodeResponse> fromList(List<CommonCode> commonCodes) {
        return commonCodes.stream()
                .map(CommonCodeResponse::from)
                .collect(Collectors.toList());
    }
}
