package com.mastermicroservices.rest.webservices.microservicesrest.exception;

import java.time.LocalDateTime;

/**
 * @author Victor Olvera
 * Base class for handling all Exceptions
 */
public class ExceptionResponse {

    //Attributes in our exception response message
    private LocalDateTime timestamp;
    private String message;
    private String details;

    //Constructor
    public ExceptionResponse(LocalDateTime timestamp, String message, String details) {
        super(); //Not really neccessary
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    //Getters
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
