package com.wen.fist_springboot_smbms.pojo;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

/**
 * Class name: User
 * Package: com.wen.fist_springboot_smbms.pojo
 * Description: 用户实体类
 *
 * @Create: 2025/3/19 16:15
 * @Author: jay
 * @Version: 1.0
 */
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id; // 用户ID
    private String userCode; //用户编码
    private String userName; // 用户名
    private String userPassword;
    private Integer gender; //性别
    private LocalDate birthday;
    private String phone;
    private String address;
    private Integer userRole;
    private Integer createdBy;
    private Date creationDate;
    private Integer modifyBy;
    private Date modifyDate;
    private Integer age;
    private String userRoleName;

    public Integer getAge(){
        AgeCalculator ageCalculator = new AgeCalculator();
        this.age = ageCalculator.calculateAge(this.birthday);
        return age;
    }
}

class AgeCalculator{
    public int calculateAge(LocalDate birthday){
        LocalDate now = LocalDate.now();
        return Period.between(birthday, now).getYears();
    }
}

