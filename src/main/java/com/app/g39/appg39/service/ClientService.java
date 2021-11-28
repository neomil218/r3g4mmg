/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.g39.appg39.service;

import com.app.g39.appg39.entity.Category;
import com.app.g39.appg39.entity.Client;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.g39.appg39.repository.ClientRepository;

/**
 *
 * @author DELL
 */
@Service
public class ClientService {
    
    @Autowired
    private ClientRepository repository;
    
    public List<Client> getClient(){
        return repository.findAll();
    }
    
    public Client getClientById(int id){
        return repository.findById(id).orElse(null);
    } 
    
    public Client saveClient(Client client){
        return repository.save(client);
    }
    
    public Client updateClient(Client client){
        Client existClient=getClientById(client.getIdClient());
        existClient.setName(client.getName());
        existClient.setEmail(client.getEmail());
        existClient.setPassword(client.getPassword());
        existClient.setAge(client.getAge());
        return repository.save(existClient);
    }
    
    public void deleteClient(int id){
        repository.deleteById(id);
    }
    
    
}
