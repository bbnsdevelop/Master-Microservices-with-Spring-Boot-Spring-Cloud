package br.com.restfulwebservice.rest.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.restfulwebservice.bean.HelloWorldBean;

@RestController
@RequestMapping("/api")
public class HelloWorldController {
	
	private static final Logger log = LoggerFactory.getLogger(HelloWorldController.class);

	@GetMapping("/hello")
	public String helloWorld(){
		log.info("hello world sucess {}", "bruno");
		return "Hello World";
	}
	
	@GetMapping("/hello-bean")
	public HelloWorldBean helloWorldBean(){
		log.info("hello world sucess {}", "bruno");
		return new HelloWorldBean("Hello world");
	}
	
	@GetMapping("/hello/path/{name}")
	public HelloWorldBean helloWorldBean(@PathVariable("name") String name){
		log.info("hello world sucess {}", name);
		return new HelloWorldBean("Hello world, "+ name);
	}
}
