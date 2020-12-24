package com.assign.assing.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assign.assing.Entity.UserRegistration;
import com.assign.assing.Services.UserService;
import com.assign.assing.dto.Userdto;
import com.assign.assing.dto.bankingdto;

@RestController
public class UserController 
{
	@Autowired
	UserService userservive;
	
	@Autowired
	LonginController logincontroller;
	
	@PostMapping("/savedetails")
	public void savedetails(@ModelAttribute Userdto userdto, HttpServletResponse response)
	{
		userservive.savedetails(userdto);
		try {
			response.sendRedirect("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GetMapping("/getdetails")
	public UserRegistration getdetais()
	{
		Long id = logincontroller.id;
		return userservive.getdetails(id);
	}
	
	@PostMapping("/editdetails")
	public ResponseEntity<UserRegistration> editdetails(@ModelAttribute Userdto userdto)
	{
		Long id=logincontroller.id;
		return userservive.editdetails(userdto,id);
	}
	
	@GetMapping("/deletedetails")
	public String deletedetails(@RequestParam String name)
	{
		Long id=logincontroller.id;
		return userservive.deletedetails(id);
	}
	
	@PostMapping("/banking")
	public String banking(@ModelAttribute bankingdto bankingobject)
	{
		long id=logincontroller.id;
		return userservive.bankingmathod(bankingobject, id);
	}
}
