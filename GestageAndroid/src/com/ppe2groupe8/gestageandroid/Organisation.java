package com.ppe2groupe8.gestageandroid;

public class Organisation {
	private int idOrganisation;
	private String nom_organisation;
	private String ville_organisation;
	private String adresse_organisation;
	private String cp_organisation;
	private String tel_organisation;
	private String fax_organisation;
	private String formeJuridique;
	private String activite;

	public Organisation() {}

	public Organisation(int idOrganisation, String nom_organisation,
			String ville_organisation, String adresse_organisation,
			String cp_organisation, String tel_organisation,
			String fax_organisation, String formeJuridique, String activite) {
		super();
		this.idOrganisation = idOrganisation;
		this.nom_organisation = nom_organisation;
		this.ville_organisation = ville_organisation;
		this.adresse_organisation = adresse_organisation;
		this.cp_organisation = cp_organisation;
		this.tel_organisation = tel_organisation;
		this.fax_organisation = fax_organisation;
		this.formeJuridique = formeJuridique;
		this.activite = activite;
	}

	public int getIdOrganisation() {
		return idOrganisation;
	}

	public void setIdOrganisation(int idOrganisation) {
		this.idOrganisation = idOrganisation;
	}

	public String getNom_organisation() {
		return nom_organisation;
	}

	public void setNom_organisation(String nom_organisation) {
		this.nom_organisation = nom_organisation;
	}

	public String getVille_organisation() {
		return ville_organisation;
	}

	public void setVille_organisation(String ville_organisation) {
		this.ville_organisation = ville_organisation;
	}

	public String getAdresse_organisation() {
		return adresse_organisation;
	}

	public void setAdresse_organisation(String adresse_organisation) {
		this.adresse_organisation = adresse_organisation;
	}

	public String getCp_organisation() {
		return cp_organisation;
	}

	public void setCp_organisation(String cp_organisation) {
		this.cp_organisation = cp_organisation;
	}

	public String getTel_organisation() {
		return tel_organisation;
	}

	public void setTel_organisation(String tel_organisation) {
		this.tel_organisation = tel_organisation;
	}

	public String getFax_organisation() {
		return fax_organisation;
	}

	public void setFax_organisation(String fax_organisation) {
		this.fax_organisation = fax_organisation;
	}

	public String getFormeJuridique() {
		return formeJuridique;
	}

	public void setFormeJuridique(String formeJuridique) {
		this.formeJuridique = formeJuridique;
	}

	public String getActivite() {
		return activite;
	}

	public void setActivite(String activite) {
		this.activite = activite;
	}

	@Override
	public String toString() {
		return "Organisation [idOrganisation=" + idOrganisation
				+ ", nom_organisation=" + nom_organisation
				+ ", ville_organisation=" + ville_organisation
				+ ", adresse_organisation=" + adresse_organisation
				+ ", cp_organisation=" + cp_organisation
				+ ", tel_organisation=" + tel_organisation
				+ ", fax_organisation=" + fax_organisation
				+ ", formeJuridique=" + formeJuridique + ", activite="
				+ activite + "]";
	}
	
	
	
}