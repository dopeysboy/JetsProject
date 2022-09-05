package com.skilldistillery.entities;

import java.util.Objects;

public abstract class Jet {
	protected String model;
	protected double speed;
	protected double range;
	protected double price;
	public static final double machConv = 0.001303;
	protected Pilot pilot;
	
	public Jet(String model, double speed, double range, double price) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
		this.pilot = new Pilot();
	}
	
	public Jet(String model, double speed, double range, double price, String pilotName) {
		this(model, speed, range, price);
		this.pilot = new Pilot(pilotName);
	}
	
	public void fly() {
		System.out.println(this + " can fly for " + range/speed + " more hours.");
	}

	public double getSpeedInMach() {
		return speed * machConv;
	}
	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public double getSpeed() {
		return speed;
	}


	public void setSpeed(double speed) {
		this.speed = speed;
	}


	public double getRange() {
		return range;
	}


	public void setRange(double range) {
		this.range = range;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(model, price, range, speed);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getClass().getSimpleName());
		builder.append(" [model=");
		builder.append(model);
		builder.append(", speed=");
		builder.append(speed);
		builder.append(", range=");
		builder.append(range);
		builder.append(", price=");
		builder.append(price);
		builder.append(", Pilot=");
		builder.append(pilot);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jet other = (Jet) obj;
		return Objects.equals(model, other.model)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Double.doubleToLongBits(range) == Double.doubleToLongBits(other.range)
				&& Double.doubleToLongBits(speed) == Double.doubleToLongBits(other.speed);
	}
	
	
}
