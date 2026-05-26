package com.enough.issuebe.service;

import com.enough.issuebe.dto.DevAreaResponse;
import com.enough.issuebe.dto.DevAreaRevOwnerGroupResponse;
import com.enough.issuebe.dto.DevAreaRevSearchRequest;
import java.util.List;

public interface DevAreaRevService {

    List<DevAreaResponse> getDevAreaList();

    List<DevAreaRevOwnerGroupResponse> getDevAreaRevList(DevAreaRevSearchRequest request);
}
