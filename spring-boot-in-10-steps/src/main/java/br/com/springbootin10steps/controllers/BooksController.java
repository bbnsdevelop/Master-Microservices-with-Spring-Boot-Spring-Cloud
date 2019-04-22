package br.com.springbootin10steps.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springbootin10steps.model.Book;

@RestController
public class BooksController {
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> book() {
		List<Book> books = Arrays.asList(new Book(1L, "Master Spring 5.0", "Spring"), new Book(2L, "Master Spring 4.0", "Spring"));
		
		return ResponseEntity.status(HttpStatus.OK).body(books);
	}

}
