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

import br.com.restfulwebservice.entities.Post;
import br.com.restfulwebservice.entities.User;
import br.com.restfulwebservice.service.UserDaoService;

@RestController
@RequestMapping("/api")
public class UserJPAResource {

	
	@Autowired
	private UserDaoService service;
	
	@GetMapping("/jpa/user")
	public ResponseEntity<List<User>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(service.findAllRepository());
	}
	
	@GetMapping("/jpa/user/{id}")
	public ResponseEntity<User> findById(@PathVariable("id") int id){
		return ResponseEntity.status(HttpStatus.OK).body(service.findOneRepository(id));
	}
	
	@PostMapping("/jpa/user")
	public ResponseEntity<User> save(@Valid @RequestBody User user){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveRepository(user));
	}
	
	@DeleteMapping("/jpa/user/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") int id){
		service.deleteByIdRepository(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	@GetMapping("/jpa/user/{id}/posts")
	public ResponseEntity<List<Post>> save(@PathVariable("id") int id){
		return ResponseEntity.status(HttpStatus.OK).body(service.findPostByUserId(id));
	}
	@PostMapping("/jpa/user/{id}/post")
	public ResponseEntity<Post> savePost(@Valid @RequestBody Post post, @PathVariable("id") int id){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.savePostRepository(post, id));
	}
	
}
