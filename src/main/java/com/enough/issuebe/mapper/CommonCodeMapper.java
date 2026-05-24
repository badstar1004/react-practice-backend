package com.enough.issuebe.mapper;

import com.enough.issuebe.domain.CommonCode;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommonCodeMapper {

    List<CommonCode> selectCommonCodeList(@Param("groupCodes") List<String> groupCodes);
}
