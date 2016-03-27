package com.fooddhaba.foodmarket.model;

public class BusinessEnquiry 
{
	private int id;
	private String name;
	private String email_id;
	private String mobile_no;
	private BusinessType business_type;
	private int business_type_id;
	private String business_name;
	private String business_address;
	private String comments;
	private int enquiry_status;
	
	public BusinessEnquiry() {
		
	}
	
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
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public BusinessType getBusiness_type() {
		return business_type;
	}
	public void setBusiness_type(BusinessType business_type) {
		this.business_type = business_type;
	}
	public int getBusiness_type_id() {
		return business_type_id;
	}
	public void setBusiness_type_id(int business_type_id) {
		this.business_type_id = business_type_id;
	}
	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	public String getBusiness_address() {
		return business_address;
	}
	public void setBusiness_address(String business_address) {
		this.business_address = business_address;
	}
	public int getEnquiry_status() {
		return enquiry_status;
	}
	public void setEnquiry_status(int enquiry_status) {
		this.enquiry_status = enquiry_status;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
}
