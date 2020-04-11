package com.mastermicroservices.rest.webservices.microservicesrest.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author victorolvera
 * This class will handle the exceptions and will give them the right format
 * Applies to all Controllers
 */
@ControllerAdvice //Shares in all Controllers
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    //Overrides this method
    @ExceptionHandler(Exception.class) //Specify which Exception we want to handle, this case is for all
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
        ExceptionResponse er =
        new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(er, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //Overrides this method
    public final ResponseEntity<Object> handleUserNotFoundExceptions(UserNotFoundException ex, WebRequest request){
        ExceptionResponse er =
        new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(er, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), "Validation failed", ex.getBindingResult().toString());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    //Overrides this method
    public final ResponseEntity<Object> handleNoUsersFoundException(NoUsersFoundException ex, WebRequest request){
        ExceptionResponse er =
                new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(er, HttpStatus.NO_CONTENT);
    }

    //Overrides this method
    public final ResponseEntity<Object> handleUserSaveException(UserSaveException ex, WebRequest request){
        ExceptionResponse er =
                new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(er, HttpStatus.METHOD_FAILURE);
    }
}

