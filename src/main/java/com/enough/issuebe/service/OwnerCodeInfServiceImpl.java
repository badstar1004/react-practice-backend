package com.enough.issuebe.service;

import com.enough.issuebe.domain.OwnerCodeInf;
import com.enough.issuebe.dto.OwnerCodeInfResponse;
import com.enough.issuebe.dto.OwnerCodeSaveRequest;
import com.enough.issuebe.dto.OwnerCodeSaveResponse;
import com.enough.issuebe.dto.OwnerCodeSearchRequest;
import com.enough.issuebe.exception.BusinessException;
import com.enough.issuebe.mapper.OwnerCodeInfMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class OwnerCodeInfServiceImpl implements OwnerCodeInfService {

    private static final String DEFAULT_WORK_AREA_CD = "DEFAULT";

    private final OwnerCodeInfMapper ownerCodeInfMapper;

    @Override
    public List<OwnerCodeInfResponse> getOwnerCodeList(OwnerCodeSearchRequest request) {
        OwnerCodeSearchRequest searchRequest = request != null ? request : new OwnerCodeSearchRequest();
        normalizeSearchRequest(searchRequest);

        return ownerCodeInfMapper.selectOwnerCodeList(searchRequest).stream()
                .map(OwnerCodeInfResponse::from)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public OwnerCodeSaveResponse saveOwnerCodeRows(List<OwnerCodeSaveRequest> changedRows) {
        if (CollectionUtils.isEmpty(changedRows)) {
            throw new BusinessException("저장할 변경 데이터가 없습니다.");
        }

        List<OwnerCodeInfResponse> savedRows = new ArrayList<>();

        for (OwnerCodeSaveRequest row : changedRows) {
            validateSaveRow(row);

            OwnerCodeInf ownerCodeInf = toOwnerCodeInf(row);
            int updatedCount = ownerCodeInfMapper.updateUsageCd(ownerCodeInf);

            if (updatedCount == 0) {
                throw new BusinessException(
                        "저장 대상 데이터를 찾을 수 없습니다. (ownerCd: " + row.getOwnerCd() + ")");
            }

            savedRows.add(OwnerCodeInfResponse.from(ownerCodeInf));
        }

        OwnerCodeSaveResponse response = new OwnerCodeSaveResponse();
        response.setSavedCount(savedRows.size());
        response.setSavedRows(savedRows);
        return response;
    }

    private void normalizeSearchRequest(OwnerCodeSearchRequest searchRequest) {
        if (StringUtils.hasText(searchRequest.getOwnerCd())) {
            searchRequest.setOwnerCd(
                    searchRequest.getOwnerCd().replaceAll("[^A-Za-z0-9]", "").toUpperCase());
        }
    }

    private void validateSaveRow(OwnerCodeSaveRequest row) {
        if (row == null) {
            throw new BusinessException("저장 요청 데이터가 올바르지 않습니다.");
        }

        if (!StringUtils.hasText(row.getOwnerCd())) {
            throw new BusinessException("ownerCd는 필수입니다.");
        }

        if (!StringUtils.hasText(row.getUsageCd())) {
            throw new BusinessException(
                    "용도가 선택되지 않은 데이터가 있습니다. (owner code: " + row.getOwnerCd() + ")");
        }
    }

    private OwnerCodeInf toOwnerCodeInf(OwnerCodeSaveRequest row) {
        OwnerCodeInf ownerCodeInf = new OwnerCodeInf();
        ownerCodeInf.setWorkAreaCd(
                StringUtils.hasText(row.getWorkAreaCd()) ? row.getWorkAreaCd() : DEFAULT_WORK_AREA_CD);
        ownerCodeInf.setOwnerCd(row.getOwnerCd().trim().toUpperCase());
        ownerCodeInf.setUsageCd(row.getUsageCd().trim());
        return ownerCodeInf;
    }
}
