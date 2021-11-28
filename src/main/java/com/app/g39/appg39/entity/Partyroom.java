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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="partyroom")
public class Partyroom implements Serializable {    
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private int id;
        private String owner;
        private int capacity;
        private String name;
        private String description;
        
        @ManyToOne
        @JoinColumn(name="categoria_id") 
        @JsonIgnoreProperties("partyrooms")
        private Category category;
        
        @OneToMany(cascade={CascadeType.PERSIST},mappedBy="partyroom")
        @JsonIgnoreProperties("partyroom")
        private List<Reservations> reservations_;
        
        @OneToMany(cascade={CascadeType.PERSIST},mappedBy="partyroom")
        @JsonIgnoreProperties("partyroom")
        private List<Messages> messages_;
       
}
