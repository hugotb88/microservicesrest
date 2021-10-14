package com.mastermicroservices.rest.webservices.microservicesrest.versioning;

public class Name {

    //Attributes
    private String firstName;
    private String lastName;

    //Constructors
    public Name() {
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
