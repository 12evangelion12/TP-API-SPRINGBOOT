package com.services.impl;

import com.dtos.ComposanteDto;
import com.entities.Composante;
import com.repositories.ComposanteRepository;
import com.services.ComposanteService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("ComposanteService")
public class ComposanteServiceImpl implements ComposanteService {

    private final ComposanteRepository composanteRepository;

    public ComposanteServiceImpl(ComposanteRepository composanteRepository){
        this.composanteRepository = composanteRepository;
    }

    @Override public ComposanteDto saveComposante(ComposanteDto composanteDto) {

        Composante composante = composanteDtoToEntity(composanteDto);
        composante = composanteRepository.save(composante);
        return composanteEntityToDto(composante);
    }

    @Override public ComposanteDto getComposanteById(Long id_composante) {
        Composante composante = composanteRepository.findById(id_composante).orElseThrow(() -> new EntityNotFoundException("Composante not found"));
        return composanteEntityToDto(composante);
    }

    @Override public boolean deleteComposante(Long id_composante) {
        composanteRepository.deleteById(id_composante);
        return true;
    }

    @Override public List<ComposanteDto> getAllComposante() {
        List<ComposanteDto> composanteDtos = new ArrayList<>();
        List<Composante> composantes = composanteRepository.findAll();
        composantes.forEach(composante -> {
            composanteDtos.add(composanteEntityToDto(composante));
        });
        return composanteDtos;
    }


    /**
     * Map user dto to user entity
     */
    private ComposanteDto composanteEntityToDto(Composante composante){
        ComposanteDto composanteDto = new ComposanteDto();
        composanteDto.setId_composante(composante.getId_composante());
        composanteDto.setNomComposante(composante.getNomComposante());
        return composanteDto;
    }

    /**
     * Map user entity to user dto
     */
    private Composante composanteDtoToEntity(ComposanteDto composanteDto){
        Composante composante = new Composante();
        composante.setId_composante(composanteDto.getId_composante());
        composante.setNomComposante(composanteDto.getNomComposante());
        return composante;
    }
}
