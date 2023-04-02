package com.mgnrega.Dto;

import java.time.LocalDate;

public interface Worker_Dto {
	public String getWaadar();

	public void setWaadar(String waadar);

	public String getWname();

	public void setWname(String wname);

	public LocalDate getWdob();

	public void setWdob(LocalDate wdob);

	public String getWgender();

	public void setWgender(String wgender);

	public String getPname();

	public void setPname(String pname);

	public String getDistric();

	public void setDistric(String distric);

	public String getState();

	public void setState(String state);
}
