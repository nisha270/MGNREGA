package com.mgnrega.Dto;

import java.time.LocalDate;

public class Gpm_Dto_impl implements Gpm_Dto {

	private String aadhar_number;
	private String name;
	private LocalDate dob;
	private String gender;
	private String panchyatName;
	private String Distric;
	private String state;
	public Gpm_Dto_impl(String aadhar_number, String name, LocalDate dob, String gender, String panchyatName,
			String distric, String state) {
		super();
		this.aadhar_number = aadhar_number;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.panchyatName = panchyatName;
		Distric = distric;
		this.state = state;
	}
	public Gpm_Dto_impl() {
		super();
	}
	public String getAadhar_number() {
		return aadhar_number;
	}
	public void setAadhar_number(String aadhar_number) {
		this.aadhar_number = aadhar_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPanchyatName() {
		return panchyatName;
	}
	public void setPanchyatName(String panchyatName) {
		this.panchyatName = panchyatName;
	}
	public String getDistric() {
		return Distric;
	}
	public void setDistric(String distric) {
		Distric = distric;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
