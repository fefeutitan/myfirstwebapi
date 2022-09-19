package com.branch.myfirstwebapi.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.branch.myfirstwebapi.controller.dto.UserDto;
import com.branch.myfirstwebapi.controller.form.UserForm;
import com.branch.myfirstwebapi.model.User;
import com.branch.myfirstwebapi.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	 @Autowired
	    private UserRepository repository;
	 
	    @GetMapping
	    public List<UserDto> list(){
	    	List<User> users = repository.findAll();
	        return UserDto.converter(users);
	    }
	    @PostMapping
	    public ResponseEntity<UserDto> save(@RequestBody @Valid UserForm form, UriComponentsBuilder uriBuilder){
	    	User user = form.converter();
	        repository.save(user);
	        URI uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();
			return ResponseEntity.created(uri).body(new UserDto(user));
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
