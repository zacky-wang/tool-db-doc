package com.jaswine.tool.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.io.*;
import java.util.Optional;
import java.util.Properties;


/**
 * @author Jaswine
 * @date 2021-06-08 23:50:28
 */
@Configuration
@MapperScan("com.jaswine.tool.mapper")
@Slf4j
public class MybatisConfig {


    /**
     * PerformanceMonitor plugin
     * @return PerformanceMonitor
     */
    @Bean
    public PerformanceMonitorInterceptor performanceMonitorInterceptor(){
        log.info("config SQL Performance Monitor");
        return new PerformanceMonitorInterceptor();
    }

    @Bean
    public DataSource druid() throws Exception {
        DruidDataSource dataSource = new DruidDataSource();
        String DB_PROPERTIES = "db.property";
        String propertyPath = System.getProperty(DB_PROPERTIES);
        File propertyFile = new File(propertyPath);
        if (!propertyFile.exists()){
          log.error("Database property file is not exist.");
          throw new  FileNotFoundException("Database property file is not exist.");
        }

        Properties properties = new Properties();
        properties.load(new BufferedReader(new FileReader(propertyFile)));

        Optional<Exception> validate = validate(properties);
        if (!Optional.empty().equals(validate)){
            throw validate.get();
        }

        dataSource.setUrl(properties.getProperty("url"));
        dataSource.setUsername(properties.getProperty("username"));
        dataSource.setPassword(properties.getProperty("password"));
        return dataSource;
    }

    private Optional<Exception> validate(Properties properties){
        if (!StringUtils.hasLength(properties.getProperty("url"))){
            log.error("Database property's url is null or blank.");
            return Optional.of( new IllegalArgumentException("Database property's url is null or blank."));
        }

        if (!StringUtils.hasLength(properties.getProperty("username"))){
            log.error("Database property's username is null or blank.");
            return Optional.of( new IllegalArgumentException("Database property's username is null or blank."));
        }

        if (!StringUtils.hasLength(properties.getProperty("password"))){
            log.error("Database property's password is null or blank.");
            return Optional.of( new IllegalArgumentException("Database property's password is null or blank."));
        }

        return Optional.empty();
    }

}
