package com.mgnrega.Dto;

import java.time.LocalDate;

public interface CProject_Dto {

	public String getProjectName();

	public void setProjectName(String projectName);

	public LocalDate getStartDate();

	public void setStartDate(LocalDate startDate);

	public LocalDate getEndDate();

	public void setEndDate(LocalDate endDate);

	public int getNumberOfWorkers();

	public void setNumberOfWorkers(int numberOfWorkers);

	public double getPerDayWages();

	public void setPerDayWages(double perDayWages);
}
