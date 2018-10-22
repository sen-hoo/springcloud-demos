package com.cc.springcloud.demos.configcenter.controllers;

import com.cc.springcloud.plugins.ResultUtil;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author sen.hu
 * @Date 2018/10/22 10:11
 **/
@RestController
public class MainController {


    @RequestMapping(value = "/platform/httputils/get")
    public ResultUtil.Result testPlatformHttpUtils(@RequestParam String name, @RequestHeader(name = "token") String token) {
        ResultUtil.Result result = ResultUtil.getSuccResult();
        result.addData("name", name);
        result.addData("token", token);
        return result;
    }

    @RequestMapping(value = "/platform/httputils/post", method = RequestMethod.POST)
    public ResultUtil.Result testPlatformHttpUtilsPost(@RequestBody String content) {
        ResultUtil.Result result = ResultUtil.getSuccResult();
        result.addData("body", content);
        return result;
    }

    @RequestMapping(value = "/platform/httputils/postform", method = RequestMethod.POST)
    public ResultUtil.Result testPlatformHttpUtilsPostForm(String name, Integer age) {
        ResultUtil.Result result = ResultUtil.getSuccResult();
        result.addData("name", name);
        result.addData("age", age);
        return result;
    }

}
