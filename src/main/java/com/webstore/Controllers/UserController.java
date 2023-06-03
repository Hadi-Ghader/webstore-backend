package com.webstore.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webstore.Entities.UserEntity;
import com.webstore.Models.ProductsForUser;
import com.webstore.Models.User;
import com.webstore.Services.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	private HttpServletResponse cookieGenerator(User user, HttpServletResponse response) {
		Cookie emailCookie = new Cookie("email", user.getEmail());
		Cookie passwordCookie = new Cookie("password", user.getPassword());

		cookieAttributes(emailCookie, response);
		cookieAttributes(passwordCookie, response);

		return response;
	}
	
	private void cookieAttributes(Cookie cookie, HttpServletResponse response) {
		cookie.setMaxAge( 3600 );
		cookie.setSecure(true);
		cookie.setAttribute("SameSite", "none");
		cookie.setHttpOnly(false);
		cookie.setPath("/");
		
		response.addCookie(cookie);
	}
	
	@PostMapping("/signup")
	@ResponseBody
	public ResponseEntity<?> SignUpUser(@RequestBody User user, HttpServletResponse response) {
		ResponseEntity<?> responseEntity = userService.Signup(user);
		if(responseEntity.getStatusCode() == HttpStatus.OK)
			cookieGenerator(user, response); 
	    return responseEntity;
	}
	
	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<?> LoginUser(@RequestBody User user, HttpServletResponse response) {
		ResponseEntity<?> responseEntity = userService.Login(user);
		if(responseEntity.getStatusCode() == HttpStatus.OK)
			cookieGenerator(user, response); 
	    return responseEntity;
	}
	
	@PostMapping("/addProductToUser")
	@ResponseBody
	public ResponseEntity<?> addProductToUser(@RequestBody ProductsForUser productsForUser) {
		ResponseEntity<?> responseEntity = userService.addProductToUser(productsForUser);
	    return responseEntity;
	}

}
