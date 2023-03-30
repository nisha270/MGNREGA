package com.mgnrega.Dto;

import java.sql.Date;
import java.time.LocalDate;

public class cprojectDto_Impl implements CProject_Dto{
    private String projectName;
    private LocalDate startDate;
    private LocalDate endDate;
    private int numberOfWorkers;
    private double perDayWages;
	public cprojectDto_Impl( String projectName, LocalDate startDate, LocalDate endDate, int numberOfWorkers,
			double perDayWages) {
		super();
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.numberOfWorkers = numberOfWorkers;
		this.perDayWages = perDayWages;
	}

	public cprojectDto_Impl() {
		super();
	}

	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public int getNumberOfWorkers() {
		return numberOfWorkers;
	}
	public void setNumberOfWorkers(int numberOfWorkers) {
		this.numberOfWorkers = numberOfWorkers;
	}
	public double getPerDayWages() {
		return perDayWages;
	}
	public void setPerDayWages(double perDayWages) {
		this.perDayWages = perDayWages;
	}
	@Override
	public String toString() {
		return "projectName=" + projectName + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", numberOfWorkers=" + numberOfWorkers + ", perDayWages=" + perDayWages
				+ "/n";
	}
	
    
}
