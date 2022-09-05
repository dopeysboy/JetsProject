package com.skilldistillery.entities;

public class JetImpl extends Jet{

	public JetImpl(String model, double speed, double range, double price) {
		super(model, speed, range, price);
	}
	
	public JetImpl(String model, double speed, double range, double price, String pilotName) {
		super(model, speed, range, price, pilotName);
	}
}
