package com.wen.fist_springboot_smbms.testService;

import com.wen.fist_springboot_smbms.pojo.User;
import com.wen.fist_springboot_smbms.service.User.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Class name: UserServiceTest
 * Package: com.wen.fist_springboot_smbms.testService
 * Description:
 *
 * @Create: 2025/3/20 17:16
 * @Author: jay
 * @Version: 1.0
 */
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testLogin(){
        User admin = userService.login("admin", "123456");
        System.out.println("登录用户：" + admin);
        assertNotNull(admin);
    }

    @Test
    public void testUpdatePassword(){
        User admin = userService.login("admin", "123456");
        boolean flag = userService.updatePassword(admin.getId(), "1234567");
        System.out.println(flag ? "修改成功" : "修改失败");
    }
}

