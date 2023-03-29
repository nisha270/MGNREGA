package com.mgnrega.Dto;

public class Worker_Dto {
  private String waadar;
  private String wname;
  private String wdob;
  private String wgender;
  private String pname;
  private String distric;
  private String state;
public Worker_Dto(String waadar, String wname, String wdob, String wgender, String pname, String distric,
		String state) {
	super();
	this.waadar = waadar;
	this.wname = wname;
	this.wdob = wdob;
	this.wgender = wgender;
	this.pname = pname;
	this.distric = distric;
	this.state = state;
}
public Worker_Dto() {
	super();
}
public String getWaadar() {
	return waadar;
}
public void setWaadar(String waadar) {
	this.waadar = waadar;
}
public String getWname() {
	return wname;
}
public void setWname(String wname) {
	this.wname = wname;
}
public String getWdob() {
	return wdob;
}
public void setWdob(String wdob) {
	this.wdob = wdob;
}
public String getWgender() {
	return wgender;
}
public void setWgender(String wgender) {
	this.wgender = wgender;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getDistric() {
	return distric;
}
public void setDistric(String distric) {
	this.distric = distric;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
@Override
public String toString() {
	return "Worker_Dto [waadar=" + waadar + ", wname=" + wname + ", wdob=" + wdob + ", wgender=" + wgender + ", pname="
			+ pname + ", distric=" + distric + ", state=" + state + "/n";
}
  
}
