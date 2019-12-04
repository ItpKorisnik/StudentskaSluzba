package com.itp.studentskasluzba.dto;

public class Studenti {

	int studentId;
	String ime;
	String prezime;
	String brojIndexa;
	String godinaUpisa;
	public Studenti(int studentId, String ime, String prezime, String brojIndexa, String godinaUpisa) {
		super();
		this.studentId = studentId;
		this.ime = ime;
		this.prezime = prezime;
		this.brojIndexa = brojIndexa;
		this.godinaUpisa = godinaUpisa;
	}
	public Studenti() {
		super();
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
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
	public String getBrojIndexa() {
		return brojIndexa;
	}
	public void setBrojIndexa(String brojIndexa) {
		this.brojIndexa = brojIndexa;
	}
	public String getGodinaUpisa() {
		return godinaUpisa;
	}
	public void setGodinaUpisa(String godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}
	
	
}
