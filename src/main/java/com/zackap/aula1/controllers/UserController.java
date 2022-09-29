package com.zackap.aula1.controllers;

import com.zackap.aula1.entities.User;
import com.zackap.aula1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository urepository;

    @GetMapping
    public List<User> findAll(){
       List<User> result = urepository.findAll();

       return result;
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id){

        User result = urepository.findById(id).get();
        return result;

    }

    @PostMapping 
    public User insertUser(@RequestBody User u){
        User result = urepository.save(u);

        return result;
    }
}
