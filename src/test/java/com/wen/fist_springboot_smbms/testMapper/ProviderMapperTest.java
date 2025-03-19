package com.wen.fist_springboot_smbms.testMapper;

import com.wen.fist_springboot_smbms.mapper.ProviderMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Class name: ProviderMapperTest
 * Package: com.wen.fist_springboot_smbms.testMapper
 * Description:
 *
 * @Create: 2025/3/19 9:31
 * @Author: jay
 * @Version: 1.0
 */
@SpringBootTest
public class ProviderMapperTest {

    @Resource
    private ProviderMapper providerMapper;


    @Test
    public void testGetProviderCounts(){

        int counts = providerMapper.getProviderCounts(null, null);
        System.out.println("供应商总数" + counts);
        assertTrue(counts >= 0);
    }

}

