package com.webstore.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.webstore.Entities.CategoryEntity;

public class Category {

    @JsonProperty("id")
	private int id;
    
    @JsonProperty("name")
	private String name;
    
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Category(CategoryEntity categoryEntity) {
		super();
		this.id = categoryEntity.getId();
		this.name = categoryEntity.getName();
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
}
