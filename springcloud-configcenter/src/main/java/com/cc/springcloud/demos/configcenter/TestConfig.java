package com.cc.springcloud.demos.configcenter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestConfig {

    @Value("${nodelist}")
    private String redisNodeConfig;

    public String getRedisNodeConfig() {
        return redisNodeConfig;
    }
}
