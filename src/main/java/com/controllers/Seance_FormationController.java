package com.controllers;

import com.dtos.Seance_FormationDto;
import org.springframework.web.bind.annotation.*;

import com.services.impl.Seance_FormationServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/seance_formation")
public class Seance_FormationController {

    private final Seance_FormationServiceImpl seance_formationService;

    public Seance_FormationController(Seance_FormationServiceImpl seance_formationService) {
        this.seance_formationService = seance_formationService;
    }

    /**
     * <p>Get all seance_formation in the system</p>
     * @return List<Seance_FormationDto>
     */
    @GetMapping
    public List<Seance_FormationDto> getSeance_Formations() {
        return seance_formationService.getAllSeance_Formation();
    }

    /**
     * Method to get the seance_formation based on the ID
     */
    @GetMapping("/{id}")
    public Seance_FormationDto getSeance_Formation(@PathVariable Long id){
        return seance_formationService.getSeance_FormationById(id);
    }

    /**
     * Create a new seance_formation in the system
     */
    @PostMapping
    public Seance_FormationDto saveSeance_Formation(final @RequestBody Seance_FormationDto seance_formationDto){
        return seance_formationService.saveSeance_Formation(seance_formationDto);
    }

    /**
     * Delete a seance_formation by it's id
     */
    @DeleteMapping("/{id}")
    public Boolean deleteSeance_Formation(@PathVariable Long id){
        return seance_formationService.deleteSeance_Formation(id);
    }

}
