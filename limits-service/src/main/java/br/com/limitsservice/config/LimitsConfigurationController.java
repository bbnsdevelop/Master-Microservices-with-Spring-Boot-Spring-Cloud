package br.com.limitsservice.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.limitsservice.bean.LimitConfiguration;

@RestController
public class LimitsConfigurationController {
	
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfigurations() {
		
		return new LimitConfiguration(1000, 1);
		
	}

}
