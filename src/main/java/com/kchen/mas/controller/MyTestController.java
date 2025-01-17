package com.kchen.mas.controller;

import com.kchen.mas.entry.JsonResult;
import com.kchen.mas.exception.CustomException;
import com.kchen.mas.exception.ResourceNotFoundException;
import com.kchen.mas.service.impl.MyTestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/err")
    public JsonResult err(@RequestParam boolean isErr) {
        if (isErr) {
            throw new CustomException("cacas");
        }
        return JsonResult.SUCCESS();
    }
}
