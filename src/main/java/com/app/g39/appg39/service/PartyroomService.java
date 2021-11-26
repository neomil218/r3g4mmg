/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.g39.appg39.service;

import com.app.g39.appg39.entity.Partyroom;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.g39.appg39.repository.PartyroomRepository;


/**
 *
 * @author DELL
 */

@Service
public class PartyroomService {
   @Autowired
    private PartyroomRepository repository;
    
    public List<Partyroom> getPartyroom(){
        return repository.findAll();
    }
    
    public Partyroom savePartyroom(Partyroom partyroom){
        return repository.save(partyroom);
    }
    
    public Partyroom getPartyroomById(int id){
        return repository.findById(id).orElse(null);
    }
    
    public Partyroom updatePartyroom(Partyroom partyroom){
        Partyroom existePartyroom=getPartyroomById(partyroom.getId());
        existePartyroom.setOwner(partyroom.getOwner()  );
        existePartyroom.setCapacity(partyroom.getCapacity());
        existePartyroom.setName(partyroom.getName());
        existePartyroom.setDescription(partyroom.getDescription());
        return repository.save(existePartyroom);        
    }
    
    public void deleteProducto(int id){
        repository.deleteById(id);
    }
    
    
}
