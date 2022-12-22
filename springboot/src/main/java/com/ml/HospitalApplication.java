package com.ml;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Auther:ml
 * @Date:2022/12/22 - 12 - 22 - 13:22
 * @Description:com.ml
 * @version: 1.0
 */

@MapperScan("com.ml.dao")
@SpringBootApplication
public class HospitalApplication {
    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class,args);
    }
}
