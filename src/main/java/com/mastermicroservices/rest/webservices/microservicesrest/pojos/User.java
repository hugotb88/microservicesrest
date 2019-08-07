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
    private LocalDate birthDate;


    //Contructors
    protected User(){}

    public User(Integer id, String name, LocalDate birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
