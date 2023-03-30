package com.mgnrega_Ui;

import java.util.Scanner;

import com.mgnrega.Exception.SomethingWentWrongException;

public class Main_Ui {

//	step-1
	public static void main(String[] args) throws ClassNotFoundException, SomethingWentWrongException {
		System.out.println("-------------------------------------------------------------");
		System.out.println("<==========  Welcome To MGNREGA Mini Project ================>");
		System.out.println("-------------------------------------------------------------");
		System.out.println();
		
		users_Login_Ui.SelectUser();;

	}
}
