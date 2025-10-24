package com.bitsnbytes.product.controller;

import com.bitsnbytes.product.dto.CategoryDTO;
import com.bitsnbytes.product.exception.CategoryAlreadyExistException;
import com.bitsnbytes.product.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Category REST API CRUD Operations",
        description = "CREATE, READ, UPDATE, DELETE operations for Category REST API"
)

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    //create categories
    @Operation(
            summary = "Create Category",
            description = "Create a new category with the provided details"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Category created successfully"
    )
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO) {
        // Implementation goes here
        //by try catch
//        try{
//            CategoryDTO createdCategory = categoryService.createCategory(categoryDTO);
//            return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
//        }catch(CategoryAlreadyExistException ex){
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
//        }

        //global exception handler
        CategoryDTO createdCategory = categoryService.createCategory(categoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);





//        return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }

    //get all categories
    @Operation(
            summary = "Get All Categories",
            description = "Retrieve a list of all categories"
    )
    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        // Implementation goes here
        return categoryService.getAllCategories();
    }
    //get category by id
    @Operation(
            summary = "Get Category by ID",
            description = "Retrieve a category by its unique ID"
    )
    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id) {
        // Implementation goes here
        return categoryService.getCategoryById(id);
    }
    //delete category
    @Operation(
            summary = "Delete Category",
            description = "Delete a category by its unique ID"
    )
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id) {
        // Implementation goes here
        return categoryService.deleteCategory(id);
    }
}
