package com.itp.studentskasluzba.dto;

public class Ciklus {

	int ciklusId;
	String naziv;
	
	
	public Ciklus(int ciklusId, String naziv) {
		super();
		this.ciklusId=ciklusId;
		this.naziv = naziv;
	}
	
	public Ciklus() {
		super();
	}



	public int getCiklusId() {
		return ciklusId;
	}
	public void setCiklusId(int ciklusId) {
		this.ciklusId=ciklusId;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	
}
