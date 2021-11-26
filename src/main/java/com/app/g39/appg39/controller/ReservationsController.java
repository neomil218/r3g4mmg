/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.g39.appg39.controller;

import com.app.g39.appg39.entity.Partyroom;
import com.app.g39.appg39.entity.Reservations;
import com.app.g39.appg39.service.ReservationsService;
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
@RequestMapping("/api/Reservation")
@CrossOrigin(origins="*",methods={RequestMethod.GET,RequestMethod.POST,
             RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationsController {
    @Autowired
    private ReservationsService service;
    
    @GetMapping("/all")
    public List<Reservations> findAllProducto(){
        return service.getReservations(); 
    }
    
    @GetMapping("/{id}")
    public Reservations findProductoById(@PathVariable int id){
        return service.getReservationsById(id); 
    }
    
    @PostMapping("/save")
    public ResponseEntity addProducto(@RequestBody Reservations reservation){
        service.saveReservations(reservation);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/save")
    public ResponseEntity updateProducto(@RequestBody Reservations reservation){
        service.updateReservations(reservation); 
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProducto(@PathVariable int id){
        service.deleteReservation(id);
        return ResponseEntity.status(204).build();
    }
    
    
    
}
