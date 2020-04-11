package com.mastermicroservices.rest.webservices.microservicesrest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class NoUsersFoundException extends RuntimeException {

    public NoUsersFoundException(String message) {
        super(message);
    }
}
