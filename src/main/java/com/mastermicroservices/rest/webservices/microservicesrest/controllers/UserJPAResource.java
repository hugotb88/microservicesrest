package com.mastermicroservices.rest.webservices.microservicesrest.controllers;

import com.mastermicroservices.rest.webservices.microservicesrest.daos.PostRepository;
import com.mastermicroservices.rest.webservices.microservicesrest.daos.UserRepository;
import com.mastermicroservices.rest.webservices.microservicesrest.exception.UserNotFoundException;
import com.mastermicroservices.rest.webservices.microservicesrest.exception.UserSaveException;
import com.mastermicroservices.rest.webservices.microservicesrest.pojos.Post;
import com.mastermicroservices.rest.webservices.microservicesrest.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJPAResource {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

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


    //Create User
    @PostMapping("/jpa/users")
    public ResponseEntity<Object> createUser(@Valid
                                             @RequestBody User user){
        User result = userRepository.save(user);
        if (result == null)
            throw new UserSaveException("User not saved:" + user.getName());
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId()).toUri(); //Appends in the URI the id of the new User
        return ResponseEntity.created(location).build();
    }

    //Delete a single User
    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable Integer id){
        userRepository.deleteById(id);
    }


    //Retrieve all the Posts for a specific User
    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrieveUserPosts(@PathVariable Integer id){
        //Find the User
        Optional<User> userOptional = userRepository.findById(id);

        if(!userOptional.isPresent()){
            throw new UserNotFoundException("Id: " + id);
        }

        return userOptional.get().getPosts();
    }

    //Create Post for Specific User
    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPostForUser(@PathVariable Integer id, @RequestBody Post post){
        //Find the User
        Optional<User> userOptional = userRepository.findById(id);

        if (!userOptional.isPresent())
            throw new UserNotFoundException("User " + id + " not found:");

        //Extract the user
        User user = userOptional.get();

        //Map the user to the post
        post.setUser(user);

        //Save the Post
        postRepository.save(post);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(post.getId()).toUri(); //Appends in the URI the id of the new User

        return ResponseEntity.created(location).build();
    }
}
