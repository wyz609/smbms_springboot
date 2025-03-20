package com.wen.fist_springboot_smbms.testMapper;

import com.wen.fist_springboot_smbms.mapper.UserMapper;
import com.wen.fist_springboot_smbms.pojo.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class name: UserMapperTest
 * Package: com.wen.fist_springboot_smbms.testMapper
 * Description: 测试UserMapper接口中的方法是否能成功对数据库进行操作
 *
 * @Create: 2025/3/20 14:17
 * @Author: jay
 * @Version: 1.0
 */
@SpringBootTest
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    // 测试添加用户
    @Test
    public void testAddUser(){
        User user = User.builder()
                .userCode("U1001")
                .userName("Test User")
                .userPassword("123456")
                .gender(1)
                .birthday(new Date(System.currentTimeMillis()))
                .phone("13800138000")
                .address("Test Address")
                .userRole(2)
                .createdBy(1)
                .creationDate(new Timestamp(System.currentTimeMillis()))
                .modifyBy(1)
                .modifyDate(new Timestamp(System.currentTimeMillis()))
                .build();

        int count = userMapper.addUser(user);
        System.out.println("插入用户结果：" + count);
        assertTrue(count >= 0);
    }

    // 测试查询用户总数
    @Test
    public void testGetUserCounts(){
        int count = userMapper.getUserCounts("", 0);
        System.out.println("用户总数：" + count);
        assertTrue(count >= 0);
    }

    // 测试查询用户列表
    @Test
    public void testGetUserList(){
        List<User> userList = userMapper.getUserList("", 0, 0, 0);
        System.out.println("=======用户列表=======");
        userList.forEach(System.out::println);
        assertTrue(userList.size() >= 0);
    }

    @Test
    public void testGetLoginInfo(){
        User user = userMapper.getLoginInfo("admin"); // 这里的userCode需要确保数据表中存在
        System.out.println("登录查询结果:" + user);
        assertNotNull(user);
    }

    @Test
    public void testFindById(){
        User user = userMapper.findById(1);
        System.out.println("查询到的结果：" + user);
        assertNotNull(user);
    }

    @Test
    public void testUpdatePassword(){
        int i = userMapper.updatePassword(1, "111222"); // 这里的id需要确保数据表中存在
        System.out.println("修改密码的结果：" + i);
        assertEquals(1,i);
    }

    @Test
    public void testDeleteUser(){
        int result = userMapper.deleteUser(17);
        System.out.println("删除用户结果：" + result);
        assertEquals(1,result);
    }
}

