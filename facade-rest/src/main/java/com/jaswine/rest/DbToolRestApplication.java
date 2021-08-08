package com.jaswine.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Jaswine
 * @date 2021-07-22 09:05:06
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.jaswine")
public class DbToolRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbToolRestApplication.class,args);
    }
}
