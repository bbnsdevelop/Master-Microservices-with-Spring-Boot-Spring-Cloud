package br.com.restfulwebservice.rest.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.restfulwebservice.entities.User;
import br.com.restfulwebservice.service.UserDaoService;

@RestController
@RequestMapping("/api")
public class UserResource {

	
	@Autowired
	private UserDaoService service;
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> findById(@PathVariable("id") int id){
		return ResponseEntity.status(HttpStatus.OK).body(service.findOne(id));
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> save(@Valid @RequestBody User user){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") int id){
		return ResponseEntity.status(HttpStatus.OK).body(service.deleteById(id));
	}
}
