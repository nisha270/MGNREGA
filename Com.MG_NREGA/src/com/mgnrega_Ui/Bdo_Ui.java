package com.mgnrega_Ui;

import java.time.LocalDate;
import java.util.Scanner;

import com.mgnrega.Dao.Bdo_Dao;
import com.mgnrega.Dao.Bdo_Dao_Impl;
import com.mgnrega.Dto.CProject_Dto;
import com.mgnrega.Dto.cprojectDto_Impl;
import com.mgnrega.Exception.SomethingWentWrongException;

public class Bdo_Ui {

//	Create a project with details projectName, startDate, endDate, noOfWorkers,per_day_wages
	public static void CreateProject_Ui() throws SomethingWentWrongException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Project Name : ");
		String pname = sc.next();
		System.out.println("Enter Start Date formate(yyyy-mm-dd) : ");
		LocalDate sdate = LocalDate.parse(sc.nextLine());
		System.out.println("Enter End Date formate(yyyy-mm-dd) : ");
		LocalDate edate = LocalDate.parse(sc.nextLine());
		System.out.println("Enter Numbers of workers: ");
		int num_workers = sc.nextInt();
		System.out.println("Enter per_day_wages");
		double per_day_wages = sc.nextDouble();

		CProject_Dto cpo = new cprojectDto_Impl(pname, sdate, edate, num_workers, per_day_wages);
		Bdo_Dao bd = new Bdo_Dao_Impl();
		try {
			bd.CreateProject(cpo);
			System.out.println("Successfully Create Project");
		} catch (SomethingWentWrongException e) {
			throw new SomethingWentWrongException("Unable to Create..");
		}

	}

	public static void AllProjects_Ui() throws SomethingWentWrongException {
		
	}

}
