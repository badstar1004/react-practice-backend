package com.enough.issuebe.service;

import com.enough.issuebe.dto.DevAreaResponse;
import com.enough.issuebe.dto.DevAreaRevInfResponse;
import com.enough.issuebe.dto.DevAreaRevSearchRequest;
import java.util.List;

public interface DevAreaRevService {

    List<DevAreaResponse> getDevAreaList();

    List<DevAreaRevInfResponse> getDevAreaRevList(DevAreaRevSearchRequest request);
}
