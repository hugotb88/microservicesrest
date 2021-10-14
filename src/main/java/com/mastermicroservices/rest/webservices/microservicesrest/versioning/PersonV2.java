package com.mastermicroservices.rest.webservices.microservicesrest.versioning;

public class PersonV2 {
    //Attributes
    private Name name;

    //Constructors
    public PersonV2() {
    }

    public PersonV2(Name name) {
        this.name = name;
    }

    //Getters and Setters
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
