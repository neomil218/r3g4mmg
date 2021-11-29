/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.g39.appg39.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author DELL
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="client")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idClient;
    private String name;
    private String email;
    private String password;
    private int age;
    
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="client")
    @JsonIgnoreProperties("client")
    private List<Reservations> reservations;
    
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="client")
    @JsonIgnoreProperties("client")
    private List<Messages> messages;
}
