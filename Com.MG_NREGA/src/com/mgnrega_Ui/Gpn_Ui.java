package com.mgnrega_Ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.mgnrega.Dao.Bdo_Dao;
import com.mgnrega.Dao.Bdo_Dao_Impl;
import com.mgnrega.Dao.Gpm_Dao;
import com.mgnrega.Dao.Gpm_Dao_Impl;
import com.mgnrega.Dto.Gpm_Dto;
import com.mgnrega.Dto.Gpm_Dto_impl;
import com.mgnrega.Dto.Worker_Dto;
import com.mgnrega.Dto.Worker_Dto_Impl;
import com.mgnrega.Dto.getWorkerProject_Dto;
import com.mgnrega.Dto.worker_project_Dto;
import com.mgnrega.Exception.NoRecordFoundException;
import com.mgnrega.Exception.SomethingWentWrongException;

public class Gpn_Ui {
	
//	add worker
	public static void AddWorker_Ui() throws SomethingWentWrongException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Worker's Adhar Number : ");
		String aadhar = sc.next();

		System.out.println("Enter Worker's Name : ");
		String name = sc.next();

		System.out.println("Enter Worker's DOB formate(yyyy-mm-dd) : ");
		LocalDate dob = LocalDate.parse(sc.next());

		System.out.println("Enter Worker's Gender : ");
		String gender = sc.next();

		System.out.println("Enter Panchayat Name : ");
		sc.nextLine();
		String pname = sc.nextLine();
		
		
		System.out.println("Enter GPM's Distric Name : ");
		String dname = sc.next();

		System.out.println("Enter GPM's State Name : ");
		String sname = sc.next();

		Worker_Dto gd = new Worker_Dto_Impl(aadhar, name, dob, gender, pname, dname, sname);
		Gpm_Dao bd = new Gpm_Dao_Impl();
		try {
			bd.AddWorkers(gd);
			System.out.println("Successfully add Gpm's Details");
		} catch (Exception e) {
//			throw new SomethingWentWrongException("Unable to Add Details..");
			System.out.println(e);
		}
		System.out.println();
	}

//	view Workers
	public static void All_Worker_Ui() throws SomethingWentWrongException, NoRecordFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Worker's Aadhar Number");
	    String adhar=sc.next();
	    
	    if (adhar.isEmpty()) {
	        System.out.println("Aadhar number cannot be empty!");
	        return;
	    }
		Gpm_Dao bd = new Gpm_Dao_Impl();
		
		try {
			  List<Worker_Dto> p = bd.ViewWorker(adhar);
		        p.forEach(s -> {
		            System.out.println(
		                    "<===========================================================================================================================================================>");
		            System.out.println("    Aadhar Number : " + s.getWaadar() + " |  Name : " + s.getWname() + " |  DOB : "
		                    + s.getWdob() + " |  Gender : " + s.getWgender() + " |  PANCHAYAT_NAME : " + s.getPname()
		                    + " |  Distric : " + s.getDistric() + " |  State : " + s.getState());
		            System.out.println(
		                    "<============================================================================================================================================================>");
		        });
		} catch (SomethingWentWrongException e) {
			System.out.println(e);
			throw new SomethingWentWrongException("Something Went Wrong!");
		}

	}

//	view name and  Worker days
	public static void getWorkerProject_Ui()throws SomethingWentWrongException, NoRecordFoundException{
		Gpm_Dao bd = new Gpm_Dao_Impl();
		try {
			List<getWorkerProject_Dto>p=bd.getWorkerProjects();
			p.forEach(s -> {
				System.out.println(
						"<=====================================================================>");
				System.out.println("  |  Worker Name : " + s.getName() + " | Total Days : " + s.getDays()+" | ");
				System.out.println(
						"<=====================================================================>");
			});
		} catch (SomethingWentWrongException e) {
			System.out.println(e);
			throw new SomethingWentWrongException("Something Went Wrong!");
		}
	}
	
//	view name and wages
	public static void getWorkerwages_Ui()throws SomethingWentWrongException, NoRecordFoundException{
		Gpm_Dao bd = new Gpm_Dao_Impl();
		try {
			List<getWorkerProject_Dto>p=bd.getWorkerProjects();
			p.forEach(s -> {
				System.out.println(
						"<=====================================================================>");
				System.out.println("  |  Worker Name : " + s.getName() + " | Total Days : " + s.getWages()+" | ");
				System.out.println(
						"<=====================================================================>");
			});
		} catch (SomethingWentWrongException e) {
			System.out.println(e);
			throw new SomethingWentWrongException("Something Went Wrong!");
		}
	}
	
}


















