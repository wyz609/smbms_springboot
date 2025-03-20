package com.wen.fist_springboot_smbms.testMapper;

import com.wen.fist_springboot_smbms.mapper.ProviderMapper;
import com.wen.fist_springboot_smbms.pojo.Provider;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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


    // 测试查询供应商总数测试类
    @Test
    public void testGetProviderCounts(){

        int counts = providerMapper.getProviderCounts(null, null);
        System.out.println("供应商总数" + counts);
        assertTrue(counts >= 0);
    }

    @Test
    public void testGenProviderList(){
        List<Provider> providerList = providerMapper.getProviderList(null, null, 0, 5);
        providerList.forEach(System.out::println);
        assertNotNull(providerList);
    }


    /**
     * 在该测试代码中遇到了 java 符号问题，说什么找不到builder()方法，因为这个问题找了半天，但是最后问题出在pom.xml配置文件中，在脚手架中勾选的Lombok会在pom.xml配置防止lombok
     * 在编译过程中被包含进来，导致控制台一直出现该问题，在网上找了很多种方法都没法解决，最终还是在pom.xml文件起手找问题，最终发现问题出在了插件配置中
     *
     */
    @Test
    public void testAddProvider(){
        Provider provider = Provider.builder()
                .proCode("P002")
                .proName("测试供应商")
                .proContact("张三")
                .proPhone("123456789")
                .proAddress("北京市")
                .proFax("010-123456")
                .proDesc("测试数据")
                .createdBy(1)
                .creationDate(new java.sql.Timestamp(System.currentTimeMillis()))
                .build();
        System.out.println(provider);
//        provider.setProCode("P002");
//        provider.setProName("测试供应商");
//        provider.setProContact("张三");
//        provider.setProPhone("123456789");
//        provider.setProAddress("北京市");
//        provider.setProFax("010-123456");
//        provider.setProDesc("测试数据");
//        provider.setCreatedBy(1);
//        provider.setCreationDate(new java.sql.Timestamp(System.currentTimeMillis()));
//        int result = providerMapper.addProvider(provider);
//        System.out.println("新增供应商结果" + result);
//        assertEquals(1,result);
    }

    // 该方法用来测试根据ID查询供应商
    @Test
    public void testFindById(){
        Provider provider = providerMapper.findById(1); // 这里的ID确保在数据库里存在
        System.out.println("查询供应商:" + provider);
        assertNotNull(provider);
    }

    @Test
    public void testModifyProvider(){
        Provider provider = providerMapper.findById(1);
        if(provider != null){
            provider.setProContact("张国栋");
            int result = providerMapper.modifyProvider(provider);
            System.out.println("修改供应商结果：" + result);
            assertEquals(result, 1);
        }else{
            fail("供应商不存在");
        }
    }
}

