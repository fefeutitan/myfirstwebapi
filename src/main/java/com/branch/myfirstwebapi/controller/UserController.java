package com.branch.myfirstwebapi.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;
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
import com.branch.myfirstwebapi.controller.form.UpdateUserForm;
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
	    @Transactional	
	    public ResponseEntity<UserDto> save(@RequestBody @Valid UserForm form, UriComponentsBuilder uriBuilder){
	    	User user = form.converter();
	        repository.save(user);
	        URI uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();
			return ResponseEntity.created(uri).body(new UserDto(user));
	    }
	    @PutMapping("/{id}")
	    @Transactional	
	    public ResponseEntity<UserDto> update(@PathVariable Integer id,@RequestBody @Valid UpdateUserForm form){
	    	User user =  form.update(id, repository);
			return ResponseEntity.ok(new UserDto(user));
	    }
	    @GetMapping("/{id}")
	    public UserDto find(@PathVariable Integer id){
	    	User user = repository.getReferenceById(id);
	    	return new UserDto(user);
	    }
	    @DeleteMapping("/{id}")
	    @Transactional	
	    public ResponseEntity<?> delete(@PathVariable Integer id){
	        repository.deleteById(id);
			return ResponseEntity.ok().build();
	    }
}
