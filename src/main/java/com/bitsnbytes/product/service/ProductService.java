package com.bitsnbytes.product.service;

import com.bitsnbytes.product.dto.ProductDTO;
import com.bitsnbytes.product.entity.Category;
import com.bitsnbytes.product.entity.Product;
import com.bitsnbytes.product.mapper.ProductMapper;
import com.bitsnbytes.product.repository.CategoryRepository;
import com.bitsnbytes.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    //createProduct
    public ProductDTO createProduct(ProductDTO productDTO) {
        // Implementation goes here
        /**
        *id, name, description, price, categoryId
        * **/
        //
        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        //dto to entity
       Product product = ProductMapper.toProductEntity(productDTO, category);
       product = productRepository.save(product);

       //entity to dto
        return ProductMapper.toProductDTO(product);


    }

    //getAllProduct
    public List<ProductDTO> getAllProducts() {
        // Implementation goes here
        return productRepository.findAll().stream()
                .map(ProductMapper::toProductDTO)
                .toList();
    }

    //get product by id
    public ProductDTO getProductById(Long id) {
        // Implementation goes here
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return ProductMapper.toProductDTO(product);
    }

    //updateProduct
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        // Implementation goes here
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        existingProduct.setCategory(category);
        existingProduct.setName(productDTO.getName());
        existingProduct.setDescription(productDTO.getDescription());
        existingProduct.setPrice(productDTO.getPrice());
        Product updatedProduct = productRepository.save(existingProduct);
        return ProductMapper.toProductDTO(updatedProduct);
    }

    //delete product
    public String deleteProduct(Long id) {
        // Implementation goes here
        productRepository.deleteById(id);
        return "Product " + id + " deleted successfully";
    }
}
