package com.klu.Backend; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController; 
 
@RestController 
@CrossOrigin("*")
public class Service  
{ 
	@Autowired
	DAO dao;
	
 @GetMapping("/welcome/{name}") 
 public String fun1(@PathVariable String name) 
 { 
  return "welcome " + name; 
 } 
 @PostMapping("/user")
 public String fun3(@RequestBody User user) {
	 dao.insert(user);
   return "User Inserted";
 }
 
 //@GetMapping("/user")
 @RequestMapping(value = "/user", method = RequestMethod.GET)
 public String fun4(@RequestParam ("email") String email) 
 {
	 return dao.findUser(email).toString();
 }
 
 @GetMapping("/all")
 public List<User> fun6()
 {
	 return dao.find();
 }
 
 @GetMapping("/page")
 public String fun5()
 {
	 return dao.findPage().toString();
 }
 
 @DeleteMapping("/delete")
 public String fun7(@RequestParam("email") String email)
 {
	 return dao.deleteUser(email);
 }
 
 @PutMapping("/update")
 public String fun8(@RequestBody User user)
 {
	 System.out.println(user);
	 return dao.editUser(user);
 }
 @PostMapping("/login")
 public ResponseEntity<String> loginUser(@RequestBody User user) {
     boolean isValidUser = dao.verifyUserCredentials(user.getEmail(), user.getPassword());
     
     if (isValidUser) {
         return ResponseEntity.ok("Login Successful");
     } else {
         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
     }
 }
}