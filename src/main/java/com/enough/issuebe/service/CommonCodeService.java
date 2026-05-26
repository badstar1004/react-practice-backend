package com.enough.issuebe.service;

import com.enough.issuebe.dto.CommonCodeListResponse;
import java.util.List;

public interface CommonCodeService {

    CommonCodeListResponse getCommonCodeList(List<String> groupCodes);
}
