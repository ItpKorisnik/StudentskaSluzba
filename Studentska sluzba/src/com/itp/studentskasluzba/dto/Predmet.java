package com.itp.studentskasluzba.dto;

public class Predmet {

	int predmetId;
	String naziv;
	boolean obavezanPredmet;
	int ects;
	public Predmet(int predmetId, String naziv, boolean obavezanPredmet, int ects) {
		super();
		this.predmetId = predmetId;
		this.naziv = naziv;
		this.obavezanPredmet = obavezanPredmet;
		this.ects = ects;
	}
	public Predmet() {
		super();
	}
	public int getPredmetId() {
		return predmetId;
	}
	public void setPredmetId(int predmetId) {
		this.predmetId = predmetId;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public boolean isObavezanPredmet() {
		return obavezanPredmet;
	}
	public void setObavezanPredmet(boolean obavezanPredmet) {
		this.obavezanPredmet = obavezanPredmet;
	}
	public int getEcts() {
		return ects;
	}
	public void setEcts(int ects) {
		this.ects = ects;
	}
	
	
}
