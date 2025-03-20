package com.wen.fist_springboot_smbms.service.User;

import com.wen.fist_springboot_smbms.mapper.UserMapper;
import com.wen.fist_springboot_smbms.pojo.User;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class name: UserServiceImpl
 * Package: com.wen.fist_springboot_smbms.service.User
 * Description:
 *
 * @Create: 2025/3/20 16:31
 * @Author: jay
 * @Version: 1.0
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(String userCode, String passWord) {
        return userMapper.getLoginInfo(userCode);
    }

    @Override
    public boolean updatePassword(int id, String passWord) {
        return userMapper.updatePassword(id,passWord) > 0;
    }

    @Override
    public int getUserCounts(String username, int userRole) {
        return userMapper.getUserCounts(username,userRole);
    }

    @Override
    public List<User> getUserList(String QueryUerName, int QueryUserRole, int currentPageNo, int pageSize) {
        return userMapper.getUserList(QueryUerName,QueryUserRole,currentPageNo,pageSize);
    }

    @Override
    public boolean addUser(User user) {
        return userMapper.addUser(user) > 0;
    }

    @Override
    public boolean deleteUser(int userId) {
        return userMapper.deleteUser(userId) > 0;
    }

    @Override
    public User findById(int userId) {
        return userMapper.findById(userId);
    }

    @Override
    public boolean modify(int id, User user) {
        return userMapper.modify(id,user) > 0;
    }
}

