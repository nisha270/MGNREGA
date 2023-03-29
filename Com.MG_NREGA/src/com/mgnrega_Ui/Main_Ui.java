package com.mgnrega_Ui;

import java.util.Scanner;

public class Main_Ui {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int choice = 0;
		do {
			System.out.println("0. Thanks for Visite....");
			System.out.println("1. BDO (Block Development Officer) Login");
			System.out.println("2. Gram Panchayet Member Login");

			choice = sc.nextInt();

			switch (choice) {
			case 1:
				//
				break;
			case 2:
				//
				break;
			default:
				System.out.println("Invalid Number, Choose a Valid Number!");
			}

		} while (choice != 0);

	}
}
