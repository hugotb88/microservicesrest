package com.mastermicroservices.rest.webservices.microservicesrest.controllers;

import com.mastermicroservices.rest.webservices.microservicesrest.exception.NoUsersFoundException;
import com.mastermicroservices.rest.webservices.microservicesrest.exception.UserNotFoundException;
import com.mastermicroservices.rest.webservices.microservicesrest.exception.UserSaveException;
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
        List<User> result = userDaoService.findAll();
        if(result == null)
            throw new NoUsersFoundException("No users registered yet");
        return result;
    }

    //Gets a single User
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable Integer id){
        User user = userDaoService.findOne(id);
        if (user == null)
            throw new UserNotFoundException("id" + id);
        return user;
    }

    //Add User
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        User result = userDaoService.save(user);
        if (result == null)
            throw new UserSaveException("User not saved:" + user.getName());
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId()).toUri(); //Appends in the URI the id of the new User
        return ResponseEntity.created(location).build();
    }


}
