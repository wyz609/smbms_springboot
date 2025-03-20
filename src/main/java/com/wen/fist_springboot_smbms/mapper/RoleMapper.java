package com.wen.fist_springboot_smbms.mapper;

import com.wen.fist_springboot_smbms.pojo.Role;

import java.util.List;

/**
 * Class name: RoleMapper
 * Package: com.wen.fist_springboot_smbms.mapper
 * Description: 用户角色的mapper接口
 *
 * @Create: 2025/3/20 13:23
 * @Author: jay
 * @Version: 1.0
 */
public interface RoleMapper {
    // 获取角色列表
    List<Role> getRoleList();
}
