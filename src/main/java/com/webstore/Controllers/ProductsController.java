package com.webstore.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webstore.Entities.ProductEntity;
import com.webstore.Models.Products;
import com.webstore.Services.ProductsService;
import com.webstore.Services.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	ProductsService productsService;
	
	@Autowired
	UserService usersService;

	@GetMapping
	@ResponseBody
	public List<Products> getProducts(@RequestParam int category, HttpServletRequest req){
		List<Products> products = new ArrayList<>();
		String cookie = req.getHeader(HttpHeaders.COOKIE);
		
		String email = cookie.split(";")[0].split("=")[1];
		String password = cookie.split(";")[1].split("=")[1];
		
		boolean exists = usersService.checkUserCredentials(email, password);
		
		if(exists)
			 products = productsService.getProducts(category).stream().map((productEntity) -> new Products(productEntity)).collect(Collectors.toList());
		
		return products;
	}
	
	@GetMapping("/favorites")
	@ResponseBody
	public List<Products> getFavoriteProducts(){
		List<Products> products = productsService.getFavoriteProducts().stream().map((productEntity) -> new Products(productEntity)).collect(Collectors.toList());
		return products;
	}
	
	@GetMapping("/mostOrdered")
	@ResponseBody
	public List<Products> getMostOrderedProducts(){
		List<Products> products = productsService.getMostOrderedProducts().stream().map((productEntity) -> new Products(productEntity)).collect(Collectors.toList());
		return products;
	}
	
	@GetMapping("/onSale")
	@ResponseBody
	public List<Products> getOnSaleProducts(){
		List<Products> products = productsService.getOnSaleProducts().stream().map((productEntity) -> new Products(productEntity)).collect(Collectors.toList());
		return products;
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<?> addNewProduct(@RequestBody Products newProduct){
		productsService.addNewProduct(newProduct);
		return new ResponseEntity<>("Product succesfully created", HttpStatus.OK);
	}
	
	@PostMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> editProduct(@RequestBody Products editProduct){
		productsService.editProduct(editProduct);
		return new ResponseEntity<>("Product edited succesfully", HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> deleteProduct(@PathVariable(value = "id")int id){
		productsService.deleteProduct(id);
		return new ResponseEntity<>("Product succesfully deleted", HttpStatus.OK);
	}
}
