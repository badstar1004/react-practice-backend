package com.enough.issuebe.service;

import com.enough.issuebe.dto.DevAreaResponse;
import com.enough.issuebe.dto.DevAreaRevInfResponse;
import com.enough.issuebe.dto.DevAreaRevSearchRequest;
import com.enough.issuebe.exception.BusinessException;
import com.enough.issuebe.mapper.DevAreaMapper;
import com.enough.issuebe.mapper.DevAreaRevInfMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class DevAreaRevServiceImpl implements DevAreaRevService {

    private final DevAreaMapper devAreaMapper;
    private final DevAreaRevInfMapper devAreaRevInfMapper;

    @Override
    public List<DevAreaResponse> getDevAreaList() {
        return devAreaMapper.selectDevAreaList().stream()
                .map(DevAreaResponse::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<DevAreaRevInfResponse> getDevAreaRevList(DevAreaRevSearchRequest request) {
        if (request == null) {
            throw new BusinessException("조회 조건이 올바르지 않습니다.");
        }

        String devAreaCd = validateDevAreaCd(request.getDevAreaCd());

        return devAreaRevInfMapper.selectDevAreaRevList(devAreaCd).stream()
                .map(DevAreaRevInfResponse::from)
                .collect(Collectors.toList());
    }

    private String validateDevAreaCd(String devAreaCd) {
        if (!StringUtils.hasText(devAreaCd)) {
            throw new BusinessException("devAreaCd는 필수입니다.");
        }

        return devAreaCd.trim();
    }
}
