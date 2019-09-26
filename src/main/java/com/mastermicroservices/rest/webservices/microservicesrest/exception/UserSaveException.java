package com.mastermicroservices.rest.webservices.microservicesrest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.METHOD_FAILURE)
public class UserSaveException extends RuntimeException {

    public UserSaveException(String message) {
        super(message);
    }
}
