package com.fooddhaba.foodmarket.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class City 
{
	private int id;
	private String name;
	private Status status_id;
	
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
	public Status getStatus_id() {
		return status_id;
	}
	public void setStatus_id(Status status_id) {
		this.status_id = status_id;
	}
	
	
}
