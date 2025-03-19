package com.wen.fist_springboot_smbms;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@SpringBootTest
class FistSpringbootSmbmsApplicationTests {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
    }

    /**
     * 查询供应商总数
     */
    @Test
    void testDatabasesConnection(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from smbms_bill");
        list.forEach(System.out::println);
    }

}
