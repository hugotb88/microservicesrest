package com.mastermicroservices.rest.webservices.microservicesrest.controllers;

import com.mastermicroservices.rest.webservices.microservicesrest.pojos.User;
import com.mastermicroservices.rest.webservices.microservicesrest.services.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * User Controller
 */
@RestController
public class UserController {

    //Service used to get Users Information
    @Autowired
    UserDaoService userDaoService;

    //Gets all Users
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userDaoService.findAll();
    }

    //Gets a single User
    @GetMapping("/users/{id}")
    public User retrieveAllUsers(@PathVariable Integer id){
        return userDaoService.findOne(id);
    }

    //Add User
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        userDaoService.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId()).toUri(); //Appends in the URI the id of the new User
        return ResponseEntity.created(location).build();
    }


}
