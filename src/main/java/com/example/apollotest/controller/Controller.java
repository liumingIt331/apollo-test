package com.example.apollotest.controller;

import com.example.apollotest.springboot.SimpleRedisConfig;
import com.example.apollotest.springboot.TestJavaConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apollo")
public class Controller {

    @Autowired
    private TestJavaConfigBean javaConfigBean;

    @Autowired
    private SimpleRedisConfig simpleRedisConfig;

    @RequestMapping("/getConfig")
    public String getJavaConfigBean() {
        return javaConfigBean.toString();
    }

    @RequestMapping("/getRedisConfig")
    public String getRedisConfig() {
        return simpleRedisConfig.toString();
    }
}
