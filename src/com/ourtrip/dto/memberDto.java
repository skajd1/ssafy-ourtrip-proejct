package com.ourtrip.dto;

public class memberDto {
	String id;
	String name;
	String pw;
	String email;
	String domain;
	String jdate;
	public memberDto() {}
	
	public memberDto(String id, String pw, String name, String email, String domain) {
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.email = email;
		this.domain = domain;
	}


	public memberDto(String id, String name, String pw, String email, String domain, String jdate) {
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.email = email;
		this.domain = domain;
		this.jdate = jdate;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domail) {
		this.domain = domail;
	}

	public String getJdate() {
		return jdate;
	}

	public void setJdate(String jdate) {
		this.jdate = jdate;
	}

	@Override
	public String toString() {
		return "memberDto [id=" + id + ", name=" + name + ", pw=" + pw + ", email=" + email + ", domain=" + domain
				+ ", jdate=" + jdate + "]";
	}
	

}
