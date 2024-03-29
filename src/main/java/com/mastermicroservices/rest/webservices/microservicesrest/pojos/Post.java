package com.mastermicroservices.rest.webservices.microservicesrest.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JsonIgnore //Because i don't want the details of the user when i get a specific post, not adding this could generate an infinite loop
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
