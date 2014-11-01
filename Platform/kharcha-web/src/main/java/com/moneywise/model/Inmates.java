package com.moneywise.model;

public class Inmates {
	
	private String inmates_name;
	
	private int inmates_id;
	private String inmates_email;
	
	private String inmates_password;
	
	private int inmates_mobile;

	public String getInmates_names() {
		return inmates_name;
	}

	public void setInmates_names(String inmates_names) {
		this.inmates_name = inmates_names;
	}

	public int getInmates_id() {
		return inmates_id;
	}

	public void setInmates_id(int inmates_id) {
		this.inmates_id = inmates_id;
	}

	public String getInmates_email() {
		return inmates_email;
	}

	public void setInmates_email(String inmates_email) {
		this.inmates_email = inmates_email;
	}

	public String getInmates_password() {
		return inmates_password;
	}

	public void setInmates_password(String inmates_password) {
		this.inmates_password = inmates_password;
	}

	public int getInmates_mobile() {
		return inmates_mobile;
	}

	public void setInmates_mobile(int inmates_mobile) {
		this.inmates_mobile = inmates_mobile;
	}

	@Override
	public String toString() {
		return "Inmates [inmates_names=" + inmates_name + ", inmates_id="
				+ inmates_id + ", inmates_email=" + inmates_email
				+ ", inmates_password=" + inmates_password
				+ ", inmates_mobile=" + inmates_mobile + "]";
	}
	
}
