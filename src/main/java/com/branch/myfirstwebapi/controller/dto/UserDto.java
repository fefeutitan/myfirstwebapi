package com.branch.myfirstwebapi.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.branch.myfirstwebapi.model.User;

public class UserDto {

	private String nome;
    private String email;
    
	public UserDto(User user) {
		this.nome = user.getNome();
		this.email = user.getEmail();
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public static List<UserDto> converter(List<User> users) {
		return users.stream().map(UserDto::new).collect(Collectors.toList());
	}
}
