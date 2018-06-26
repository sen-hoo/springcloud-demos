package com.cc.springcloud.demos.consumers.openapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OpenApiBoot {

    @Bean
    public RestTemplate genRestTmeplat() {
        return new RestTemplate();
    }


    public static void main( String[] args )
    {
        SpringApplication.run(OpenApiBoot.class, args);
    }
}
