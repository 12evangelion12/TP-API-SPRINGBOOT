package com.dtos;

import lombok.Data;

@Data
public class Seance_FormationDto {

    private Long id_seance_formation;
    private String estEffectue;
    private String dureeEffective;
    private Boolean valide;
    private String commentaire;

}
