package com.dao;

public class User  {
	private int id;
	private String name;
	private String email;
	private String address;
	private long phone;
	private String password;
	public User() {
	}
	
	public User(String name, String email, String address, long phone, String password) {
		super();
		
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", address=" + address + ", phone=" + phone + ", password="
				+ password + "]";
	}

	

}
