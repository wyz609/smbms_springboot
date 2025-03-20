package com.wen.fist_springboot_smbms.mapper;

import com.wen.fist_springboot_smbms.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Class name: UserMapper
 * Package: com.wen.fist_springboot_smbms.mapper
 * Description: 用户信息的mapper接口
 *
 * @Create: 2025/3/20 13:54
 * @Author: jay
 * @Version: 1.0
 */
public interface UserMapper {

    //登录查询用户信息
    User getLoginInfo(String userCode);

    int updatePassword(@Param("id") int id, @Param("newPsd") String newPsd);

    int getUserCounts(@Param("username") String username,@Param("userRole") int userRole);

    List<User> getUserList(@Param("username") String username,@Param("userRole") int userRole,
                           @Param("offset") int offset, @Param("pageSize") int pageSize);

    int addUser(User user);

    int deleteUser(@Param("id") int id);

    User findById(@Param("id") int id);

    int modify(@Param("id") int id, @Param("user") User user);
}
