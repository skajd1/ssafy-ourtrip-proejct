package com.ourtrip.dto;

public class Sido {

	int sidoCode;
	String sidoName;
	
	public Sido (int code, String name) {
		this.sidoCode = code;
		this.sidoName = name;
	}

	public int getSidoCode() {
		return sidoCode;
	}

	public void setSidoCode(int sidoCode) {
		this.sidoCode = sidoCode;
	}

	public String getSidoName() {
		return sidoName;
	}

	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}
	
	
}
