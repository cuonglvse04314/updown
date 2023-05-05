package com.example.springdemohelloworld.service.impl;

import com.example.springdemohelloworld.model.HelloModel;
import com.example.springdemohelloworld.service.HelloWorldService;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public HelloModel helloWorldService() {
        return HelloModel.builder().name("hello world").build();
    }
}
