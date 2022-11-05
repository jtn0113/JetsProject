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

	public void launch(Scanner scanner) {
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
		while (keepGoing) {
			switch (showMenu(scanner)) {
			case "1":
				af.showAllJetsInFleet();
				break;
			case "2":
				af.showJetDetailsAndRange();
				break;
			case "3":
				af.getFastestJet();
				break;
			case "4":
				af.getLongestRangeJet();
				break;
			case "5":
				af.loadCargo();
				break;
			case "6":
				af.fight();
				break;
			case "7":
				af.addJetToFleet(scanner);
				break;
			case "8":
				break;
			case "9":
				keepGoing = false;
				System.out.println("Dilly Dilly!");
				break;
			default:
				break;
			}
		}
	}

}
