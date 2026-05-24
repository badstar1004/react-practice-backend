package com.enough.issuebe.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.enough.issuebe.mapper")
public class MybatisConfig {
}
