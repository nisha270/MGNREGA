
package com.mgnrega.Dto;

import java.time.LocalDate;

public interface Gpm_Dto {
	public String getAadhar_number();

	public void setAadhar_number(String aadhar_number);

	public String getName();

	public void setName(String name);

	public LocalDate getDob();

	public void setDob(LocalDate dob);

	public String getGender();

	public void setGender(String gender);

	public String getPanchyatName();

	public void setPanchyatName(String panchyatName);

	public String getDistric();

	public void setDistric(String distric);

	public String getState();

	public void setState(String state);
}
