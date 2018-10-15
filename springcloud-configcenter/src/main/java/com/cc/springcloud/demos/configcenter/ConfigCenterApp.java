package com.cc.springcloud.demos.configcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class ConfigCenterApp
{
    public static void main( String[] args )
    {
//        SpringApplication.run(ConfigCenterApp.class, args);
        try {
            ApplicationContext context = SpringApplication.run(ConfigCenterApp.class, args);
            TestConfig testConfig = context.getBean(TestConfig.class);
            System.out.println(testConfig.getRedisNodeConfig());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
