package com.mgnrega_Ui;

import java.util.Scanner;

import com.mgnrega.Dao.Bdo_Dao;
import com.mgnrega.Dao.Bdo_Dao_Impl;
import com.mgnrega.Dao.Gpm_Dao;
import com.mgnrega.Dao.Gpm_Dao_Impl;
import com.mgnrega.Dto.Users_Dto;
import com.mgnrega.Dto.Users_Dto_impl;
import com.mgnrega.Dto.gpm_project_Impl_Dto;
import com.mgnrega.Exception.NoRecordFoundException;
import com.mgnrega.Exception.SomethingWentWrongException;
import com.mgnrega.custom.Console_Color;

public class users_Login_Ui {

//	Bdo Login
	public static void BdoLogin() throws ClassNotFoundException, SomethingWentWrongException, NoRecordFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.print(Console_Color.LIGHT_BLUE+"Enter Bdo User Name : ");
		System.out.println();
		String username = sc.next();
		System.out.println("Enter Bdo Password : "+Console_Color.RESET);
		String password = sc.next();
		System.out.println();
		
		Users_Dto ud=new Users_Dto_impl(username,password,"BDO");
		Bdo_Dao bd = new Bdo_Dao_Impl();
		
		ud.setUsername(username);
		ud.setPassword(password);
		ud.setUsertype("BDO");
		try {
			bd.Login_Bdo(ud);
			System.out.println(Console_Color.LIGHT_GREEN+"***************BDO Login Successfully***************"+Console_Color.RESET);
			
			System.out.println();
			users_Login_Ui.bdo();
		
		} catch (Exception e) {
//			System.out.println(e);
			System.out.println("Username or Password is wrong, Try again...");
			System.out.println();
			users_Login_Ui.SelectUser();
		
		}
	}

//	Bdo Details
	public static void bdo() throws ClassNotFoundException, SomethingWentWrongException, NoRecordFoundException {

		Scanner sc = new Scanner(System.in);
		int choice = 0;
		try {
			do {
				System.out.println(Console_Color.GREEN+"1. Create a project\r\n" + "2. View List Of Project\r\n" + "3. Create New Gpm\r\n"
						+ "4. View all Gpm\r\n" + "5. Allocate a project to a GPM\r\n" + "6. Logout from BDO\r\n"+Console_Color.RESET);
				System.out.println();

				choice = sc.nextInt();
				switch (choice) {
				case 1:
					Bdo_Ui.CreateProject_Ui();
					break;
				case 2:
					Bdo_Ui.AllProjects_Ui();
					break;
				case 3:
					Bdo_Ui.AddGpm_Ui();
					break;
				case 4:
					Bdo_Ui.All_Gpm_Ui();
					break;
				case 5:
					Bdo_Ui.AllocateTheProject_Ui();
					break;
				case 6:
					System.out.println();
					SelectUser();
					System.out.println();
					break;
				default:
					System.out.println(Console_Color.ORANGE+"Invalid Input, try again");
					users_Login_Ui.bdo();
				}
			} while (choice != 0);
		} catch (Exception e) {
//			System.out.println(e);
			System.out.println("Enter a Number From Above Option"+Console_Color.RESET);

		}
	}

//	Gpm Login
	public static void gpm() throws ClassNotFoundException, SomethingWentWrongException, NoRecordFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter GPM User Name");
		String username = sc.next();
		System.out.println("Enter Your Password");
		String password = sc.next();
		
		Users_Dto ud=new Users_Dto_impl();
		Gpm_Dao bd = new Gpm_Dao_Impl();
		
		ud.setPassword(password);
		ud.setPassword(password);
		ud.setUsertype("GPM");
		try {
			bd.Login_Gpm(ud);
			System.out.println("***************GPM Login Successfully***************");
			System.out.println();
			users_Login_Ui.Gpn();
		
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Username or Password is wrong, Try again...");
			System.out.println();
			users_Login_Ui.SelectUser();
		
		}
	}
//	 GPM Details
	public static void Gpn() throws ClassNotFoundException, SomethingWentWrongException, NoRecordFoundException {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println(Console_Color.YELLOW+"1.Resister Worker Details \r\n" + "2. View Details of Worker\r\n"
					+ "3. View worker name & the total number of days a worker worked on a project\r\n" +
					"4. View worker name & total wages paid to him\r\n"
					+ "5. Logout from BDO\r\n"+Console_Color.RESET);
			System.out.println();
			System.out.println("Choose an Option number");
			System.out.println();

			choice = sc.nextInt();
			switch (choice) {
			case 1:
				Gpn_Ui.AddWorker_Ui();
				break;
			case 2:
				Gpn_Ui.All_Worker_Ui();
				break;
			case 3:
				Gpn_Ui.getWorkerProject_Ui(); //View worker name & the total number of days a worker worked on a project
				break;
			case 4:
				Gpn_Ui.getWorkerwages_Ui(); //View worker name & total wages paid to him.
				
				break;
			
			case 5:
				System.out.println(Console_Color.GREEN_BRIGHT+"**************You have Successfully Logout************"+Console_Color.RESET);
				SelectUser();
				break;
			default:
				System.out.println();
				System.out.println(Console_Color.FOREST_GREEN+"Invalid Input, try again"+Console_Color.RESET);
				users_Login_Ui.Gpn();
				System.out.println();
			}
		} while (choice != 0);
	}

	//select bdo | Gpm  
	public static void SelectUser() throws ClassNotFoundException, SomethingWentWrongException, NoRecordFoundException {
		Scanner sc = new Scanner(System.in);

		int choice = 0;
		try {
			do {
				
				System.out.println(Console_Color.YELLOW+"1.BDO (Block Development Officer) Login");
				System.out.println("2. Gram Panchayet Member Login");
				System.out.println("3. Logout From This Page");
				System.out.println("Choose an Option : "+Console_Color.RESET);
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					BdoLogin();
					break;
				case 2:
					gpm();
					break;
				case 3:
					System.out.println();
					System.out.println(Console_Color.GREEN+"Thanks For Using Our Services....Keep Visiting"+Console_Color.RESET);
					System.out.println();
					break;
					
				default:
					System.out.println();
					System.out.println(Console_Color.ORANGE+"Invalid Number, Choose a Valid Number!");
					System.err.println("Try Again..."+Console_Color.RESET);
					System.out.println();
					users_Login_Ui.SelectUser();
				}

			} while (choice != 0);
		} catch (Exception e) {
//			System.out.println(e);
			System.out.println();
			System.out.println("Enter a valid Number");
			System.out.println();
		}
	}
}
