package com.skilldistillery.app;

public class JetsApplication {

	public static void main(String[] args) {
		JetsApplication ja = new JetsApplication();
		ja.run();
	}

	public void run() {
		displayUserMenu();
	}

	public void readFromFile() {
		
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
		
	}
	
	public void flyAll() {
		
	}
	
	public void viewFastest() {
		
	}
	
	public void viewFarthest() {
		
	}
	
	public void loadCargo() {
		
	}
	
	public void war() {
		
	}
	
	public void addJet() {
		
	}
	
	public void removeJet() {
		
	}
}
