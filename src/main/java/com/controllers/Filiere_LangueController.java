package com.controllers;

import com.dtos.Filiere_LangueDto;
import org.springframework.web.bind.annotation.*;

import com.services.impl.Filiere_LangueServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/filiere_langue")
public class Filiere_LangueController {

    private final Filiere_LangueServiceImpl filiere_langueService;

    public Filiere_LangueController(Filiere_LangueServiceImpl filiere_langueService) {
        this.filiere_langueService = filiere_langueService;
    }

    /**
     * <p>Get all filiere_langue in the system</p>
     * @return List<Filiere_LangueDto>
     */
    @GetMapping
    public List<Filiere_LangueDto> getFiliere_Langues() {
        return filiere_langueService.getAllFiliereLangue();
    }

    /**
     * Method to get the filiere_langue based on the ID
     */
    @GetMapping("/{id}")
    public Filiere_LangueDto getFiliere_Langue(@PathVariable Long id){
        return filiere_langueService.getFiliere_LangueById(id);
    }

    /**
     * Create a new filiere_langue in the system
     */
    @PostMapping
    public Filiere_LangueDto saveFiliere_Langue(final @RequestBody Filiere_LangueDto filiere_langueDto){
        return filiere_langueService.saveFiliere_Langue(filiere_langueDto);
    }

    /**
     * Delete a filiere_langue by it's id
     */
    @DeleteMapping("/{id}")
    public Boolean deleteFiliere_Langue(@PathVariable Long id){
        return filiere_langueService.deleteFiliere_Langue(id);
    }

}
