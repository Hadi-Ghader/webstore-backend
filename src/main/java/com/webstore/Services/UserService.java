package com.webstore.Services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.webstore.Models.Products;
import com.webstore.Models.ProductsForUser;
import com.webstore.Entities.ProductEntity;
import com.webstore.Entities.UserEntity;
import com.webstore.Entities.UsersProductsMappingEntity;
import com.webstore.Models.User;
import com.webstore.Repositories.ProductsRepository;
import com.webstore.Repositories.UserRepository;
import com.webstore.Repositories.UsersProductsMappingRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UsersProductsMappingRepository usersProductsMappingRepository;
	
	public ResponseEntity<?> Signup(User user) {
		UserEntity existingUser = userRepository.findByEmail(user.getEmail());
		if(existingUser != null) {
			return new ResponseEntity<>("User Already Exists!", HttpStatus.CONFLICT);
		}
		if (user.getEmail() == null || user.getPassword() == null || user.getName() == null || user.getAddress() == null) {
	        return new ResponseEntity<>("Please Fill in All Fields!", HttpStatus.BAD_REQUEST);
	    }
		UserEntity userEntity = new UserEntity(user.getEmail(), user.getPassword(), user.getName(), user.getAddress(),0);
		userRepository.save(userEntity);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	public ResponseEntity<?> Login(User user) {
		UserEntity existingUserEntity = userRepository.findByEmail(user.getEmail());
		if(existingUserEntity == null)
			return new ResponseEntity<>("User Doesn't Exist! Please Sign Up Instead!", HttpStatus.CONFLICT);
		if(!existingUserEntity.getPassword().equals(user.getPassword()))
			return new ResponseEntity<>("Wrong Password!", HttpStatus.CONFLICT);
		existingUserEntity.setCartProducts(existingUserEntity.getCartProducts());
		User existingUser = new User(existingUserEntity);
		return new ResponseEntity<>(existingUser, HttpStatus.OK);
	}
	
	public boolean checkUserCredentials(String email, String password) {
		UserEntity user =  userRepository.findByEmail(email);
		if(user != null && user.getPassword().equals(password))
			return true;
		return false;
	}
	
	public ResponseEntity<?> addProductToUser(ProductsForUser productsForUser) {
		UsersProductsMappingEntity usersProductsEntity = new UsersProductsMappingEntity(productsForUser);
		usersProductsMappingRepository.save(usersProductsEntity);
		List<Products> allProducts= userRepository.findByEmail(productsForUser.getEmail()).getCartProducts().stream().map((entity) -> new Products(entity)).collect(Collectors.toList());
		return new ResponseEntity<>(allProducts, HttpStatus.OK);
	}

}
