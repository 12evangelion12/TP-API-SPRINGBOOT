package com.services;

import com.dtos.Filiere_LangueDto;

import java.util.List;

public interface Filiere_LangueService {

    Filiere_LangueDto saveFiliere_Langue(Filiere_LangueDto filiere_langueDto);

    Filiere_LangueDto getFiliere_LangueById(Long id_filiere_langue);

    boolean deleteFiliere_Langue(Long id_filiere_langue);

    List<Filiere_LangueDto> getAllFiliereLangue();

}
