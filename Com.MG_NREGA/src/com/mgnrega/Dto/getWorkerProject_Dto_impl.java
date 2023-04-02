package com.mgnrega.Dto;

public class getWorkerProject_Dto_impl implements getWorkerProject_Dto {
   private String name;
   private int days;
   private double wages;
public getWorkerProject_Dto_impl(String name, int days) {
	super();
	this.name = name;
	this.days = days;
}

public getWorkerProject_Dto_impl(String name, double wages) {
	super();
	this.name = name;
	this.wages = wages;
}

public getWorkerProject_Dto_impl() {
	super();
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getDays() {
	return days;
}
public void setDays(int days) {
	this.days = days;
}
@Override
public String toString() {
	return "name=" + name + ", days=" + days + "\n";
}

public double getWages() {
	return wages;
}

public void setWages(double wages) {
	this.wages = wages;
}
 
}
