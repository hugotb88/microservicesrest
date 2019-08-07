package com.mastermicroservices.rest.webservices.microservicesrest.controllers;

import com.mastermicroservices.rest.webservices.microservicesrest.pojos.User;
import com.mastermicroservices.rest.webservices.microservicesrest.services.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void createUser(@RequestBody User user){
        userDaoService.save(user);
    }


}
