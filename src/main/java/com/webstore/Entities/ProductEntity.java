package com.webstore.Entities;

import java.util.List;

import com.webstore.Models.Products;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class ProductEntity {
	
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
	private int id;
    
    @Column(name="name")
	private String name;
    
    @Column(name="quantity")
	private int quantity;
    
    @Column(name="price")
	private int price;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="category_id")
    private CategoryEntity category;
    
    @Column(name="favorite")
	private int favorite;
    
    @Column(name="image")
	private String image;
    
	@Column(name="`order`")
	private int order;
    
    @Column(name="onsale")
	private int onsale;
    
    @Column(name="description")
    private String description;
    
    @ManyToMany(mappedBy = "cartProducts")
	private List<UserEntity> usersOrderingProduct;
    
	public ProductEntity() {
		super();
	}

	public ProductEntity(int id, String name, int quantity, int price, int favorite, String image, String description,
			int order, int onsale, CategoryEntity category) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.favorite = favorite;
		this.image = image;
		this.description = description;
		this.order = order;
		this.onsale = onsale;
		this.category = category;
	}

	public ProductEntity(Products product) {
		super();
		this.name = product.getName();
		this.quantity = product.getQuantity();
		this.price = product.getPrice();
		this.favorite = product.getFavorite();
		this.image = product.getImage();
		this.description = product.getDescription();
		this.order = product.getOrder();
		this.onsale = product.getOnsale();
		this.category = new CategoryEntity(product.getCategory());
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
	
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getFavorite() {
		return favorite;
	}

	public void setFavorite(int favorite) {
		this.favorite = favorite;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getOnsale() {
		return onsale;
	}

	public void setOnsale(int onsale) {
		this.onsale = onsale;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
}
