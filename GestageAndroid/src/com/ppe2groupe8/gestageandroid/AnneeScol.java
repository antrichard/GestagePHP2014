package com.ppe2groupe8.gestageandroid;

public class AnneeScol {
	private String anneeScol;

	public AnneeScol() {}
	
	public AnneeScol(String anneeScol) {
		super();
		this.anneeScol = anneeScol;
	}

	public String getAnneeScol() {
		return anneeScol;
	}

	public void setAnneeScol(String anneeScol) {
		this.anneeScol = anneeScol;
	}

	@Override
	public String toString() {
		return "AnneeScol [anneeScol=" + anneeScol + "]";
	}
	
}