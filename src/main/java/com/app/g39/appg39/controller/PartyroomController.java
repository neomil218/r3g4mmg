/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.g39.appg39.controller;

import com.app.g39.appg39.entity.Partyroom;
import com.app.g39.appg39.service.PartyroomService;
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
@RequestMapping("/api/Partyroom")
@CrossOrigin(origins="*",methods={RequestMethod.GET,RequestMethod.POST,
             RequestMethod.PUT,RequestMethod.DELETE})
public class PartyroomController {
    @Autowired
    private PartyroomService service;
    
    @GetMapping("/all")
    public List<Partyroom> findAllProducto(){
        return service.getPartyroom(); //getProducto();
    }
    
    @GetMapping("/{id}")
    public Partyroom findProductoById(@PathVariable int id){
        return service.getPartyroomById(id); 
    }
    
    @PostMapping("/save")
    public ResponseEntity addProducto(@RequestBody Partyroom partyroom){
        service.savePartyroom(partyroom);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/save")
    public ResponseEntity updateProducto(@RequestBody Partyroom partyroom){
        service.updatePartyroom(partyroom);     
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProducto(@PathVariable int id){
        service.deleteProducto(id);
        return ResponseEntity.status(204).build();
    }
    
    
    
}
