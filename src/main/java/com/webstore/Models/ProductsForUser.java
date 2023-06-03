package com.webstore.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductsForUser {
	
    @JsonProperty("email")
	private String email;
    
    @JsonProperty("productId")
	private int productId;

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
