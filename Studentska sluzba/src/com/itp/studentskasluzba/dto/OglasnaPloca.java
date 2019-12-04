package com.itp.studentskasluzba.dto;

public class OglasnaPloca {

	int plocaId;
	String oglasnaPloca;
	public OglasnaPloca(int plocaId, String oglasnaPloca) {
		super();
		this.plocaId = plocaId;
		this.oglasnaPloca = oglasnaPloca;
	}
	public OglasnaPloca() {
		super();
	}
	public int getPlocaId() {
		return plocaId;
	}
	public void setPlocaId(int plocaId) {
		this.plocaId = plocaId;
	}
	public String getOglasnaPloca() {
		return oglasnaPloca;
	}
	public void setOglasnaPloca(String oglasnaPloca) {
		this.oglasnaPloca = oglasnaPloca;
	}
	
	
}
