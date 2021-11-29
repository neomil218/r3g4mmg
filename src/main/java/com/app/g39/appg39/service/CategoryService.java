/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.g39.appg39.service;

import com.app.g39.appg39.entity.Category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.g39.appg39.repository.CategoryRepository;

/**
 *
 * @author DELL
 */
@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository repository;
    
    public List<Category> getCategories(){
        return repository.findAll();
    }
    
    public Category getCategoryById(int id){
        return repository.findById(id).orElse(null);
    } 
    
    public Category saveCategory(Category category){
        return repository.save(category);
    }
    
    public Category updateCategory(Category category){
        Category existCategory=getCategoryById(category.getId());
        existCategory.setName(category.getName());
        existCategory.setDescription(category.getDescription());
        return repository.save(existCategory);
    }
    
    public void deleteCategory(int id){
        repository.deleteById(id);
    }
    
    
}
