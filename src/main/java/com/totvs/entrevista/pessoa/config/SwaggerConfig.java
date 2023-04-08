package com.totvs.entrevista.pessoa.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import springfox.documentation.builders.PathSelectors;
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
	    public InternalResourceViewResolver defaultViewResolver() {
	        return new InternalResourceViewResolver();
	    }

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(true)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.totvs.entrevista.pessoa.resources"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("API TOTVS - teste",
				"Teste para desenvolvedor java - 2023",
				"Version 1.0",
				"https://github.com/totvs-teste-backend",
				new Contact("Giuliano Diego Barbarra", 
						"https://www.linkedin.com/in/giuliano-diego-barbarra", "giulianodb@gmail.com"),
				"Para todos", "https://github.com/giuliano-db", Collections.emptyList() // Vendor
																										// Extensions
		);
	}
	
}