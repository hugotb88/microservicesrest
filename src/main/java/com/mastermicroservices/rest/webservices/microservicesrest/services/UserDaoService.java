package com.mastermicroservices.rest.webservices.microservicesrest.services;

import com.mastermicroservices.rest.webservices.microservicesrest.pojos.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<User>();

    //Initializes count and static list of users
    private static int usersCount = 3;
    static {
        users.add(new User(1,"Batman", LocalDate.now()));
        users.add(new User(2,"Robin", LocalDate.now()));
        users.add(new User(3,"Nightwing", LocalDate.now()));
    }

    //Methods
    public List<User> findAll(){
        return users;
    }

    public User userSave(User user){
        if(user.getId() == null)
            user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public User findOne(int id){
        for(User user: users){
            if (user.getId() == id)
                return user;
        }
        return null;
    }

}
