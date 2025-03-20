package com.wen.fist_springboot_smbms.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * Class name: Role
 * Package: com.wen.fist_springboot_smbms.pojo
 * Description: 角色实体类
 *
 * @Create: 2025/3/19 16:01
 * @Author: jay
 * @Version: 1.0
 */
// 使用Lombok注解进行简化开发
@Data
@ToString
public class Role {
    private Integer id; //id
    private String roleCode; //角色编码
    private String roleName; // 角色名称
    private String createdBy; // 创建者
    private Date creationDate; // 创建时间
    private Integer modifyBy; // 更新者
    private Date modifyDate; // 更新时间
}

