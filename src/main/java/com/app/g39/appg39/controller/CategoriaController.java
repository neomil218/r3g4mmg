/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.g39.appg39.controller;

import com.app.g39.appg39.entity.Category;
import com.app.g39.appg39.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins="*",methods={RequestMethod.GET,RequestMethod.POST,
             RequestMethod.PUT,RequestMethod.DELETE})
public class CategoriaController {
    
    @Autowired
    private CategoryService service;
    
    @GetMapping("/all")
    public List<Category> findAllCategorias(){
        return service.getCategorias();
    }
    
    @GetMapping("/{id}")
    public Category findCategoriaById(@PathVariable int id){
        
        return service.getCategoriaById(id);       
        
    }
    
    @PostMapping("/save")
    public ResponseEntity addCategoria(@RequestBody Category categoria){
        service.saveCategoria(categoria);
        return ResponseEntity.status(201).build();
    } 
    
    @PutMapping("/save")
    public ResponseEntity updateCategoria(@RequestBody Category categoria){
        service.updateCategoria(categoria);
        return ResponseEntity.status(201).build();                
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategoria(@PathVariable int id){
        service.deleteCategoria(id);
        return ResponseEntity.status(204).build();
    }
    
}
