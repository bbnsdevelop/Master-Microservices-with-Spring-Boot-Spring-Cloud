package br.com.restfulwebservice.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //configuration
@EnableSwagger2//Enable Swagger
public class SwaggerConfiguration {
	
	
	 public static final Contact DEFAULT_CONTACT = new Contact("Bruno", 
			 		"https://github.com/bbnsdevelop", 
			 		"brunno1808@hotmail.com");
	 
	  public static final ApiInfo DEFAULT = new ApiInfo("Api Title", 
			  "Api Documentation", "1.0", "urn:tos",
	          DEFAULT_CONTACT, 
	          "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");

	private static final Set<String> DEFAULT_PRODUCER_AND_CONSUMER = new HashSet<String>(Arrays.asList("application/json","application/xml"));
	
	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT)
				.produces(DEFAULT_PRODUCER_AND_CONSUMER)
				.consumes(DEFAULT_PRODUCER_AND_CONSUMER);
	}

}
