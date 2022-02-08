package com.dtos;

import lombok.Data;

@Data
public class UtilisateurDto {

	private Long Id;
	private String login;
	private String mdp;
	private String prenom;
	private String nomUsuel;
	private String mail;
	
}
