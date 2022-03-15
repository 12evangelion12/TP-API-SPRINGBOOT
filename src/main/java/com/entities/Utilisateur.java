package com.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Utilisateur {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_utilisateur;
	private String login;
	private String mdp;
	private String prenom;
	private String nomUsuel;
	private String mail;
	private String tpye; //Gestionnaire, responsable, vacataire
}
