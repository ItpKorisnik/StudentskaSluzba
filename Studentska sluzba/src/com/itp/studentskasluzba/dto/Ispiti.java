package com.itp.studentskasluzba.dto;

public class Ispiti {

	int ispitId;
	String datum;
	int ocjena;
	int brojBodova;
	Nastavnik nastavnik;
	Studenti studenti;
	StudijskiProgram studijskiProgram;
	public Ispiti(int ispitId, String datum, int ocjena, int brojBodova, Nastavnik nastavnik, Studenti studenti,
			StudijskiProgram studijskiProgram) {
		super();
		this.ispitId = ispitId;
		this.datum = datum;
		this.ocjena = ocjena;
		this.brojBodova = brojBodova;
		this.nastavnik = nastavnik;
		this.studenti = studenti;
		this.studijskiProgram = studijskiProgram;
	}
	public Ispiti() {
		super();
	}
	public int getIspitId() {
		return ispitId;
	}
	public void setIspitId(int ispitId) {
		this.ispitId = ispitId;
	}
	public String getDatum() {
		return datum;
	}
	public void setDatum(String datum) {
		this.datum = datum;
	}
	public int getOcjena() {
		return ocjena;
	}
	public void setOcjena(int ocjena) {
		this.ocjena = ocjena;
	}
	public int getBrojBodova() {
		return brojBodova;
	}
	public void setBrojBodova(int brojBodova) {
		this.brojBodova = brojBodova;
	}
	public Nastavnik getNastavnik() {
		return nastavnik;
	}
	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}
	public Studenti getStudenti() {
		return studenti;
	}
	public void setStudenti(Studenti studenti) {
		this.studenti = studenti;
	}
	public StudijskiProgram getStudijskiProgram() {
		return studijskiProgram;
	}
	public void setStudijskiProgram(StudijskiProgram studijskiProgram) {
		this.studijskiProgram = studijskiProgram;
	}
	
	
}
