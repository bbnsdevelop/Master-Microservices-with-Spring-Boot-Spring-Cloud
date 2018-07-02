package br.com.restfulwebservice.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	private UserDaoService daoService;
	
	@GetMapping("/find-all")
	public ResponseEntity<List<User>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(daoService.findAll());
	}
	
	@GetMapping("/find-by/{id}")
	public ResponseEntity<User> findById(@PathVariable("id") int id){
		return ResponseEntity.status(HttpStatus.OK).body(daoService.findOne(id));
	}
	
	@PostMapping("/save")
	public ResponseEntity<User> save(@RequestBody User user){
		return ResponseEntity.status(HttpStatus.CREATED).body(daoService.save(user));
	}
}
