package com.example.springdemohelloworld.model;


import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.PROPERTY)
@Getter
@Setter
public class Employee implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String firstName;
    private String lastName;
    private Department department;
}
