package com.ppe2groupe8.gestageandroid;

public class Classe {
	private String numClasse;
	private int idSpecialite;
	private int numFiliere;
	private String nomClasse;

	public Classe() {}

	public Classe(String numClasse, int idSpecialite, int numFiliere,
			String nomClasse) {
		super();
		this.numClasse = numClasse;
		this.idSpecialite = idSpecialite;
		this.numFiliere = numFiliere;
		this.nomClasse = nomClasse;
	}

	public String getNumClasse() {
		return numClasse;
	}

	public void setNumClasse(String numClasse) {
		this.numClasse = numClasse;
	}

	public int getIdSpecialite() {
		return idSpecialite;
	}

	public void setIdSpecialite(int idSpecialite) {
		this.idSpecialite = idSpecialite;
	}

	public int getNumFiliere() {
		return numFiliere;
	}

	public void setNumFiliere(int numFiliere) {
		this.numFiliere = numFiliere;
	}

	public String getNomClasse() {
		return nomClasse;
	}

	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}

	@Override
	public String toString() {
		return "Classe [numClasse=" + numClasse + ", idSpecialite="
				+ idSpecialite + ", numFiliere=" + numFiliere + ", nomClasse="
				+ nomClasse + "]";
	}
	

	
}