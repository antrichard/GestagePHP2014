package com.ppe2groupe8.gestageandroid;

import java.util.Date;

public class Stage {
	private int num_stage;
	private String nomEtudiant;
	private String prenomEtudiant;
	private String nomOrganisation;
	private String adresseOrganisation;
	private String villeOrganisation;
	private String nomMaitreStage;
	private String prenomMaitreStage;
	private String dateDebut;
	private String dateFin;
	private String dateVisiteStage;

	public Stage() {}

	public Stage(int num_stage, String nomEtudiant, String prenomEtudiant,
			String nomOrganisation, String adresseOrganisation,
			String villeOrganisation, String nomMaitreStage,
			String prenomMaitreStage, String dateDebut, String dateFin,
			String dateVisiteStage) {
		super();
		this.num_stage = num_stage;
		this.nomEtudiant = nomEtudiant;
		this.prenomEtudiant = prenomEtudiant;
		this.nomOrganisation = nomOrganisation;
		this.adresseOrganisation = adresseOrganisation;
		this.villeOrganisation = villeOrganisation;
		this.nomMaitreStage = nomMaitreStage;
		this.prenomMaitreStage = prenomMaitreStage;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.dateVisiteStage = dateVisiteStage;
	}

	public int getNum_stage() {
		return num_stage;
	}

	public void setNum_stage(int num_stage) {
		this.num_stage = num_stage;
	}

	public String getNomEtudiant() {
		return nomEtudiant;
	}

	public void setNomEtudiant(String nomEtudiant) {
		this.nomEtudiant = nomEtudiant;
	}

	public String getPrenomEtudiant() {
		return prenomEtudiant;
	}

	public void setPrenomEtudiant(String prenomEtudiant) {
		this.prenomEtudiant = prenomEtudiant;
	}

	public String getNomOrganisation() {
		return nomOrganisation;
	}

	public void setNomOrganisation(String nomOrganisation) {
		this.nomOrganisation = nomOrganisation;
	}

	public String getAdresseOrganisation() {
		return adresseOrganisation;
	}

	public void setAdresseOrganisation(String adresseOrganisation) {
		this.adresseOrganisation = adresseOrganisation;
	}

	public String getVilleOrganisation() {
		return villeOrganisation;
	}

	public void setVilleOrganisation(String villeOrganisation) {
		this.villeOrganisation = villeOrganisation;
	}

	public String getNomMaitreStage() {
		return nomMaitreStage;
	}

	public void setNomMaitreStage(String nomMaitreStage) {
		this.nomMaitreStage = nomMaitreStage;
	}

	public String getPrenomMaitreStage() {
		return prenomMaitreStage;
	}

	public void setPrenomMaitreStage(String prenomMaitreStage) {
		this.prenomMaitreStage = prenomMaitreStage;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public String getDateVisiteStage() {
		return dateVisiteStage;
	}

	public void setDateVisiteStage(String dateVisiteStage) {
		this.dateVisiteStage = dateVisiteStage;
	}

	
	
}