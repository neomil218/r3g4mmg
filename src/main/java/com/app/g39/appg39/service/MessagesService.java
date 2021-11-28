/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.g39.appg39.service;

import com.app.g39.appg39.entity.Messages;
import com.app.g39.appg39.repository.MessagesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author DELL
 */

@Service
public class MessagesService {
   @Autowired
    private MessagesRepository repository;
    
    public List<Messages> getMessage(){
        return repository.findAll();
    }
    
    public Messages saveMessage(Messages message){
        return repository.save(message);
    }
    
    public Messages getMessageById(int id){
        return repository.findById(id).orElse(null);
    }
    
    public Messages updateMessage(Messages message){
        Messages existMessage=getMessageById(message.getIdMessage());
        existMessage.setMessageText(message.getMessageText()  );
                
        return repository.save(existMessage);        
    }
    
    public void deleteMessage(int id){
        repository.deleteById(id);
    }
    
    
}
