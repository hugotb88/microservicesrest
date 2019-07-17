package com.mastermicroservices.rest.webservices.microservicesrest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Victor Hugo Olvera Cruz
 * @subject
 */
//Controller
@RestController
public class HelloWorldController {

    //GET
    //URI - /hello-world
    //method "Hello World
    @RequestMapping(method= RequestMethod.GET, path="/hello-world")
    public String helloWorld(){
        return "Hello Hugo!";
    }


}
