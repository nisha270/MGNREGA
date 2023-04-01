package com.mgnrega.Dto;

public class Users_Dto_impl implements Users_Dto {
	 private String username;
	 private String password;
	 private String usertype;
	public Users_Dto_impl(String username, String password, String usertype) {
		super();
		this.username = username;
		this.password = password;
		this.usertype = usertype;
	}
	public Users_Dto_impl() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	@Override
	public String toString() {
		return "username=" + username + ", password=" + password + ", usertype=" + usertype + "\n";
	}
	 
}
