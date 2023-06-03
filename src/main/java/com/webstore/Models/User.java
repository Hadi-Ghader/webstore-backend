package com.webstore.Models;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.webstore.Entities.UserEntity;

public class User {
	
    @JsonProperty("email")
	private String email;
    
    @JsonProperty("password")
	private String password;
    
    @JsonProperty("name")
	private String name;
    
    @JsonProperty("address")
	private String address;
    
    @JsonProperty("admin")
	private int admin;
    
    @JsonProperty("cartProducts")
	private List<Products> cartProducts;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String email, String password, String name, String address, int admin, List<Products> cartProducts) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.address = address;
		this.admin = admin;
		this.cartProducts = cartProducts;
	}
	
	
	public User(UserEntity userEntity) {
		super();
		this.email = userEntity.getEmail();
		this.password = userEntity.getPassword();
		this.name = userEntity.getName();
		this.address = userEntity.getAddress();
		this.admin = userEntity.getAdmin();
		this.cartProducts = userEntity.getCartProducts().stream().map((entity) -> new Products(entity)).collect(Collectors.toList());
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public List<Products> getCartProducts() {
		return cartProducts;
	}
	public void setCartProducts(List<Products> cartProducts) {
		this.cartProducts = cartProducts;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", name=" + name + ", address=" + address + "]";
	}
}
