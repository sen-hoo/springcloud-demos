package com.cc.springcloud.demos.services.belle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class BelleServiceBoot
{
    public static void main( String[] args )
    {
        SpringApplication.run(BelleServiceBoot.class, args);
    }
}
