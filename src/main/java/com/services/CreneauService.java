package com.services;

import com.dtos.CreneauDto;

import java.util.List;

public interface CreneauService {

    CreneauDto saveCreneau(CreneauDto creneauDto);

    CreneauDto getCreneauById(Long id_creneau);

    boolean deleteCreneau(Long id_creneau);

    List<CreneauDto> getAllCreneaux();

}
