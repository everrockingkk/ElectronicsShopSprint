package com.controller;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Customer;
import com.entities.User;
import com.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
public class UserController {
	

	@Autowired
	UserService userservice;
	

@PostMapping(path="/addUser")
public ResponseEntity<User> addUser(@Valid @RequestBody User u)
{
	User u1=userservice.createUser(u);
	ResponseEntity<User> re=new ResponseEntity<User>(u1,HttpStatus.OK);
	return re;
}


  @GetMapping("/SignIn/{userId}/{password}")
  public ResponseEntity <Customer> Welcome(@Valid @RequestBody int userId,String password)throws Exception
  {
      Customer u1=userservice.signIn(userId,password);
	  ResponseEntity<Customer> re=new ResponseEntity<Customer>(u1,HttpStatus.OK);
	  return re;	
  }


@PutMapping(path="/ChangePassword/{userId}/{password}/{newpassword}")
public ResponseEntity<User> Want_To_Change_Password(@Valid @PathVariable int userId,String password,String newpassword) throws Exception
{
	User u1=userservice.changeUserpassword(userId,password,newpassword);
		
	ResponseEntity<User> re=new ResponseEntity<User>(u1,HttpStatus.OK);
	return re;
}


@GetMapping("/SignOut/{userIdno}")
public ResponseEntity <String> Sign_Out(@RequestBody int userId) throws Exception
{
    User u1= userservice.signOut(userId);
    String s="Logged Out Succssfully";
	ResponseEntity<String> re=new ResponseEntity<String>(s,HttpStatus.OK);
	return re;		
}
}