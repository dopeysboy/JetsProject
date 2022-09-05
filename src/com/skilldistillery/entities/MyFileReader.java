package com.skilldistillery.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class MyFileReader {
	
	public void readJetFromFile(List<Jet> outputList, String file) {
		try(BufferedReader bufIn = new BufferedReader(new FileReader(file))){
			String line;
			while((line = bufIn.readLine()) != null) {
				String[] jetStrings = line.split(",");
				
				outputList.add(makeJetGivenStringArray(jetStrings));
			}
		} catch(IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Jet makeJetGivenStringArray(String[] rawJet) throws Exception {
		String model = rawJet[1];
		double speed = Double.parseDouble(rawJet[2]);
		double range = Double.parseDouble(rawJet[3]);
		double price = Double.parseDouble(rawJet[4]);
	
		switch(rawJet[0]) {
			case "FighterJet":
				return new FighterJet(model, speed, range, price);
			case "BomberPlane":
				return new BomberPlane(model, speed, range, price);
			case "CargoPlane":
				return new CargoPlane(model, speed, range, price);
			case "CommercialJet":
				return new CommercialJet(model, speed, range, price);
			case "JetImpl":
				return new JetImpl(model, speed, range, price);
			default:
				throw new Exception("You did not provide a valid jet type");
		}
	}
}
