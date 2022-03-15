package com.services;

import com.dtos.ComposanteDto;

import java.util.List;

public interface ComposanteService {

    ComposanteDto saveComposante(ComposanteDto composanteDto);

    ComposanteDto getComposanteById(Long id_composante);

    boolean deleteComposante(Long id_composante);

    List<ComposanteDto> getAllComposante();

}
