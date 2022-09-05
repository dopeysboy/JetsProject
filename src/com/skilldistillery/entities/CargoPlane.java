package com.skilldistillery.entities;

public class CargoPlane extends Jet implements ThingCarrier{
	public CargoPlane(String model, double speed, double range, double price) {
		super(model, speed, range, price);
	}

	public CargoPlane(String model, double speed, double range, double price, String pilotName) {
		super(model, speed, range, price, pilotName);
	}

	public void loadMeUp() {
		System.out.println(this.model + " LOADING THINGS NOW");
		
	}

	public void getItOut() {
		System.out.println(this.model + ": GET ALL THIS CRAP OFF ME!");		
	}

}
