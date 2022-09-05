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
		jets.add(jet);
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
}
