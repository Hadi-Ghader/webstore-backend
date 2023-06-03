package com.webstore.Entities;


import com.webstore.Models.ProductsForUser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users_products_mapping")
public class UsersProductsMappingEntity {
	
    @Id
	private int id;
    
    @Column(name="user_email")
	private String email;
    
    @Column(name="product_id")
	private int productId;

	public UsersProductsMappingEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsersProductsMappingEntity(int id, String email, int productId) {
		super();
		this.id = id;
		this.email = email;
		this.productId = productId;
	}
	
	public UsersProductsMappingEntity(ProductsForUser productsForUser) {
		super();
		this.email = productsForUser.getEmail();
		this.productId = productsForUser.getProductId();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
}
