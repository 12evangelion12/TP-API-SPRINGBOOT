package com.controllers;

import com.dtos.CreneauDto;
import org.springframework.web.bind.annotation.*;

import com.services.impl.CreneauServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/creneaux")
public class CreneauController {

    private final CreneauServiceImpl creneauService;

    public CreneauController(CreneauServiceImpl creneauService) {
        this.creneauService = creneauService;
    }

    /**
     * <p>Get all creneaux in the system</p>
     * @return List<CreneauDto>
     */
    @GetMapping
    public List<CreneauDto> getCreneaux() {
        return creneauService.getAllCreneaux();
    }

    /**
     * Method to get the creneau based on the ID
     */
    @GetMapping("/{id}")
    public CreneauDto getCreneau(@PathVariable Long id){
        return creneauService.getCreneauById(id);
    }

    /**
     * Create a new creneau in the system
     */
    @PostMapping
    public CreneauDto saveCreneau(final @RequestBody CreneauDto creneauDto){
        return creneauService.saveCreneau(creneauDto);
    }

    /**
     * Delete a creneau by it's id
     */
    @DeleteMapping("/{id}")
    public Boolean deleteCreneau(@PathVariable Long id){
        return creneauService.deleteCreneau(id);
    }

}
