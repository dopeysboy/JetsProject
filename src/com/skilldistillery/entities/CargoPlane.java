package com.skilldistillery.entities;

public class CargoPlane extends Jet implements ThingCarrier{
	public CargoPlane(String model, double speed, double range, double price) {
		super(model, speed, range, price);
	}

	public void loadMeUp() {
		System.out.println("I'M LOADING THINGS NOW");
		
	}

	public void getItOut() {
		System.out.println("GET ALL THIS CRAP OFF ME!");		
	}

}
