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
	
	public void addJet(Jet jet) {
		jets.add(jet);
	}
	
	public void removeJet(Jet jet) {
		jets.remove(jet);
	}
}
