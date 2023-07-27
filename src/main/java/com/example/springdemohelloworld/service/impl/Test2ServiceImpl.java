package com.example.springdemohelloworld.service.impl;

import com.example.springdemohelloworld.model.ModelResponse;
import com.example.springdemohelloworld.service.Test2Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class Test2ServiceImpl implements Test2Service {

    @Override
    public void checkData(ModelResponse modelResponse) {
        if (Objects.nonNull(modelResponse)) {
            log.info("success data " + modelResponse);
        } else {
            log.info("error data ");
        }

    }
}
