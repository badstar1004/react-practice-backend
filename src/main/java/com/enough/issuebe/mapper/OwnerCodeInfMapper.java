package com.enough.issuebe.mapper;

import com.enough.issuebe.domain.OwnerCodeInf;
import com.enough.issuebe.dto.OwnerCodeSearchRequest;
import java.util.List;
public interface OwnerCodeInfMapper {

    List<OwnerCodeInf> selectOwnerCodeList(OwnerCodeSearchRequest request);

    int updateUsageCd(OwnerCodeInf ownerCodeInf);
}
