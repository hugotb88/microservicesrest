package com.mastermicroservices.rest.webservices.microservicesrest.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Victor Hugo Olvera Cruz
 * POJO User
 * A @User can have multiple @Post, a @Post can only have one @User
 * * (One to Many)
 */
@Entity
public class User {

    //Attributes
    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;

    @Past
    private LocalDate birthDate;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    //Contructors
    protected User() {
    }

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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }


}
