package com.enough.issuebe.mapper;

import com.enough.issuebe.domain.DevAreaRevInf;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DevAreaRevInfMapper {

    List<DevAreaRevInf> selectDevAreaRevList(@Param("devAreaCd") String devAreaCd);
}
