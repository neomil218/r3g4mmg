/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.g39.appg39.controller;

import com.app.g39.appg39.entity.Messages;
import com.app.g39.appg39.entity.Reservations;
import com.app.g39.appg39.service.MessagesService;
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
 * @author Carlos Caceres Ochoa
 */
/**Api Rest de Producto**/

@RestController 
@RequestMapping("/api/Message")
@CrossOrigin(origins="*",methods={RequestMethod.GET,RequestMethod.POST,
             RequestMethod.PUT,RequestMethod.DELETE})
public class MessagesController {
    @Autowired
    private MessagesService service;
    
    @GetMapping("/all")
    public List<Messages> findAllProducto(){
        return service.getMessage(); 
    }
    
    @GetMapping("/{id}")
    public Messages findProductoById(@PathVariable int id){
        return service.getMessageById(id); 
    }
    
    @PostMapping("/save")
    public ResponseEntity addProducto(@RequestBody Messages message){
        service.saveMessage(message);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/save")
    public ResponseEntity updateProducto(@RequestBody Messages message){
        service.updateMessage(message); 
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProducto(@PathVariable int id){
        service.deleteMessage(id);
        return ResponseEntity.status(204).build();
    }
    
    
    
}
