package com.example.springdemohelloworld.service.impl;

import com.example.springdemohelloworld.model.ModelRequest;
import com.example.springdemohelloworld.model.ModelResponse;
import com.example.springdemohelloworld.service.Test2Service;
import com.example.springdemohelloworld.service.TestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class TestServiceImpl implements TestService {

    private final Test2Service test2Service;

    @Override
    public ModelResponse getData(ModelRequest modelRequest) {

        ModelResponse modelResponse = new ModelResponse();
        if (modelRequest != null && modelRequest.getOrdr_tel() != null) {
            switch (modelRequest.getOrdr_tel()) {
                case "0111111111":
                    modelResponse.setResResult("OK");
                    modelResponse.setReasonCode("LRT");
                    break;
                case "0222222222":
                    modelResponse.setResResult("OK");
                    modelResponse.setReasonCode("BIAT");
                    break;
                case "0333333333":
                    modelResponse.setResResult("OK");
                    modelResponse.setReasonCode("MM");
                    break;
                case "0444444444":
                    modelResponse.setResResult("OK");
                    modelResponse.setReasonCode("NMV");
                    break;
                case "0555555555":
                    modelResponse.setResResult("OK");
                    modelResponse.setReasonCode("SGE");
                    break;
                case "0666666666":
                    modelResponse.setResResult("OK");
                    modelResponse.setReasonCode("UB");
                    break;
                default:
                    modelResponse.setResResult("NG");
            }
        } else {
            modelResponse.setResResult("NG");
            modelResponse.setReasonCode("NG");
        }

        test2Service.checkData(modelResponse);

        return modelResponse;
    }

    @Override
    public String changeData(String data) {
        if (data != null) {
            data = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        }
        return data;
    }
}
