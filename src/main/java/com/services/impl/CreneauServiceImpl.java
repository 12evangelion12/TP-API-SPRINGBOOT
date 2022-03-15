package com.services.impl;

import com.dtos.CreneauDto;
import com.entities.Creneau;
import com.repositories.CreneauRepository;
import com.services.CreneauService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("creneauService")
public class CreneauServiceImpl implements CreneauService {

    private final CreneauRepository creneauRepository;

    public CreneauServiceImpl(CreneauRepository creneauRepository){
        this.creneauRepository = creneauRepository;
    }

    @Override
    public CreneauDto saveCreneau(CreneauDto creneauDto) {
        // Converts the dto to the creneau entity
        Creneau creneau = creneauDtoToEntity(creneauDto);
        // Save the creneau entity
        creneau = creneauRepository.save(creneau);
        // Return the new dto
        return creneauEntityToDto(creneau);
    }

    @Override
    public CreneauDto getCreneauById(Long creneauId) {
        Creneau creneau = creneauRepository.findById(creneauId).orElseThrow(() -> new EntityNotFoundException("User not found"));
        return creneauEntityToDto(creneau);
    }

    @Override
    public boolean deleteCreneau(Long creneauId) {
        creneauRepository.deleteById(creneauId);
        return true;
    }

    @Override
    public List<CreneauDto> getAllCreneaux() {
        List<CreneauDto> creneauDtos = new ArrayList<>();
        List<Creneau> creneaus = creneauRepository.findAll();
        creneaus.forEach(dog -> {
            creneauDtos.add(creneauEntityToDto(dog));
        });
        return creneauDtos;
    }

    /**
     * Map user dto to user entity
     */
    private CreneauDto creneauEntityToDto(Creneau creneau){
        CreneauDto creneauDto = new CreneauDto();
        creneauDto.setId_creneau(creneau.getId_creneau());
        creneauDto.setDuree(creneau.getDuree());
        creneauDto.setDate_heure(creneau.getDate_heure());
        creneauDto.setType(creneau.getType());
        return creneauDto;
    }

    /**
     * Map user entity to user dto
     */
    private Creneau creneauDtoToEntity(CreneauDto creneauDto){
        Creneau creneau = new Creneau();
        creneau.setId_creneau(creneauDto.getId_creneau());
        creneau.setDuree(creneauDto.getDuree());
        creneau.setType(creneauDto.getType());
        creneau.setDate_heure(creneauDto.getDate_heure());
        return creneau;
    }
}
