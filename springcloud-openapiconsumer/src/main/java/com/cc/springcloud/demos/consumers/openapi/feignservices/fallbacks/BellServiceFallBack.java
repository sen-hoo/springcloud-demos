package com.cc.springcloud.demos.consumers.openapi.feignservices.fallbacks;

import com.cc.springcloud.demos.facades.belle.BelleService;
import com.cc.springcloud.dto.Belle;
import org.springframework.stereotype.Component;

@Component
public class BellServiceFallBack implements BelleService {
    @Override
    public Belle genStanderBelle() {
        return null;
    }
}
