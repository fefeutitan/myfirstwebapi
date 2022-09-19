package com.branch.myfirstwebapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tb_usuario")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email; 
    private String password;
    
    public User() {}
    
    public User(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
    @Override
    public String toString() {
        return "User{" +
                "nome='" + nome + '\'' +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
