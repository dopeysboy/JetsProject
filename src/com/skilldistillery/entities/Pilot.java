package com.skilldistillery.entities;

import java.util.ArrayList;

public class Pilot {
	private ArrayList<String> nameList = MyFileReaderWriter.readPilotNamesFromFile("PilotNames.txt"); 
	private String name;
	
	public Pilot() {
		int randName = (int)(Math.random() * nameList.size());
		this.name = nameList.get(randName);
	}

	public Pilot(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pilot [name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}
	
	
}
