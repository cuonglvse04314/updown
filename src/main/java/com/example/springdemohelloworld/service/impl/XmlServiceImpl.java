package com.example.springdemohelloworld.service.impl;

import com.example.springdemohelloworld.model.Employee;
import com.example.springdemohelloworld.service.XmlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@Service
@Slf4j
public class XmlServiceImpl implements XmlService {
    JAXBContext jaxbContext;

    @Override
    public void checkXml(String xml) {

        try {
            jaxbContext = JAXBContext.newInstance(Employee.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Employee employee = (Employee) jaxbUnmarshaller.unmarshal(new StringReader(xml));

            log.info("employee {}", employee);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
