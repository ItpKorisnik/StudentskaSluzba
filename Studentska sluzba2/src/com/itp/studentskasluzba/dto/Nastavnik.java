package com.itp.studentskasluzba.dto;

public class Nastavnik {

	int nastavnikId;
	String ime;
	String prezime;
	String zvanje;
	public Nastavnik(int nastavnikId, String ime, String prezime, String zvanje) {
		super();
		this.nastavnikId = nastavnikId;
		this.ime = ime;
		this.prezime = prezime;
		this.zvanje = zvanje;
	}
	public Nastavnik() {
		super();
	}
	public int getNastavnikId() {
		return nastavnikId;
	}
	public void setNastavnikId(int nastavnikId) {
		this.nastavnikId = nastavnikId;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getZvanje() {
		return zvanje;
	}
	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}
	
	
}
