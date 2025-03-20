package com.wen.fist_springboot_smbms.testMapper;

import com.wen.fist_springboot_smbms.mapper.RoleMapper;
import com.wen.fist_springboot_smbms.pojo.Role;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Class name: RoleMapperTest
 * Package: com.wen.fist_springboot_smbms.testMapper
 * Description:
 *
 * @Create: 2025/3/20 14:12
 * @Author: jay
 * @Version: 1.0
 */
@SpringBootTest
public class RoleMapperTest {

    @Resource
    private RoleMapper roleMapper;

    //测试是否能正常获取角色列表信息
    @Test
    public void testRoleList(){
        List<Role> roleList = roleMapper.getRoleList();
        System.out.println("=======展示角色列表=======");
        roleList.forEach(System.out::println);
    }
}

