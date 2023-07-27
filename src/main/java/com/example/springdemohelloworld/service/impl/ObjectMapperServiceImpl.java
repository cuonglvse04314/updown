package com.example.springdemohelloworld.service.impl;

import com.example.springdemohelloworld.model.Car;
import com.example.springdemohelloworld.service.ObjectMapperService;
import com.example.springdemohelloworld.service.TestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
@AllArgsConstructor
public class ObjectMapperServiceImpl implements ObjectMapperService {
    ObjectMapper objectMapper;
    TestService testService;

    @Override
    public String readValueObject(String json, String date) {
        Car car = new Car();
        json = testService.changeData(json);
        try {
            car = objectMapper.readValue(json, Car.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        String date2 = "no date";
        try {
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
            log.info("date1 {}", date1);
            date2 = date1.toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return car.toString().concat("   ").concat(date2);
    }
}
