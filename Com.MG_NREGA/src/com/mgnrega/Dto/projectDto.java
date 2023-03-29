package com.mgnrega.Dto;

import java.sql.Date;

public class projectDto {
	private int projectId;
    private String projectName;
    private Date startDate;
    private Date endDate;
    private int numberOfWorkers;
    private double perDayWages;
	public projectDto(int projectId, String projectName, Date startDate, Date endDate, int numberOfWorkers,
			double perDayWages) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.numberOfWorkers = numberOfWorkers;
		this.perDayWages = perDayWages;
	}
	public projectDto() {
		super();
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
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
		return "projectDto [projectId=" + projectId + ", projectName=" + projectName + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", numberOfWorkers=" + numberOfWorkers + ", perDayWages=" + perDayWages
				+ "/n";
	}
    
    
}
