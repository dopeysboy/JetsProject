package com.skilldistillery.entities;

public class BomberPlane extends Jet implements BoomPlane{
	public BomberPlane(String model, double speed, double range, double price) {
		super(model, speed, range, price);
	}
	
	public void bombTime() {
		System.out.println(this.model + ": *bomb dropping noises*\n*BOOM*");
	}
}
