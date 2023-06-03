package com.webstore.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.webstore.Entities.ProductEntity;

public class Products {
	
    @JsonProperty("id")
	private int id;
    
    @JsonProperty("name")
	private String name;
    
    @JsonProperty("quantity")
	private int quantity;
	
    @JsonProperty("price")
	private int price;
    
    @JsonProperty("image")
	private String image;
    
    @JsonProperty("favorite")
	private int favorite;
    
    @JsonProperty("order")
	private int order;
    
    @JsonProperty("onsale")
	private int onsale;
	
    @JsonProperty("category")
	private Category category;
    
    @JsonProperty("description")
	private String description;

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Products(int id, String name, int quantity, int price, String image, int onsale,int favorite, int order,  String description,  Category category) {
    	super();
    	this.id = id;
    	this.name = name;
    	this.quantity = quantity;
    	this.price = price;
    	this.category = category;
    	this.image = image;
    	this.onsale = onsale;
    	this.favorite = favorite;
    	this.order = order;
    	this.description = description;
    }
	
	public Products(ProductEntity productEntity) {
    	super();
    	this.id = productEntity.getId();
    	this.name = productEntity.getName();
    	this.quantity = productEntity.getQuantity();
    	this.price = productEntity.getPrice();
    	this.category = new Category(productEntity.getCategory());
    	this.image = productEntity.getImage();
    	this.onsale = productEntity.getOnsale();
    	this.favorite = productEntity.getFavorite();
    	this.order = productEntity.getOrder();
    	this.description = productEntity.getDescription();
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getOnsale() {
		return onsale;
	}

	public void setOnsale(int onsale) {
		this.onsale = onsale;
	}

	public int getFavorite() {
		return favorite;
	}

	public void setFavorite(int favorite) {
		this.favorite = favorite;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
