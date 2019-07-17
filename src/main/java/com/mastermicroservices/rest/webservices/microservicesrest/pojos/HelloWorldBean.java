package com.mastermicroservices.rest.webservices.microservicesrest.pojos;

/**
 * @author Victor Hugo Olvera Cruz
 * @subject
 */
public class HelloWorldBean {

    private String message;

    //Constructor
    public HelloWorldBean(String message) {
        this.message = message;
    }

    //Getter
    public String getMessage() {
        return message;
    }


    //Setter
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
