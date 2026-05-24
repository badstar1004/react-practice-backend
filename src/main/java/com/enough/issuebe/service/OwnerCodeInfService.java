package com.enough.issuebe.service;

import com.enough.issuebe.dto.CommonCodeListResponse;
import com.enough.issuebe.dto.OwnerCodeInfResponse;
import com.enough.issuebe.dto.OwnerCodeSaveRequest;
import com.enough.issuebe.dto.OwnerCodeSaveResponse;
import com.enough.issuebe.dto.OwnerCodeSearchRequest;
import java.util.List;

public interface OwnerCodeInfService {

    List<OwnerCodeInfResponse> getOwnerCodeList(OwnerCodeSearchRequest request);

    CommonCodeListResponse getCommonCodeList(List<String> groupCodes);

    OwnerCodeSaveResponse saveOwnerCodeRows(List<OwnerCodeSaveRequest> changedRows);
}
