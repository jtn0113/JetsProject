package com.skilldistillery.jets.entities;

public class CargoPlane extends Jet implements CargoCarrier{

	@Override
	public void loadCargo() {
		System.out.println("Cargo is loaded");
	}

}
