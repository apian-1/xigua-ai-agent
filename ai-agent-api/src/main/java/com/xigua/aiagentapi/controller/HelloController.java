package com.xigua.aiagentapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/helloTest")
    public String helloTest() {
        return "Hello World";
    }

}