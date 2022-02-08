package com.services;

import com.dtos.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {
    /**
     * Sauve a dog
     */
    UtilisateurDto saveUtilisateur(UtilisateurDto utilisateurDto);

    /**
     * Get a dog by it's id
     */
    UtilisateurDto getUtilisateurById(Long utilisateurId);

    /**
     * Delete a dog by it's id
     */
    boolean deleteUtilisateur(Long utilisateurId);

    /**
     * Get all the dogs
     */
    List<UtilisateurDto> getAllUtilisateurs();


}
