package com.bitsnbytes.product;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Product Service API",
				version = "v1",
				description = "API documentation for the Product Service",
				contact = @Contact(
						name = "Vivek Ranjan",
						email = "vvkbablu3012@gmail.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Product Service Wiki Documentation",
				url = "example.com"
		)
)
@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

}
