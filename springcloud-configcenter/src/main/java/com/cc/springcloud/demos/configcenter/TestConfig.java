package com.cc.springcloud.demos.configcenter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class TestConfig {

    @Value("${redislist}")
    private String redisNodeConfig;

    public String getRedisNodeConfig() {
        return redisNodeConfig;
    }
}
