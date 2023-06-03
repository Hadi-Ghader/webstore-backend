package com.webstore.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webstore.Entities.ProductEntity;
import com.webstore.Models.Products;
import com.webstore.Repositories.ProductsRepository;

@Service
public class ProductsService {
	
	@Autowired
	ProductsRepository productsRepository;
	
	public List<ProductEntity> getProducts(int category) {
		 if(category == -1)
			 return productsRepository.findAll();	
		 return productsRepository.findByCategoryId(category);		

	}
	
	public List<ProductEntity> getFavoriteProducts() {
		 return productsRepository.findByFavorite(1);		

	}
	
	public List<ProductEntity> getMostOrderedProducts() {
		 return productsRepository.findTop3ByOrder();		
	}
	
	public List<ProductEntity> getOnSaleProducts() {
		 return productsRepository.findOnSaleProducts();		
	}
	public void addNewProduct(Products newProduct) {
			ProductEntity productEntity = new ProductEntity(newProduct);
			productsRepository.save(productEntity);		
	}
	
	public void editProduct(Products editProduct) {
		ProductEntity editProductEntity = new ProductEntity(editProduct);
		editProductEntity.setId(editProduct.getId());
		productsRepository.save(editProductEntity);		
	}
	
	public void deleteProduct(int id) {
		productsRepository.deleteById(id);		
	}
}
