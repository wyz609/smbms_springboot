package com.wen.fist_springboot_smbms.service.Role;

import com.wen.fist_springboot_smbms.mapper.RoleMapper;
import com.wen.fist_springboot_smbms.pojo.Role;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class name: RoleServiceImpl
 * Package: com.wen.fist_springboot_smbms.Role
 * Description:
 *
 * @Create: 2025/3/20 16:19
 * @Author: jay
 * @Version: 1.0
 */
@Service
public class RoleServiceImpl implements RoleService{

    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> getRoleList() {
        return roleMapper.getRoleList();
    }
}

