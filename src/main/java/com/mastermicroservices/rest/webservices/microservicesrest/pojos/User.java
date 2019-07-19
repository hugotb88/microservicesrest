package com.mastermicroservices.rest.webservices.microservicesrest.pojos;

import java.time.LocalDate;

/**
 * @author Victor Hugo Olvera Cruz
 * POJO User
 */
public class User {

    //Attributes
    private Integer id;
    private String name;
    private LocalDate date;


    //Contructor
    public User(Integer id, String name, LocalDate date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
