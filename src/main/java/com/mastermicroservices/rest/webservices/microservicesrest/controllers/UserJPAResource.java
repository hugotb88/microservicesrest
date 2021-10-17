package com.mastermicroservices.rest.webservices.microservicesrest.controllers;

import com.mastermicroservices.rest.webservices.microservicesrest.daos.UserRepository;
import com.mastermicroservices.rest.webservices.microservicesrest.exception.UserNotFoundException;
import com.mastermicroservices.rest.webservices.microservicesrest.pojos.User;
import com.mastermicroservices.rest.webservices.microservicesrest.services.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJPAResource {

    @Autowired
    private UserDaoService userService;

    @Autowired
    private UserRepository userRepository;

    //Get all the Users
    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }


    //Gets a single User
    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable Integer id){
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent())
            throw new UserNotFoundException("id" + id);

        //"all-users", SERVER_PATH + "/users"
        //HATEOAS
        //retrieveAllUsers
        EntityModel<User> model = new EntityModel<>(user.get());
        WebMvcLinkBuilder linkToUsers= linkTo(methodOn(this.getClass()).retrieveAllUsers());
        model.add(linkToUsers.withRel("all-users"));

        return model;
    }



}
