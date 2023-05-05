package com.example.springdemohelloworld.controller;

import com.example.springdemohelloworld.model.HelloModel;
import com.example.springdemohelloworld.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping("/")
    public HelloModel helloWorldController() {
        return helloWorldService.helloWorldService();
    }
}
