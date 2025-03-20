package com.wen.fist_springboot_smbms.service.User;

import com.wen.fist_springboot_smbms.pojo.User;

import java.util.List;

/**
 * Class name: UserService
 * Package: com.wen.fist_springboot_smbms.service.User
 * Description:
 *
 * @Create: 2025/3/20 16:21
 * @Author: jay
 * @Version: 1.0
 */
public interface UserService {

    // 用户登录
    User login(String userCode, String passWord);

    // 根据用户Id修改密码
    boolean updatePassword(int id, String passWord);

    // 用户管理 查询记录数
    int getUserCounts(String username, int userRole);

    // 更具不同条件来查询用户列表
    List<User> getUserList(String QueryUerName, int QueryUserRole, int currentPageNo, int pageSize);

    // 添加用户
    boolean addUser(User user);

    // 删除用户
    boolean deleteUser(int userId);

    // 根据用户id查询用户
    User findById(int userId);

    // 修改用户信息
    boolean modify(int id, User user);
}

