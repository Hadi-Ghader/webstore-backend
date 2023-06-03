package com.webstore.Entities;

import com.webstore.Models.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class CategoryEntity {

    @Id
	private int id;
    
    @Column(name="name")
	private String name;
    
    

	public CategoryEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryEntity(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public CategoryEntity(Category category) {
		super();
		this.id = category.getId();
		this.name = category.getName();
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
