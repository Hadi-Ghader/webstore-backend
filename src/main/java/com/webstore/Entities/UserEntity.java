package com.webstore.Entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {
	
    @Id
	private String email;
    
    @Column(name="password")
	private String password;
    
    @Column(name="name")
	private String name;
    
    @Column(name="address")
	private String address;
    
    @Column(name="admin")
	private int admin;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_products_mapping", joinColumns = @JoinColumn(name = "user_email"), inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<ProductEntity> cartProducts = new ArrayList<>();
    
	public UserEntity() {
		super();
	}

	public UserEntity(String email, String password, String name, String address, int admin) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.address = address;
		this.admin = admin;
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

	public List<ProductEntity> getCartProducts() {
		return new ArrayList<>(cartProducts);
	}

	public void setCartProducts(List<ProductEntity> cartProducts) {
		this.cartProducts = cartProducts;
	}
	
}
