package com.taxi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sr_n;
	@Column(unique = true)
	private String username;
	private String password;
	public int getSr_n() {
		return sr_n;
	}
	public void setSr_n(int sr_n) {
		this.sr_n = sr_n;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Admin(int sr_n, String username, String password) {
		super();
		this.sr_n = sr_n;
		this.username = username;
		this.password = password;
	}
	public Admin() {
		super();
	}
	@Override
	public String toString() {
		return "Admin [sr_n=" + sr_n + ", username=" + username + ", password=" + password + ", getSr_n()=" + getSr_n()
				+ ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
