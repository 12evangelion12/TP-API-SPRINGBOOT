package com.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Creneau {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_creneau;
    private String date_heure;
    private String duree;
    private String type;
}
