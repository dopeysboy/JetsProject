package com.skilldistillery.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is a library class that holds functions for reading and writing that has been molded to specific use
 * for this application. It includes a todo next to a method, because I am unwilling to adjust my code to account for
 * a comment, as it would add excess complication to the code, rather than just a comment in the code 
 * @author tylertanner
 */

public class MyFileReaderWriter {
	
	public static List<Jet> readJetFromFile(String file) {
		List<Jet> outputList = new ArrayList<>(); 
		
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
		
		return outputList;
	}
	
	//TODO: add non-fighter jets to ModelNames.txt? Unsure if necessary
	public static ArrayList<String> readNamesFromFile(String file) {
		ArrayList<String> returnArrayList = new ArrayList<>();
		
		try (BufferedReader bufIn = new BufferedReader(new FileReader(file))){
			String line;
			
			while((line = bufIn.readLine()) != null) {
				if(!line.equals("|-")) {
					String[] lineArr = line.split("]]");
					String toAdd = lineArr[0].substring(3);
					
					returnArrayList.add(toAdd);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return returnArrayList;
	}

	public static ArrayList<String> readPilotNamesFromFile(String file) {
		ArrayList<String> returnArrayList = new ArrayList<>();
		
		try (BufferedReader bufIn = new BufferedReader(new FileReader(file))){
			String line;
			
			while((line = bufIn.readLine()) != null) {
				String[] lineArr = line.split(",");
				String toAdd = lineArr[1].substring(1, lineArr[1].length()-1);
				
				returnArrayList.add(toAdd);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return returnArrayList;
	}
	
	private static Jet makeJetGivenStringArray(String[] rawJet) throws Exception {
		String model = rawJet[1];
		double speed = Double.parseDouble(rawJet[2]);
		double range = Double.parseDouble(rawJet[3]);
		double price = Double.parseDouble(rawJet[4]);
	
		switch(rawJet[0].toUpperCase()) {
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
				throw new Exception("You did not provide a valid jet type");
		}
	}
}
