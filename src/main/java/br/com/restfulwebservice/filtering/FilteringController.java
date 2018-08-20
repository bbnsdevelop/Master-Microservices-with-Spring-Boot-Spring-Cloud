package br.com.restfulwebservice.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public SomeBean retrieveSomeBean(){
		return new SomeBean("value1", "value2", "value3");
	}

}
