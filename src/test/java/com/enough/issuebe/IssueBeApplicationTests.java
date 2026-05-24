package com.enough.issuebe;

import com.enough.issuebe.mapper.CommonCodeMapper;
import com.enough.issuebe.mapper.DevAreaMapper;
import com.enough.issuebe.mapper.DevAreaRevInfMapper;
import com.enough.issuebe.mapper.OwnerCodeInfMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class IssueBeApplicationTests {

    @MockBean
    private OwnerCodeInfMapper ownerCodeInfMapper;

    @MockBean
    private CommonCodeMapper commonCodeMapper;

    @MockBean
    private DevAreaMapper devAreaMapper;

    @MockBean
    private DevAreaRevInfMapper devAreaRevInfMapper;

    @Test
    void contextLoads() {
    }
}
