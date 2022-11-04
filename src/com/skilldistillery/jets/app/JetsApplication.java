package com.skilldistillery.jets.app;

import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;

public class JetsApplication {
	private Scanner scanner;
	private AirField airField;
	
	public static void main(String[] args) {
		JetsApplication ja = new JetsApplication();
		ja.scanner = new Scanner(System.in).useDelimiter("\n");
		ja.airField = new AirField();
		ja.launch(ja.scanner);

	}

	private void launch(Scanner scanner) {
		menuResponseAction(scanner, airField);
	}
	
	public String showMenu(Scanner scanner) {
		System.out.println("1.) List fleet");
		System.out.println("2.) Fly all jets");
		System.out.println("3.) View fastest jet");
		System.out.println("4.) View jet with longest range");
		System.out.println("5.) Load all Cargo Jets");
		System.out.println("6.) Dogfight!");
		System.out.println("7.) Add a jet to Fleet");
		System.out.println("8.) Remove a jet from Fleet");
		System.out.println("9.) Quit");
		
		return scanner.next();
	}
	
	public void menuResponseAction(Scanner scanner, AirField af) {
		boolean keepGoing = true;
		while(keepGoing) {
			switch(showMenu(scanner)) {
			case "1":
				break;
			case "2":
				break;
			case "3":
				break;
			case "4":
				break;
			case "5":
				break;
			case "6":
				break;
			case "7":
				break;
			case "8":
				break;
			case "9":
				break;
			case "10":
				keepGoing = false;
				System.out.println("Dilly Dilly!");
				break;
			default:
				break;
			}
		}
	}

}
