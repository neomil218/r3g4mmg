/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.g39.appg39.service;

import com.app.g39.appg39.entity.Partyroom;
import com.app.g39.appg39.entity.Reservations;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.g39.appg39.repository.ReservationsRepository;


/**
 *
 * @author DELL
 */

@Service
public class ReservationsService {
   @Autowired
    private ReservationsRepository repository;
    
    public List<Reservations> getReservations(){
        return repository.findAll();
    }
    
    public Reservations saveReservations(Reservations reservation){
        return repository.save(reservation);
    }
    
    public Reservations getReservationsById(int id){
        return repository.findById(id).orElse(null);
    }
    
    public Reservations updateReservations(Reservations reservation){
        Reservations existReservation=getReservationsById(reservation.getIdReservation());
        existReservation.setStartDate(reservation.getStartDate()  );
        existReservation.setDevolutionDate(reservation.getDevolutionDate());
        existReservation.setStatus(reservation.getStatus());
        
        return repository.save(existReservation);        
    }
    
    public void deleteReservation(int id){
        repository.deleteById(id);
    }
    
    
}
