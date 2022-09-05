package com.skilldistillery.entities;

import java.util.List;

public class AirField {
	private List<Jet> jets; 
	
	public AirField() {}
	
	public AirField(List<Jet> jets) {
		this.jets = jets;
	}
	
	public List<Jet>getJets(){ 
		return jets;
	}
	
	public int getNumberOfJets() {
		return jets.size();
	}
	
	public void addJet(Jet jet) {
		if(jet != null) {
			jets.add(jet);
		}
	}
	
	public void removeJet(String usrInput) {
		//if the input was a number this block executes
		try {
			int usrInputNum = Integer.parseInt(usrInput);
			
			if(usrInputNum < 0 || usrInputNum > jets.size()) {
				System.out.println("Quitting");
			} else {
				jets.remove(usrInputNum);
			}
			
		//if the input was not a number
		} catch (Exception e) {
			Jet removeJet = getJetByModelName(usrInput);
			
			if(removeJet != null) {
				jets.remove(removeJet);
			} else {
				System.out.println("Quitting");
			}
		}
	}
	
	public Jet getJetByModelName(String model) {
		for(Jet j : jets) {
			if(model.toUpperCase().equals(j.getModel())) {
				return j;
			}
		}
		
		return null;
	}
	
	public Jet createJet(String[] jetRaw) {
		
		try {
			String jetType = jetRaw[0].toUpperCase();
			
			String make = jetRaw[1].toUpperCase();
			double speed = Double.parseDouble(jetRaw[2]);
			double range = Double.parseDouble(jetRaw[3]);
			double price = Double.parseDouble(jetRaw[4]);
			
			switch (jetType) {
				case "BOMBERPLANE":
				case "BOMBER PLANE":
					return new BomberPlane(make, speed, range, price);
				case "CARGOPLANE":
				case "CARGO PLANE":
					return new CargoPlane(make, speed, range, price);
				case "COMMERCIALJET":
				case "COMMERCIAL JET":
					return new CommercialJet(make, speed, range, price);
				case "FIGHTERJET":
				case "FIGHTER JET":
					return new FighterJet(make, speed, range, price);
				case "JETIMPL":
				case "JET IMPL":
					return new JetImpl(make, speed, range, price);
				default:
					System.err.println("You did not enter a valid jet type");
					break;
			}
		} catch (NumberFormatException e) {
			System.err.println("You did not enter a valid number for one of your fields");
		}
		
		return null;
	}
}
