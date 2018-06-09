package com.springboot2.project01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestMain {

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String test(){
        return "success";
    }
}
