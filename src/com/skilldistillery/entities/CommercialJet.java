package com.skilldistillery.entities;

import java.util.Objects;

public class CommercialJet extends Jet implements PeopleCarrier{
	private int paxCap;
	
	public CommercialJet(String model, double speed, double range, double price) {
		super(model, speed, range, price);
	}
	
	public CommercialJet(String model, double speed, double range, double price, int paxCap){
		super(model, speed, range, price);
		this.paxCap = paxCap;
	}

	public int getPaxCap() {
		return this.paxCap;
	}
	
	public void setPaxCap(int paxCap) {
		this.paxCap = paxCap;
	}
	
	public void embarkPassengers() {
		System.out.println("All aboard the " + this.model + "!");
	}

	public void debarkPassengers() {
		System.out.println("Get off the " + this.model + " RIGHT NOW!");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(paxCap);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommercialJet other = (CommercialJet) obj;
		return Objects.equals(model, other.model)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Double.doubleToLongBits(range) == Double.doubleToLongBits(other.range)
				&& this.paxCap == other.paxCap;
	}
	
	
}
