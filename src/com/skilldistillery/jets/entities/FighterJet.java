package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady{

	@Override
	public void fight() {
		System.out.println("Ready to fight!");
	}

}
