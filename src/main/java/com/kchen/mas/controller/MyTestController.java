package com.kchen.mas.controller;

import com.kchen.mas.service.impl.MyTestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class MyTestController {

    @Autowired
    private MyTestServiceImpl myTestService;

    @GetMapping("/hello")
    public String hello() {
        myTestService.test();
        return "hello world";
    }
}
