package com.enough.issuebe.service;

import com.enough.issuebe.domain.DevAreaRevInf;
import com.enough.issuebe.dto.DevAreaResponse;
import com.enough.issuebe.dto.DevAreaRevOwnerGroupResponse;
import com.enough.issuebe.dto.DevAreaRevSearchRequest;
import com.enough.issuebe.dto.DevAreaRevUsageItemResponse;
import com.enough.issuebe.exception.BusinessException;
import com.enough.issuebe.mapper.DevAreaMapper;
import com.enough.issuebe.mapper.DevAreaRevInfMapper;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
    public List<DevAreaRevOwnerGroupResponse> getDevAreaRevList(DevAreaRevSearchRequest request) {
        if (request == null) {
            throw new BusinessException("조회 조건이 올바르지 않습니다.");
        }

        String devAreaCd = validateDevAreaCd(request.getDevAreaCd());
        List<DevAreaRevInf> allRows = devAreaRevInfMapper.selectDevAreaRevList(devAreaCd);

        return toOwnerGroupList(allRows);
    }

    /**
     * devAreaCd 전체 Rev 중 최종 Rev 행만 ownerCd 기준으로 묶어 usageList 중첩 응답 생성
     * (프론트 resolveFinalRevRows · flattenRevListRows와 호환)
     */
    private List<DevAreaRevOwnerGroupResponse> toOwnerGroupList(List<DevAreaRevInf> allRows) {
        if (allRows == null || allRows.isEmpty()) {
            return List.of();
        }

        int maxFinalRev = allRows.stream()
                .mapToInt(row -> row.getFinalRev() != null ? row.getFinalRev() : 0)
                .max()
                .orElse(0);

        List<DevAreaRevInf> finalRevRows = allRows.stream()
                .filter(row -> Objects.equals(row.getFinalRev(), maxFinalRev))
                .sorted(Comparator.comparing(DevAreaRevInf::getOwnerCd))
                .collect(Collectors.toList());

        Map<String, DevAreaRevOwnerGroupResponse> grouped = new LinkedHashMap<>();

        for (DevAreaRevInf row : finalRevRows) {
            DevAreaRevOwnerGroupResponse group = grouped.computeIfAbsent(
                    row.getOwnerCd(),
                    ownerCd -> {
                        DevAreaRevOwnerGroupResponse created = new DevAreaRevOwnerGroupResponse();
                        created.setDevAreaCd(row.getDevAreaCd());
                        created.setOwnerCd(ownerCd);
                        created.setFinalRev(row.getFinalRev());
                        return created;
                    });

            group.getUsageList().add(DevAreaRevUsageItemResponse.from(row));
        }

        return new ArrayList<>(grouped.values());
    }

    private String validateDevAreaCd(String devAreaCd) {
        if (!StringUtils.hasText(devAreaCd)) {
            throw new BusinessException("devAreaCd는 필수입니다.");
        }

        return devAreaCd.trim();
    }
}
