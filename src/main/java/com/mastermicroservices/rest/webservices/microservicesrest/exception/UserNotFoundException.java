package com.mastermicroservices.rest.webservices.microservicesrest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) //This indicates what we are returning as http response
public class UserNotFoundException extends RuntimeException {


    //Overrides the super class constructor, one of them
    public UserNotFoundException(String message) {
        super(message);
    }
}
