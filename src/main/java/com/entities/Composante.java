package com.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Composante {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_composante;
    private String nomComposante;
}
