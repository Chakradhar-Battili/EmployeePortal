package com.societegenerale.configuration;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	
	 @Bean
	    public Docket productApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.societegeneral.controller"))
	                .paths(regex("/employees/*"))
	                .build()
	                .apiInfo(apiInformation());
	    }
	 
	 private ApiInfo apiInformation() {
		    return new ApiInfo(
		      "Employee Portal", 
		      "Some employee related APIs (Societe Generale Test)", 
		      "API TOS", 
		      "Terms of service", 
		      new Contact("Chakradhar Battili", "https://github.com/Chakradhar-Battili", "chakradhar.battili@gmail.com"), 
		      "License of API", "API license URL", Collections.emptyList());
		}
}