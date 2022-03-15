package com.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Seance_Formation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_seance_formation;
    private String estEffectue;
    private String dureeEffective;
    private Boolean valide;
    private String commentaire;
}

