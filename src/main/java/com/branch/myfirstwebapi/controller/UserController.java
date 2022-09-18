package com.branch.myfirstwebapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.branch.myfirstwebapi.model.User;
import com.branch.myfirstwebapi.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	 @Autowired
	    private UserRepository repository;
	 
	    @GetMapping
	    public List<User> list(){
	        return repository.findAll();
	    }
	    @PostMapping
	    public void save(@RequestBody User user){
	        repository.save(user);
	    }
	    @PutMapping
	    public void update(@RequestBody User user){
	        repository.save(user);
	    }
	    @GetMapping("/{id}")
	    public User find(@PathVariable("id") Integer id){
	        return repository.findById(id);
	    }
	    @DeleteMapping("/{id}")
	    public void delete(@PathVariable("/id") Integer id){
	        repository.deleteById(id);
	    }

}
