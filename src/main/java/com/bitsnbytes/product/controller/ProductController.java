package com.bitsnbytes.product.controller;

import com.bitsnbytes.product.dto.ProductDTO;
import com.bitsnbytes.product.entity.Product;
import com.bitsnbytes.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Product REST API CRUD Operations",
        description = "CREATE, READ, UPDATE, DELETE operations for Product REST API"
)

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    //getAllProduct
    @Operation(
            summary = "Get All Products",
            description = "Retrieve a list of all products"
    )
    @GetMapping
    public List<ProductDTO> getAllProducts() {
        // Implementation goes here
        return productService.getAllProducts();
    }

    //createProduct
    @Operation(
            summary = "Create Product",
            description = "Create a new product with the provided details"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Product created successfully"
    )
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        // Implementation goes here
        ProductDTO createdProduct = productService.createProduct(productDTO);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }
    //updateProduct
    @Operation(
            summary = "Update Product",
            description = "Update an existing product with the provided details"
    )
    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        // Implementation goes here
        return productService.updateProduct(id, productDTO);
    }
    //get product by id
    @Operation(
            summary = "Get Product by ID",
            description = "Retrieve a product by its unique ID"
    )
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        // Implementation goes here
        return productService.getProductById(id);
    }

    //delete product
    @Operation(
            summary = "Delete Product",
            description = "Delete a product by its unique ID"
    )
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        // Implementation goes here
        return productService.deleteProduct(id);
    }
}
