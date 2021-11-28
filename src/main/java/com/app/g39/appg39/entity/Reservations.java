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
@Table(name="reservations")
public class Reservations implements Serializable {    
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private int idReservation;
        @Temporal(javax.persistence.TemporalType.DATE)
        private Date startDate;
        @Temporal(javax.persistence.TemporalType.DATE)
        private Date devolutionDate;
        
        private String status;
        
        @ManyToOne
        @JoinColumn(name="partyroom_id") 
        @JsonIgnoreProperties("reservations_")
        private Partyroom partyroom;
        
        @ManyToOne
        @JoinColumn(name="client_id") 
        @JsonIgnoreProperties("reservations_")
        private Client client;
}
