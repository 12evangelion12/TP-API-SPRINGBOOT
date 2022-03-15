package com.services;

import com.dtos.CoursDto;

import java.util.List;

public interface CoursService {

    CoursDto saveCours(CoursDto coursDto);

    CoursDto getCoursById(Long id_cours);

    boolean deleteCours(Long id_cours);

    List<CoursDto> getAllCours();

}
