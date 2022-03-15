package com.services;

import com.dtos.Seance_FormationDto;

import java.util.List;

public interface Seance_FormationService {

    Seance_FormationDto saveSeance_Formation(Seance_FormationDto seance_formationDto);

    Seance_FormationDto getSeance_FormationById(Long id_seance_formation);

    boolean deleteSeance_Formation(Long id_seance_formation);

    List<Seance_FormationDto> getAllSeance_Formation();

}
