package com.mastermicroservices.rest.webservices.microservicesrest.versioning;

public class PersonV1 {

    //Attributes
    private String name;

    //Constructors
    public PersonV1() {
    }

    public PersonV1(String name) {
        this.name = name;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
