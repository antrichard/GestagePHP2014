package com.ppe2groupe8.gestageandroid;

public class Personne {
	private int idPersonne;
	private int idSpecialite;
	private int idRole;
	private String civilite;
	private String nom;
	private String prenom;
	private String num_tel;
	private String adresse_mail;
	private String num_tel_mobile;
	private String etudes;
	private String formation;
	private String loginUtilisateur;
	private String mdpUtilisateur;

	public Personne() {}

	public Personne(int idPersonne, int idSpecialite, int idRole,
			String civilite, String nom, String prenom, String num_tel,
			String adresse_mail, String num_tel_mobile, String etudes,
			String formation, String loginUtilisateur, String mdpUtilisateur) {
		super();
		this.idPersonne = idPersonne;
		this.idSpecialite = idSpecialite;
		this.idRole = idRole;
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.num_tel = num_tel;
		this.adresse_mail = adresse_mail;
		this.num_tel_mobile = num_tel_mobile;
		this.etudes = etudes;
		this.formation = formation;
		this.loginUtilisateur = loginUtilisateur;
		this.mdpUtilisateur = mdpUtilisateur;
	}

	public int getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}

	public int getIdSpecialite() {
		return idSpecialite;
	}

	public void setIdSpecialite(int idSpecialite) {
		this.idSpecialite = idSpecialite;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNum_tel() {
		return num_tel;
	}

	public void setNum_tel(String num_tel) {
		this.num_tel = num_tel;
	}

	public String getAdresse_mail() {
		return adresse_mail;
	}

	public void setAdresse_mail(String adresse_mail) {
		this.adresse_mail = adresse_mail;
	}

	public String getNum_tel_mobile() {
		return num_tel_mobile;
	}

	public void setNum_tel_mobile(String num_tel_mobile) {
		this.num_tel_mobile = num_tel_mobile;
	}

	public String getEtudes() {
		return etudes;
	}

	public void setEtudes(String etudes) {
		this.etudes = etudes;
	}

	public String getFormation() {
		return formation;
	}

	public void setFormation(String formation) {
		this.formation = formation;
	}

	public String getLoginUtilisateur() {
		return loginUtilisateur;
	}

	public void setLoginUtilisateur(String loginUtilisateur) {
		this.loginUtilisateur = loginUtilisateur;
	}

	public String getMdpUtilisateur() {
		return mdpUtilisateur;
	}

	public void setMdpUtilisateur(String mdpUtilisateur) {
		this.mdpUtilisateur = mdpUtilisateur;
	}

	@Override
	public String toString() {
		return "Personne [idPersonne=" + idPersonne + ", idSpecialite="
				+ idSpecialite + ", idRole=" + idRole + ", civilite="
				+ civilite + ", nom=" + nom + ", prenom=" + prenom
				+ ", num_tel=" + num_tel + ", adresse_mail=" + adresse_mail
				+ ", num_tel_mobile=" + num_tel_mobile + ", etudes=" + etudes
				+ ", formation=" + formation + ", loginUtilisateur="
				+ loginUtilisateur + ", mdpUtilisateur=" + mdpUtilisateur + "]";
	}


}