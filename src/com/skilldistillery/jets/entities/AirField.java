package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirField {
	private List<Jet> jetsInArsenal = initiateJetListFromFile();

	public AirField() {

	}

	public List<Jet> initiateJetListFromFile() {
		List<Jet> jetsFromFile = new ArrayList<>();
		try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] splitLine = line.split(",");
				String model = splitLine[1];
				double speed = Double.parseDouble(splitLine[2]);
				int range = Integer.parseInt(splitLine[3]);
				long price = Long.parseLong(splitLine[4]);
				if (splitLine[0].equals("Fighter")) {
					FighterJet jet = new FighterJet(model, speed, range, price);
					jetsFromFile.add(jet);
				} else if (splitLine[0].equals("Cargo")) {
					CargoPlane jet = new CargoPlane(model, speed, range, price);
					jetsFromFile.add(jet);
				} else if (splitLine[0].equals("Jet")) {
					JetImpl jet = new JetImpl(model, speed, range, price);
					jetsFromFile.add(jet);
				}
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		return jetsFromFile;
	}

	public void showAllJetsInFleet() {
		for (Jet jet : jetsInArsenal) {
			System.out.println(jet);
		}
	}

	public void showJetDetailsAndRange() {
		for (Jet jet : jetsInArsenal) {
			double flyTime = jet.getRange() / jet.getSpeed();
			System.out.println(jet);
			System.out.println("This jet can fly for " + flyTime + " hours \n");
		}
	}

	public Jet getFastestJet() {
		Jet fastestJet = null;
		double fastestSpeed = 0;
		for (Jet jet : jetsInArsenal) {
			if (jet.getSpeed() > fastestSpeed) {
				fastestJet = jet;
				fastestSpeed = jet.getSpeed();
			}
		}
		System.out.println("The fastest jet in the fleet is: " + fastestJet + "\n");
		return fastestJet;
	}

	public Jet getLongestRangeJet() {
		Jet longestRangeJet = null;
		int longestRange = 0;
		for (Jet jet : jetsInArsenal) {
			if (jet.getRange() > longestRange) {
				longestRangeJet = jet;
				longestRange = jet.getRange();
			}
		}
		System.out.println("The jet with the longest range is: " + longestRangeJet + "\n");
		return longestRangeJet;
	}

	public void loadCargo() {
		for (Jet jet : jetsInArsenal) {
			if (jet instanceof CargoCarrier) {
				System.out.println(jet);
				((CargoCarrier) jet).loadCargo();
			}
		}
	}

	public void fight() {
		for (Jet jet : jetsInArsenal) {
			if (jet instanceof CombatReady) {
				System.out.println(jet);
				((CombatReady) jet).fight();
			}
		}
	}

	public void addJetToFleet(Scanner scanner) {
		System.out.println("What is the model of jet? ");
		String model = scanner.next();
		System.out.println("How fast is the jet? ");
		double speed = scanner.nextDouble();
		System.out.println("What is the range of the jet? ");
		int range = scanner.nextInt();
		System.out.println("What is the price of the jet? ");
		long price = scanner.nextLong();

		Jet jet = new JetImpl(model, speed, range, price);

		jetsInArsenal.add(jet);
	}
	
	public void removeJetFromFleet(Scanner scanner) {
		int index = 0;
		if (!jetsInArsenal.isEmpty()) {
			System.out.println("Select a jet to delete: ");
			for (Jet jet : jetsInArsenal) {
				System.out.print(index+1 + ".) ");
				System.out.println(jet);
				index++;
			}
			
			int indexToDelete = scanner.nextInt() - 1;
			jetsInArsenal.remove(indexToDelete);
			
			System.out.println();
		}
	}

}
