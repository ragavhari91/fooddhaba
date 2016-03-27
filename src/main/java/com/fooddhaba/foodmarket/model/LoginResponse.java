package com.fooddhaba.foodmarket.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class LoginResponse 
{
	private Response response;
	private List<User> user;
	private List<Responsibility> responsibilities;
	private List<Menu> menus;
	private List<UserSession> userSession;
	
	
	public Response getResponse() {
		return response;
	}
	public void setResponse(Response response) {
		this.response = response;
	}
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	public List<Responsibility> getResponsibilities() {
		return responsibilities;
	}
	public void setResponsibilities(List<Responsibility> responsibilities) {
		this.responsibilities = responsibilities;
	}
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	public List<UserSession> getSession() {
		return userSession;
	}
	public void setSession(List<UserSession> userSession) {
		this.userSession = userSession;
	}
	
	
}
