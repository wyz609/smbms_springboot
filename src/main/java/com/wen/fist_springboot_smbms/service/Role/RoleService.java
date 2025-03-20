package com.wen.fist_springboot_smbms.service.Role;

import com.wen.fist_springboot_smbms.pojo.Role;

import java.util.List;

/**
 * Class name: RoleService
 * Package: com.wen.fist_springboot_smbms.Role
 * Description:
 *
 * @Create: 2025/3/20 16:18
 * @Author: jay
 * @Version: 1.0
 */
public interface RoleService {

    // 获取角色列表
    List<Role> getRoleList();
}
