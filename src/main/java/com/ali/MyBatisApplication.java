package com.ali;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author QingzheHu
 * @date 2021/7/4 20:01
 */
@SpringBootApplication
@EnableScheduling
@MapperScan("com.ali.mapper")
public class MyBatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyBatisApplication.class, args);
    }
}
