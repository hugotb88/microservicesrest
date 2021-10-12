package com.mastermicroservices.rest.webservices.microservicesrest.controllers;

import com.mastermicroservices.rest.webservices.microservicesrest.pojos.SomeBean;
import com.mastermicroservices.rest.webservices.microservicesrest.pojos.SomeBeanTwo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean retrieveSomeBean(){
        return new SomeBean("value1","value2","value3");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> retrieveSomeBeanList(){
        return Arrays.asList(
                new SomeBean("value1","value2","value3"),
                new SomeBean("value21","value22","value23"));
    }

    @GetMapping("/filtering-list-example-two")
    public List<SomeBeanTwo> retrieveSomeBeanTwoList(){
        return Arrays.asList(
                new SomeBeanTwo("value1","value2","value3"),
                new SomeBeanTwo("value21","value22","value23"));
    }
}
