package com.wen.fist_springboot_smbms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wen.fist_springboot_smbms.mapper")
public class FistSpringbootSmbmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FistSpringbootSmbmsApplication.class, args);
    }

}
