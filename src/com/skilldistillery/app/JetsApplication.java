package com.skilldistillery.app;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.entities.BoomPlane;
import com.skilldistillery.entities.CargoPlane;
import com.skilldistillery.entities.Jet;
import com.skilldistillery.entities.MyFileReader;
import com.skilldistillery.entities.PeopleCarrier;
import com.skilldistillery.entities.PewPewPlane;
import com.skilldistillery.entities.ThingCarrier;

public class JetsApplication {

	private Scanner kb = new Scanner(System.in);
	private final String fileLocation = "Jets.txt";
	public List<Jet> jets = new LinkedList<>();
	boolean keepRunning = true;
	
	public static void main(String[] args) {
		JetsApplication ja = new JetsApplication();
		ja.run();
	}

	public void run() {
		MyFileReader mfr = new MyFileReader();
		mfr.readJetFromFile(jets, fileLocation);
		
		while(keepRunning) {
			displayUserMenu();
			getUserInput();
		}
	}
	
	public void displayUserMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("------------Main Menu------------\n");
		sb.append("1. List fleet\n");
		sb.append("2. Fly all jets\n");
		sb.append("3. View fastest jet\n");
		sb.append("4. View jet with longest range\n");
		sb.append("5. Load all Cargo Jets\n");
		sb.append("6. War in the skies!\n");
		sb.append("7. Add a jet to Fleet\n");
		sb.append("8. Remove a jet from Fleet\n");
		sb.append("9. Quit");
		
		System.out.println(sb.toString());
	}
	
	public void listFleet() {
		for(Jet j : jets) {
			System.out.println(j);
		}
		System.out.println();
	}
	
	public void flyAll() {
		for(Jet j: jets) {
			j.fly();
		}
	}
	
	public void viewFastest() {
		
	}
	
	public void viewFarthest() {
		
	}
	
	public void loadCargo() {
		for(Jet j: jets) {
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
		for(Jet j: jets) {
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
		
	}
	
	public void removeJet() {
		
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
					System.out.println("Goodbye!");
					keepRunning = false;
					break;
				default:
					System.err.println("Please enter a valid number 1-9");
					break;
			}
		} catch (Exception e) {
			System.err.println("Please enter a valid number 1-9");
		}
	}
}
