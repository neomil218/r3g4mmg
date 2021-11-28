/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.g39.appg39.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author hp
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="messages")
public class Messages implements Serializable {    
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private int idMessage;
        private String messageText;
        
        @ManyToOne
        @JoinColumn(name="partyroom_id") 
        @JsonIgnoreProperties("messages_")
        private Partyroom partyroom;
        
        @ManyToOne
        @JoinColumn(name="client_id") 
        @JsonIgnoreProperties("messages_")
        private Client client;
        
}
