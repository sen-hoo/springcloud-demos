package com.cc.springcloud.demos.consumers.openapi.controllers;

import com.cc.springcloud.demos.consumers.openapi.feignservices.BelleApi;
import com.cc.springcloud.demos.facades.belle.BelleService;
import com.cc.springcloud.dto.Belle;
import com.cc.springcloud.plugins.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
@RequestMapping(value = "belle")
public class BelleController {

    private static final String BELLE_SERVICE_URL = "http://SERVICES-BELLE/belle";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private BelleApi belleApi;

    @RequestMapping(value = "get", produces = {"application/json; charset=utf-8"})
    public ResultUtil.Result getBelle() {
        ResultUtil.Result result = ResultUtil.getSuccResult();
        String callRet = restTemplate.getForEntity(BELLE_SERVICE_URL + "/gen", String.class).getBody();
        result.addData("serviceRet", callRet);
        return result;
    }

    @RequestMapping(value = "get1", produces = {"application/json; charset=utf-8"})
    public ResultUtil.Result getBelle1() {
        ResultUtil.Result result = ResultUtil.getSuccResult();
        ServiceInstance serviceInstance = loadBalancerClient.choose("SERVICES-BELLE");
        String host = serviceInstance.getHost();
        Integer port = serviceInstance.getPort();
        URI belleUri = URI.create(String.format("http://%s:%s/belle/gen", host, port));
        String callRet = restTemplate.getForEntity(belleUri, String.class).getBody();
        result.addData("serviceRet", callRet);
        return result;
    }

    @RequestMapping(value = "get2", produces = {"application/json; charset=utf-8"})
    public ResultUtil.Result getBelle2() {
        ResultUtil.Result result = ResultUtil.getSuccResult();
        Belle belle = belleApi.genStanderBelle();
        result.addData("serviceRet", belle);
        return result;
    }

}
