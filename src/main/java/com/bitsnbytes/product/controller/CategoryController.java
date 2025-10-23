package com.bitsnbytes.product.controller;

import com.bitsnbytes.product.dto.CategoryDTO;
import com.bitsnbytes.product.exception.CategoryAlreadyExistException;
import com.bitsnbytes.product.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    //create categories
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
    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        // Implementation goes here
        return categoryService.getAllCategories();
    }
    //get category by id
    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id) {
        // Implementation goes here
        return categoryService.getCategoryById(id);
    }
    //delete category
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id) {
        // Implementation goes here
        return categoryService.deleteCategory(id);
    }
}
