package com.mgnrega_Ui;

import java.util.Scanner;

import com.mgnrega.Exception.NoRecordFoundException;
import com.mgnrega.Exception.SomethingWentWrongException;
import com.mgnrega.custom.Console_Color;


public class Main_Ui {

//main
	public static void main(String[] args) throws ClassNotFoundException, SomethingWentWrongException, NoRecordFoundException {
		System.out.println (Console_Color.GREEN_BOLD_BRIGHT+ "-------------------------------------------------------------");
		System.out.println("<==========  Welcome To MGNREGA Mini Project ================>");
		System.out.println("-------------------------------------------------------------"+Console_Color.RESET);
		System.out.println();
   users_Login_Ui.SelectUser();
	}
}


