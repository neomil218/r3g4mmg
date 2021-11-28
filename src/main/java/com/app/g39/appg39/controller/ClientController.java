/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.g39.appg39.controller;

import com.app.g39.appg39.entity.Category;
import com.app.g39.appg39.entity.Client;
import com.app.g39.appg39.service.ClientService;
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
@RequestMapping("/api/Client")
@CrossOrigin(origins="*",methods={RequestMethod.GET,RequestMethod.POST,
             RequestMethod.PUT,RequestMethod.DELETE})
public class ClientController {
    
    @Autowired
    private ClientService service;
    
    @GetMapping("/all")
    public List<Client> findAllCategorias(){
        return service.getClient();
    }
    
    @GetMapping("/{id}")
    public Client findClientById(@PathVariable int id){
        
        return service.getClientById(id);       
        
    }
    
    @PostMapping("/save")
    public ResponseEntity addCategoria(@RequestBody Client client){
        service.saveClient(client);
        return ResponseEntity.status(201).build();
    } 
    
    @PutMapping("/save")
    public ResponseEntity updateClient(@RequestBody Client client){
        service.updateClient(client);
        return ResponseEntity.status(201).build();                
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable int id){
        service.deleteClient(id);
        return ResponseEntity.status(204).build();
    }
    
}
