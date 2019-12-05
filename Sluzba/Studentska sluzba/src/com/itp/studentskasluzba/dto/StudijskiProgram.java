package com.itp.studentskasluzba.dto;

public class StudijskiProgram {

	int studijskiProgramId;
	String naziv;
	Ciklus ciklus;
	
	
	public StudijskiProgram(int studijskiProgramId, String naziv, Ciklus ciklus) {
		super();
		this.studijskiProgramId = studijskiProgramId;
		this.naziv = naziv;
		this.ciklus = ciklus;
	}
	
	
	public StudijskiProgram() {
		super();
	}
	
	
	public int getStudijskiProgramId() {
		return studijskiProgramId;
	}
	public void setStudijskiProgramId(int studijskiProgramId) {
		this.studijskiProgramId = studijskiProgramId;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public Ciklus getCiklus() {
		return ciklus;
	}
	public void setCiklus(Ciklus ciklus) {
		this.ciklus = ciklus;
	}
	
	
	
}
