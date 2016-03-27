package com.fooddhaba.foodmarket.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FDRole {

	private int id;
	private String name;
	private String description;
	private int fd_status_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getFd_status_id() {
		return fd_status_id;
	}
	public void setFd_status_id(int fd_status_id) {
		this.fd_status_id = fd_status_id;
	}
	
	
}
