package com.skilldistillery.entities;

public class FighterJet extends Jet implements PewPewPlane{

	public FighterJet(String model, double speed, double range, double price) {	
		super(model, speed, range, price);
	}
	
	public FighterJet(String model, double speed, double range, double price, String pilotName) {
		super(model, speed, range, price, pilotName);
	}
	
	public void fight() {
		System.out.println(this.model + ": BRRRRRRRRRRRRRRRT");
	}

	public void reload() {
		System.out.println(this.model + ": KA-CHK");
	}
}
