package com.skilldistillery.app;

import java.util.ArrayList;

import com.skilldistillery.entities.BomberPlane;
import com.skilldistillery.entities.CargoPlane;
import com.skilldistillery.entities.CommercialJet;
import com.skilldistillery.entities.FighterJet;
import com.skilldistillery.entities.Jet;
import com.skilldistillery.entities.JetImpl;
import com.skilldistillery.entities.MyFileReaderWriter;

public class RandomJetCreator {
	private final String[] jetTypes = {"BomberPlane", "CargoPlane", "CommercialJet", "FighterJet", "JetImpl"};
	private final ArrayList<String> modelNames = MyFileReaderWriter.readNamesFromFile("ModelNames.txt"); 
	
	public Jet createJet() {
		String jetType = jetTypes[(int) (Math.random() * 5)];
		
		int randModel = (int)(Math.random() * modelNames.size());
		
		String model = modelNames.get(randModel).toUpperCase();
		double speed = Math.random() * 1000;
		double range = Math.random() * 1000;
		double price = Math.random() * 100000000;
		
		switch (jetType.toUpperCase()) {
			case "BOMBERPLANE":
				return new BomberPlane(model, speed, range, price);
			case "CARGOPLANE":
				return new CargoPlane(model, speed, range, price);
			case "COMMERCIALJET":
				return new CommercialJet(model, speed, range, price);
			case "FIGHTERJET":
				return new FighterJet(model, speed, range, price);
			case "JETIMPL":
				return new JetImpl(model, speed, range, price);
			default:
				return null;
		}
	}
}
