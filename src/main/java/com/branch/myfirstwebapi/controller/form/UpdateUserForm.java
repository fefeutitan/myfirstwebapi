package com.branch.myfirstwebapi.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.branch.myfirstwebapi.model.User;
import com.branch.myfirstwebapi.repository.UserRepository;

public class UpdateUserForm {
	
	@NotNull @NotEmpty @Length(min= 5) @Email
	private String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User update(Integer id, UserRepository repository) {
		User user = repository.getReferenceById(id);
		user.setEmail(this.email);
		return user;
	}
	

}
