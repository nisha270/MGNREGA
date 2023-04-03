package com.mgnrega_Ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.mgnrega.Dao.Bdo_Dao;
import com.mgnrega.Dao.Bdo_Dao_Impl;
import com.mgnrega.Dto.CProject_Dto;
import com.mgnrega.Dto.Gpm_Dto;
import com.mgnrega.Dto.Gpm_Dto_impl;
import com.mgnrega.Dto.cprojectDto_Impl;
import com.mgnrega.Dto.gpm_project_Impl_Dto;
import com.mgnrega.Dto.gpm_project_dto;
import com.mgnrega.Exception.NoRecordFoundException;
import com.mgnrega.Exception.SomethingWentWrongException;
import com.mgnrega.custom.Console_Color;

public class Bdo_Ui {

//	Create a project with details projectName, startDate, endDate, noOfWorkers,per_day_wages
	public static void CreateProject_Ui() throws SomethingWentWrongException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println(Console_Color.CYAN+"Enter Your Project Name : ");
		String pname = sc.next();
		sc.nextLine();

		System.out.println("Enter Start Date formate(yyyy-mm-dd) : ");
		LocalDate sdate = LocalDate.parse(sc.next());

		System.out.println("Enter End Date formate(yyyy-mm-dd) : ");
		LocalDate edate = LocalDate.parse(sc.next());

		System.out.println("Enter Numbers of workers: ");
		int num_workers = sc.nextInt();

		System.out.println("Enter per_day_wages"+Console_Color.RESET);
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

//	View List of Projects
	public static void AllProjects_Ui() throws SomethingWentWrongException, NoRecordFoundException {
		Bdo_Dao bd = new Bdo_Dao_Impl();
		try {
			List<CProject_Dto> p = bd.allProject();
			p.forEach(s -> {
				System.out.println(Console_Color.ORANGE+
						"<============================================================================================================================>");
				System.out.println("    Project Name : " + s.getProjectName() + " start Date : " + s.getStartDate()
						+ " end Date : " + s.getEndDate() + " Numbers Of Workers : " + s.getNumberOfWorkers()
						+ " Par day wages : " + s.getPerDayWages());
				System.out.println(
						"<=============================================================================================================================>"+Console_Color.RESET);
			});
		} catch (SomethingWentWrongException e) {
			throw new SomethingWentWrongException("Something Went Wrong!");
		}

	}

//	Add gram panchayat member with details aadhaar_number, name, dob, gender,panchayat name, district, state
	public static void AddGpm_Ui() throws SomethingWentWrongException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter GPM's Adhar Number : ");
		String aadhar = sc.next();

		System.out.println("Enter GPM's Name : ");
		String name = sc.next();

		System.out.println("Enter GPM's DOB formate(yyyy-mm-dd) : ");
		LocalDate dob = LocalDate.parse(sc.next());

		System.out.println("Enter GPM's Gender : ");
		String gender = sc.next();

		System.out.println("Enter Panchayat Name : ");
		sc.nextLine();
		String pname = sc.nextLine();
		
		

		System.out.println("Enter GPM's Distric Name : ");
		String dname = sc.next();

		System.out.println("Enter GPM's State Name : ");
		String sname = sc.next();

		Gpm_Dto gd = new Gpm_Dto_impl(aadhar, name, dob, gender, pname, dname, sname);
		Bdo_Dao bd = new Bdo_Dao_Impl();
		try {
			bd.addGpm(gd);
			System.out.println("Successfully add Gpm's Details");
		} catch (Exception e) {
			throw new SomethingWentWrongException("Unable to Add Details..");
//			System.out.println(e);
		}
		System.out.println();
	}

//	View all the GPMs
	public static void All_Gpm_Ui() throws SomethingWentWrongException, NoRecordFoundException {
		Bdo_Dao bd = new Bdo_Dao_Impl();
		try {
			List<Gpm_Dto>p=bd.allgpm();
			p.forEach(s -> {
				System.out.println(Console_Color.ORANGE+
						"<============================================================================================================================>");
				System.out.println("    Aadhar Number : " + s.getAadhar_number() + " Name : " + s.getName() + " DOB : "
						+ s.getDob() + " Gender : " + s.getGender() + " PANCHAYAT_NAME : " + s.getPanchyatName()
						+ " Distric : " + s.getDistric() + " State : " + s.getState());
				System.out.println(
						"<=============================================================================================================================>"+Console_Color.RESET);
			});
		} catch (SomethingWentWrongException e) {
//			System.out.println(e);
			throw new SomethingWentWrongException("Something Went Wrong!");
		}

	}

//	Allocate a project to a GPM.
	public static void AllocateTheProject_Ui()throws SomethingWentWrongException{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Gpm Id : ");
		int g_id=sc.nextInt();
		
		System.out.println("Enter Project Id : ");
		int p_id=sc.nextInt();
		
		gpm_project_dto gp= new gpm_project_Impl_Dto(g_id,p_id);
		Bdo_Dao bd=new Bdo_Dao_Impl();
		
		try {
			bd.AllocateTheProject(gp);
			System.out.println("Allocated The Project");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}






















