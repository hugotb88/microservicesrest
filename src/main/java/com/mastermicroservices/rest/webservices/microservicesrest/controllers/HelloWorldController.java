package com.mastermicroservices.rest.webservices.microservicesrest.controllers;

import com.mastermicroservices.rest.webservices.microservicesrest.pojos.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * @author Victor Hugo Olvera Cruz
 * @subject
 */
//Controller
@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(path="/hello-world")
    public String helloWorld(){
        return "Hello Hugo!";
    }


    //Return a Bean
    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return  new HelloWorldBean("Hello Hugo!");
    }

    //With a Path Variable
    @GetMapping(path="/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return  new HelloWorldBean(String.format("Hello World, %s", name));
    }

    @GetMapping(path="/hello-world-internationalized")
    public String helloWorldInternationalized(){
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }
}
