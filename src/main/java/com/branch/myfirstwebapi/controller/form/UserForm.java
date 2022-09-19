package com.branch.myfirstwebapi.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.branch.myfirstwebapi.model.User;

public class UserForm {
	
	@NotNull @NotEmpty @Length(min= 5)
	private String nome;

	@NotNull @NotEmpty @Length(min= 5) @Email
    private String email;
    
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User converter() {
		return new User(nome,email);
	}
}
