package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.WebApplicationInitializer;

/**
 * @author Livre arbítrio
 * @date 2023/7/18
 * 公众号：无
 * 博  客：https://createres1.github.io/
 * @apiNote
 */
@SpringBootApplication // 启动SpringBoot自动配置
@EnableTransactionManagement // 启动事务管理器
//@MapperScan("com.dao") // 指定Dao接口包路径，自动生成实现类
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}

