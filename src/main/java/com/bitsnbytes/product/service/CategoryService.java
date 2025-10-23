package com.bitsnbytes.product.service;

import com.bitsnbytes.product.dto.CategoryDTO;
import com.bitsnbytes.product.entity.Category;
import com.bitsnbytes.product.exception.CategoryAlreadyExistException;
import com.bitsnbytes.product.mapper.CategoryMapper;
import com.bitsnbytes.product.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;

    //create category
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {

    // handling exception
        Optional<Category> optionalCategory = categoryRepository.findByName(categoryDTO.getName());
        if (optionalCategory.isPresent()) {
            throw new CategoryAlreadyExistException("Category with name " + categoryDTO.getName() + " already exists");
        }

        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);
    }
    //get all categories
    public List<CategoryDTO> getAllCategories() {
        // Implementation goes here
        return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
    }
    //get category by id
    public CategoryDTO getCategoryById(Long id) {
        // Implementation goes here
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return CategoryMapper.toCategoryDTO(category);
    }
    //delete category
    public String deleteCategory(Long id) {
        // Implementation goes here
        categoryRepository.deleteById(id);
        return "Category " + id + " deleted successfully";
    }
}
