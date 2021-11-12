package com.project.badminton.domain;

public class BookerDTO {
	private String name;
	private String phone;
	
	public BookerDTO(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}