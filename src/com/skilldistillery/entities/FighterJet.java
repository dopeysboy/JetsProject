package com.skilldistillery.entities;

public class FighterJet extends Jet implements PewPewPlane{

	public FighterJet(String model, double speed, double range, double price) {	
		super(model, speed, range, price);
	}

	public void fight() {
		System.out.println("BRRRRRRRRRRRRRRRT");
	}

	public void reload() {
		System.out.println("KA-CHK");
	}
}
