package com.controllers;

import com.dtos.CoursDto;
import org.springframework.web.bind.annotation.*;

import com.services.impl.CoursServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/cours")
public class CoursController {

    private final CoursServiceImpl coursService;

    public CoursController(CoursServiceImpl coursService) {
        this.coursService = coursService;
    }

    /**
     * <p>Get all cours in the system</p>
     * @return List<CoursDto>
     */
    @GetMapping
    public List<CoursDto> getCourss() {
        return coursService.getAllCours();
    }

    /**
     * Method to get the cours based on the ID
     */
    @GetMapping("/{id}")
    public CoursDto getCours(@PathVariable Long id){
        return coursService.getCoursById(id);
    }

    /**
     * Create a new cours in the system
     */
    @PostMapping
    public CoursDto saveCours(final @RequestBody CoursDto coursDto){
        return coursService.saveCours(coursDto);
    }

    /**
     * Delete a cours by it's id
     */
    @DeleteMapping("/{id}")
    public Boolean deleteCours(@PathVariable Long id){
        return coursService.deleteCours(id);
    }

}
