package com.mgnrega_Ui;

import java.util.Scanner;

import com.mgnrega.Exception.SomethingWentWrongException;

public class users_Login_Ui {

//	Bdo Login
	public static void BdoLogin() throws ClassNotFoundException, SomethingWentWrongException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Bdo User Name");
		String username = sc.next();
		System.out.println("Enter Bdo Password");
		String password = sc.next();

		if (username.equals("nisha@123") && password.equals("nisha@123")) {
			System.out.println("BDO Login Successfully");
			users_Login_Ui.bdo();
		}

		else {
			System.out.println("Username or Password is wrong, Try again...");
			users_Login_Ui.SelectUser();
		}
	}

//	Bdo Details
	public static void bdo() throws ClassNotFoundException, SomethingWentWrongException {

		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("1. Create a project\r\n" + "2. View List Of Project\r\n" + "3. Create New Gpm\r\n"
					+ "4. View all Gpm\r\n" + "5. Allocate a project to a GPM\r\n" + "6. Logout from BDO\r\n");
			System.err.println();

			choice = sc.nextInt();
			switch (choice) {
			case 1:
				Bdo_Ui.CreateProject_Ui();
				break;
			case 2:
				Bdo_Ui.AllProjects_Ui();
				break;
			case 3:
				// RegisterGpn();
				break;
			case 4:
				//
			case 5:
				//
				break;
			case 6:
				//
				break;
			case 0:
				//
				break;
			default:
				System.out.println("Invalid Input, try again");
				users_Login_Ui.bdo();
			}
		} while (choice != 0);
	}

//	 GPM Details
	public static void GpnLogin() {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("1. GPN Login\r\n" + "2. Resister Worker\r\n"
					+ "3. See List of Employee working on that Project on Name\\r\\n" + "4. View all Gpm\r\n"
					+"4. Logout from BDO\r\n");
			System.out.println();
			System.out.println("Choose an Option number");

			choice = sc.nextInt();
			switch (choice) {
			case 1:
				// createProject();
				break;
			case 2:
				// GetAllProject();
				break;
			case 3:
				// RegisterGpn();
				break;
			case 4:
				//
			case 5:
				//
				break;
			case 6:
				//
				break;
			case 0:
				//
				break;
			default:
				System.out.println("Invalid Input, try again");
				users_Login_Ui.GpnLogin();
			}
		} while (choice != 0);
	}

	public static void SelectUser() throws ClassNotFoundException, SomethingWentWrongException {
		Scanner sc = new Scanner(System.in);

		int choice = 0;
		do {
			System.out.println("Choose an Option....");
			System.out.println("1. BDO (Block Development Officer) Login");
			System.out.println("2. Gram Panchayet Member Login");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				BdoLogin();
				break;
			case 2:
				GpnLogin();
				break;
			default:
				System.out.println("Invalid Number, Choose a Valid Number!");
				System.err.println("Try Again...");
				users_Login_Ui.SelectUser();
			}

		} while (choice != 0);
	}
}
