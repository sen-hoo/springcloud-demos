package com.cc.springcloud.demos.consumers.openapi.feignservices;

import com.cc.springcloud.demos.consumers.openapi.feignservices.fallbacks.BellServiceFallBack;
import com.cc.springcloud.demos.facades.belle.BelleService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "SERVICES-BELLE", fallback = BellServiceFallBack.class)
public interface BelleApi extends BelleService {

}
