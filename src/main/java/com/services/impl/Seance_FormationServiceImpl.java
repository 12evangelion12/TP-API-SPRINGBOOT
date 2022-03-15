package com.services.impl;

import com.dtos.Seance_FormationDto;
import com.entities.Seance_Formation;
import com.repositories.Seance_FormationRepository;
import com.services.Seance_FormationService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("Seance_FormationService")
public class Seance_FormationServiceImpl implements Seance_FormationService {

    private final Seance_FormationRepository seance_FormationRepository;

    public Seance_FormationServiceImpl(Seance_FormationRepository seance_FormationRepository){
        this.seance_FormationRepository = seance_FormationRepository;
    }

    @Override
    public Seance_FormationDto saveSeance_Formation(Seance_FormationDto seance_FormationDto) {
        // Converts the dto to the seance_Formation entity
        Seance_Formation seance_Formation = seance_FormationDtoToEntity(seance_FormationDto);
        // Save the seance_Formation entity
        seance_Formation = seance_FormationRepository.save(seance_Formation);
        // Return the new dto
        return seance_FormationEntityToDto(seance_Formation);
    }

    @Override
    public Seance_FormationDto getSeance_FormationById(Long seance_FormationId) {
        Seance_Formation seance_Formation = seance_FormationRepository.findById(seance_FormationId).orElseThrow(() -> new EntityNotFoundException("User not found"));
        return seance_FormationEntityToDto(seance_Formation);
    }

    @Override
    public boolean deleteSeance_Formation(Long seance_FormationId) {
        seance_FormationRepository.deleteById(seance_FormationId);
        return true;
    }

    @Override
    public List<Seance_FormationDto> getAllSeance_Formation() {
        List<Seance_FormationDto> seance_FormationDtos = new ArrayList<>();
        List<Seance_Formation> seance_Formations = seance_FormationRepository.findAll();
        seance_Formations.forEach(seance_formation -> {
            seance_FormationDtos.add(seance_FormationEntityToDto(seance_formation));
        });
        return seance_FormationDtos;
    }

    /**
     * Map user dto to user entity
     */
    private Seance_FormationDto seance_FormationEntityToDto(Seance_Formation seance_Formation){
        Seance_FormationDto seance_FormationDto = new Seance_FormationDto();

        seance_FormationDto.setId_seance_formation(seance_Formation.getId_seance_formation());
        seance_FormationDto.setCommentaire(seance_Formation.getCommentaire());
        seance_FormationDto.setDureeEffective(seance_Formation.getDureeEffective());
        seance_FormationDto.setEstEffectue(seance_Formation.getEstEffectue());
        seance_FormationDto.setValide(seance_Formation.getValide());
        return seance_FormationDto;
    }

    /**
     * Map user entity to user dto
     */
    private Seance_Formation seance_FormationDtoToEntity(Seance_FormationDto seance_FormationDto){
        Seance_Formation seance_Formation = new Seance_Formation();

        seance_Formation.setId_seance_formation(seance_FormationDto.getId_seance_formation());
        seance_Formation.setCommentaire(seance_FormationDto.getCommentaire());
        seance_Formation.setDureeEffective(seance_FormationDto.getDureeEffective());
        seance_Formation.setEstEffectue(seance_FormationDto.getEstEffectue());
        seance_Formation.setValide(seance_FormationDto.getValide());
        return seance_Formation;
    }
}
