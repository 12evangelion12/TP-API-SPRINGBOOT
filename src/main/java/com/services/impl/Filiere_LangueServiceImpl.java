package com.services.impl;

import com.dtos.Filiere_LangueDto;
import com.entities.Filiere_Langue;
import com.repositories.Filiere_LangueRepository;
import com.services.Filiere_LangueService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("filiere_LangueService")
public class Filiere_LangueServiceImpl implements Filiere_LangueService {

    private final Filiere_LangueRepository filiere_LangueRepository;

    public Filiere_LangueServiceImpl(Filiere_LangueRepository filiere_LangueRepository){
        this.filiere_LangueRepository = filiere_LangueRepository;
    }

    @Override
    public Filiere_LangueDto saveFiliere_Langue(Filiere_LangueDto filiere_LangueDto) {
        // Converts the dto to the filiere_Langue entity
        Filiere_Langue filiere_Langue = filiere_LangueDtoToEntity(filiere_LangueDto);
        // Save the filiere_Langue entity
        filiere_Langue = filiere_LangueRepository.save(filiere_Langue);
        // Return the new dto
        return filiere_LangueEntityToDto(filiere_Langue);
    }

    @Override
    public Filiere_LangueDto getFiliere_LangueById(Long filiere_LangueId) {
        Filiere_Langue filiere_Langue = filiere_LangueRepository.findById(filiere_LangueId).orElseThrow(() -> new EntityNotFoundException("User not found"));
        return filiere_LangueEntityToDto(filiere_Langue);
    }

    @Override
    public boolean deleteFiliere_Langue(Long filiere_LangueId) {
        filiere_LangueRepository.deleteById(filiere_LangueId);
        return true;
    }

    @Override
    public List<Filiere_LangueDto> getAllFiliereLangue() {
        List<Filiere_LangueDto> filiere_LangueDtos = new ArrayList<>();
        List<Filiere_Langue> filiere_Langues = filiere_LangueRepository.findAll();
        filiere_Langues.forEach(filiereLangue -> {
            filiere_LangueDtos.add(filiere_LangueEntityToDto(filiereLangue));
        });
        return filiere_LangueDtos;
    }

    /**
     * Map user dto to user entity
     */
    private Filiere_LangueDto filiere_LangueEntityToDto(Filiere_Langue filiere_Langue){
        Filiere_LangueDto filiere_LangueDto = new Filiere_LangueDto();
        filiere_LangueDto.setId_filiere(filiere_Langue.getId_filiere());
        filiere_LangueDto.setNomFiliere(filiere_Langue.getNomFiliere());
        filiere_LangueDto.setCodeFiliere(filiere_Langue.getCodeFiliere());
        return filiere_LangueDto;
    }

    /**
     * Map user entity to user dto
     */
    private Filiere_Langue filiere_LangueDtoToEntity(Filiere_LangueDto filiere_LangueDto){
        Filiere_Langue filiere_Langue = new Filiere_Langue();
        filiere_Langue.setId_filiere(filiere_LangueDto.getId_filiere());
        filiere_Langue.setNomFiliere(filiere_LangueDto.getNomFiliere());
        filiere_Langue.setCodeFiliere(filiere_LangueDto.getCodeFiliere());
        return filiere_Langue;
    }
}
