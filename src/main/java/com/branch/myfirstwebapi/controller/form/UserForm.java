package com.branch.myfirstwebapi.controller.form;

import com.branch.myfirstwebapi.model.User;

public class UserForm {
	
	private String nome;
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
