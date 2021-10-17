package com.mastermicroservices.rest.webservices.microservicesrest.pojos;

import javax.persistence.*;


/**
 * A @User can have multiple @Post, a @Post can only have one @User
 * (One to Many)
 * */
@Entity
public class Post {

    //Attributes
    @Id
    @GeneratedValue
    private Integer id;
    private String description;

    @ManyToOne(fetch= FetchType.LAZY)
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
