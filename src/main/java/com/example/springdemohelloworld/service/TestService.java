package com.example.springdemohelloworld.service;

import com.example.springdemohelloworld.model.ModelRequest;
import com.example.springdemohelloworld.model.ModelResponse;

public interface TestService {
    ModelResponse getData(ModelRequest modelRequest);

    String changeData(String data);
}
