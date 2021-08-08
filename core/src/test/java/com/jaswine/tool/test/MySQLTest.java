package com.jaswine.tool.test;

import com.jaswine.tool.service.IDatabaseInfoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Jaswine
 * @date 2021-06-14 17:51:24
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class MySQLTest {



    @Resource
    private IDatabaseInfoService databaseInfoService;

    @Test
    private void  getDbInfo(){
        databaseInfoService.getTableInfo().forEach(item -> {
            System.out.println(item.toString());
        });
    }

    @Test
    private void test(){
        System.out.println("kkk");
    }

}
