package com.itp.studentskasluzba.dto;

public class Oglas {

	int oglasId;
	String naziv;
	String sadrzaj;
	boolean aktivan;
	OglasnaPloca oglasnaPloca;
	public Oglas(int oglasId, String naziv, String sadrzaj, boolean aktivan, OglasnaPloca oglasnaPloca) {
		super();
		this.oglasId = oglasId;
		this.naziv = naziv;
		this.sadrzaj = sadrzaj;
		this.aktivan = aktivan;
		this.oglasnaPloca = oglasnaPloca;
	}
	public Oglas() {
		super();
	}
	public int getOglasId() {
		return oglasId;
	}
	public void setOglasId(int oglasId) {
		this.oglasId = oglasId;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getSadrzaj() {
		return sadrzaj;
	}
	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}
	public boolean isAktivan() {
		return aktivan;
	}
	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}
	public OglasnaPloca getOglasnaPloca() {
		return oglasnaPloca;
	}
	public void setOglasnaPloca(OglasnaPloca oglasnaPloca) {
		this.oglasnaPloca = oglasnaPloca;
	}
	
}
