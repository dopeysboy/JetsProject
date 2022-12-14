package com.skilldistillery.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.skilldistillery.entities.AirField;
import com.skilldistillery.entities.BoomPlane;
import com.skilldistillery.entities.Jet;
import com.skilldistillery.entities.MyFileReaderWriter;
import com.skilldistillery.entities.PeopleCarrier;
import com.skilldistillery.entities.PewPewPlane;
import com.skilldistillery.entities.ThingCarrier;

public class JetsApplication {

	private Scanner kb = new Scanner(System.in);
	private final String fileLocation = "Jets.txt";
	private RandomJetCreator rjc = new RandomJetCreator();
	private AirField jets = new AirField(MyFileReaderWriter.readJetFromFile(fileLocation));
	private boolean keepRunning = true;
	
	public static void main(String[] args) {
		JetsApplication ja = new JetsApplication();
		ja.run();
	}

	public void run() {
		while(keepRunning) {
			displayUserMenu();
			getUserInput();
		}
	}
	
	public void displayUserMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n------------Main Menu------------\n");
		sb.append("1. List fleet\n");
		sb.append("2. Fly all jets\n");
		sb.append("3. View fastest jet\n");
		sb.append("4. View jet with longest range\n");
		sb.append("5. Load all carriers\n");
		sb.append("6. War in the skies!\n");
		sb.append("7. Add a jet to Fleet\n");
		sb.append("8. Remove a jet from Fleet\n");
		sb.append("9. Load a random list of jets\n");
		sb.append("10. Save your jets\n");
		sb.append("11. Load your jets from an existing save\n");
		sb.append("12. Quit");
		
		System.out.println(sb.toString());
	}
	
	public void listFleet() {
		for(Jet j : jets.getJets()) {
			System.out.println(j);
		}
	}
	
	public void flyAll() {
		for(Jet j: jets.getJets()) {
			j.fly();
		}
	}
	
	public void viewFastest() {
		List<Jet> jetsList = jets.getJets(); 
		
		double fastest = jetsList.get(0).getSpeed();
		Jet fastestJet = jetsList.get(0);
		
		for(Jet j : jetsList) {
			if(j.getSpeed() > fastest) {
				fastest = j.getSpeed();
				fastestJet = j;
			}
		}
		
		System.out.println(fastestJet);
	}
	
	public void viewFarthest() {
		List<Jet> jetsList = jets.getJets();
		
		double farthest = jetsList.get(0).getRange();
		Jet farthestJet = jetsList.get(0);
		
		for(Jet j : jetsList) {
			if(j.getRange() > farthest) {
				farthest = j.getRange();
				farthestJet = j;
			}
		}
		
		System.out.println(farthestJet);
	}
	
	public void loadCargo() {
		for(Jet j: jets.getJets()) {
			if(j instanceof ThingCarrier) {
				((ThingCarrier) j).loadMeUp();
				((ThingCarrier) j).getItOut();
			} else if(j instanceof PeopleCarrier) {
				((PeopleCarrier) j).embarkPassengers();
				((PeopleCarrier) j).debarkPassengers();
			}
			
		}
	}
	
	public void war() {
		for(Jet j: jets.getJets()) {
			if(j instanceof PewPewPlane) {
				((PewPewPlane) j).fight();
				((PewPewPlane) j).reload();
				((PewPewPlane) j).fight();
			} else if(j instanceof BoomPlane) {
				((BoomPlane) j).bombTime();
			}
		}
	}
	
	public void addJet() {
		Jet newJet = null;
		boolean usrInputLoop = true;
		
		System.out.println("Whould you like to create a random jet?");
		
		while(usrInputLoop) {
			String usrInput = kb.nextLine();
				
			switch (usrInput.toUpperCase()) {
				case "YES":
				case "Y":
					System.out.println("Creating a random jet");
					newJet = rjc.createJet();
					usrInputLoop = false;
					break;
				case "NO":
				case "N":
					String[] jetRaw = new String[6];
					
					System.out.print("Please enter the type of jet (your options are BomberPlane, CargoPlane, CommercialJet, FighterJet, and JetImpl): ");
					jetRaw[0] = kb.nextLine();
					
					System.out.print("Please enter the model of your jet: ");
					jetRaw[1] = kb.nextLine();
					
					System.out.print("Please enter the speed of your jet: ");
					jetRaw[2] = kb.nextLine();
					
					System.out.print("Please enter the range of your jet: ");
					jetRaw[3] = kb.nextLine();
					
					System.out.print("Please enter the price of your jet: ");
					jetRaw[4] = kb.nextLine();
					
					System.out.print("Please enter your pilot's name, or random for a random name: ");
					jetRaw[5] = kb.nextLine();
					
					newJet = jets.createJet(jetRaw);
					usrInputLoop = false;
					break;
				default:
					System.err.println("Please input either y, yes, n, or no");
					break;
			}
		}
		jets.addJet(newJet);
	}
	
	public void removeJet() {
		List<Jet> jetsList = jets.getJets(); 
		
		StringBuilder sb = new StringBuilder();
		sb.append("Please enter which jet to delete: ");
		
		for(int i = 0; i < jets.getNumberOfJets(); i++) {
			sb.append("\n  (").append(i).append(") ");
			sb.append(jetsList.get(i).getModel());
		}
		
		sb.append("\n  Input anything else to Cancel");
		
		System.out.println(sb.toString());
		String usrInput = kb.nextLine();
		
		jets.removeJet(usrInput);
	}
	
	public void loadRandom() {
		try {
			System.out.println("How many random jets would you like to load?");
			String usrInput = kb.nextLine();
			
			List<Jet> randJets = new ArrayList<>(); 
			int numJets = Integer.parseInt(usrInput);
			
			System.out.println(numJets);
			for(int i = 0; i < numJets; i++) {
				System.out.println("Creating jet " + i);
				randJets.add(rjc.createJet());
			}
			
			AirField randomAirfield = new AirField(randJets);
			jets = randomAirfield;
			
		} catch (NumberFormatException e) {
			System.out.println("Please enter a whole number!");
		}
	}
	
	public void save() {
		System.out.println("What would you like to name your save file?");
		String fileName = kb.nextLine();
		
		if(fileName.toUpperCase().equals("JETS")) {
			System.err.println("You cannot name your file the same as the default file!");
		} else {
			MyFileReaderWriter.saveToFile(jets, fileName);
		}
	}
	
	public void load() {
		System.out.print("Please enter the name of the file you would like to load: ");
		String fileName = kb.nextLine();
		
		jets = new AirField(MyFileReaderWriter.readJetFromFile(fileName));
	}
	
	public void getUserInput() {
		String userInput = kb.nextLine();
		
		try {
			int usrChoice = Integer.parseInt(userInput);
			switch (usrChoice) {
				case 1:
					listFleet();
					break;
				case 2:
					flyAll();
					break;
				case 3:
					viewFastest();
					break;
				case 4:
					viewFarthest();
					break;
				case 5:
					loadCargo();
					break;
				case 6:
					war();
					break;
				case 7:
					addJet();
					break;
				case 8:
					removeJet();
					break;
				case 9:
					loadRandom();
					break;
				case 10:
					save();
					break;
				case 11:
					load();
					break;
				case 12:
					System.out.println("Goodbye!");
					keepRunning = false;
					break;
				default:
					System.err.println("Please enter a valid number 1-12");
					break;
			}
		} catch (Exception e) {
			System.err.println("Please enter a valid number 1-12");
		}
	}
}
