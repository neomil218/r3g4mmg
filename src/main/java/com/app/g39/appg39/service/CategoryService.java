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
    
    public List<Category> getCategorias(){
        return repository.findAll();
    }
    
    public Category getCategoriaById(int id){
        return repository.findById(id).orElse(null);
    } 
    
    public Category saveCategoria(Category categoria){
        return repository.save(categoria);
    }
    
    public Category updateCategoria(Category categoria){
        Category existeCategoria=getCategoriaById(categoria.getId());
        existeCategoria.setName(categoria.getName());
        existeCategoria.setDescription(categoria.getDescription());
        return repository.save(existeCategoria);
    }
    
    public void deleteCategoria(int id){
        repository.deleteById(id);
    }
    
    
}
