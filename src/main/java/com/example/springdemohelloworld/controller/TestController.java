package com.example.springdemohelloworld.controller;

import com.example.springdemohelloworld.model.ModelResponse;
import com.example.springdemohelloworld.service.TestService;
import com.example.springdemohelloworld.service.impl.XmlServiceImpl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springdemohelloworld.model.ModelRequest;


@RestController
@AllArgsConstructor
@Slf4j
public class TestController {

    private final TestService testService;
    private final XmlServiceImpl xmlServiceImpl;

    @GetMapping("/validateCard")
    public ModelResponse helloWorldController(ModelRequest modelRequest, String xml) {
        //        String xmlString = "<employee>" +
//                "    <department>" +
//                "        <id>101</id>" +
//                "        <name>IT</name>" +
//                "    </department>" +
//                "    <firstName>Lokesh</firstName>" +
//                "    <id>1</id>" +
//                "    <lastName>Gupta</lastName>" +
//                "</employee>";
        xmlServiceImpl.checkXml(xml);
        ModelResponse modelResponse = testService.getData(modelRequest);
        log.info("modelResponse : " + modelResponse);
        return modelResponse;
    }
}
