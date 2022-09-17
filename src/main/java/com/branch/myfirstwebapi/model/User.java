package com.branch.myfirstwebapi.model;

public class User {
    private Integer id;
    private String username;
    private String password;
    public User() {}
    public User(String login, String password) {
        this.username = login;
        this.password = password;
    }
    @Override
    public String toString() {
        return "User{" +
                "login='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin() {
		return username;
	}
	public void setLogin(String login) {
		this.username = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
