package com.skilldistillery.jets;

import java.io.*;

import java.util.*;


public class MenuNavigation extends Station{

	
	public List<StarShip> readStarShips(String fileName) {

		List<StarShip> dockedShips = new ArrayList<>();

		try (BufferedReader readFile = new BufferedReader(new FileReader(fileName))) {
			String newLine;

			while ((newLine = readFile.readLine()) != null) {
				String[] shipRecord = newLine.split(", ");

				String vesselName = shipRecord[0];
				String model = shipRecord[1];
				double speed = Double.parseDouble(shipRecord[2]);
				double price = Double.parseDouble(shipRecord[3]);
				double fuelCapacity = Double.parseDouble(shipRecord[4]);
				int crewSize = Integer.parseInt(shipRecord[5]);
				String isWarship = shipRecord[6];

				if (isWarship.equalsIgnoreCase("true")) {
					boolean weaponSysActive = true;
					int totalTorpedos = Integer.parseInt(shipRecord[7]);
					int pointDefense = Integer.parseInt(shipRecord[8]);
					StarShip newShip = new WarShip(vesselName, model, speed, price, fuelCapacity, crewSize,
							weaponSysActive, totalTorpedos, pointDefense);
					dockedShips.add(newShip);
				} else if (isWarship.equalsIgnoreCase("false")) {
					boolean suppliesLoaded = true;
					int totalTonsSupplies = Integer.parseInt(shipRecord[7]);
					StarShip newShip = new TransportShip(vesselName, model, speed, price, fuelCapacity, crewSize,
							totalTonsSupplies, suppliesLoaded);
					dockedShips.add(newShip);

				} else if(isWarship.equalsIgnoreCase("na")){
					StarShip newShip = new StandardShip(vesselName, model, speed, price, fuelCapacity, crewSize);
					dockedShips.add(newShip);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println(e);
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println(e);
		}

		return dockedShips;
	}
	
public String getFileName(Scanner in)  {
		
		String fileName = null, choice = null;
		choiceValid = false;
		
		System.out.println("|================================|");
		System.out.println("|*  If you would like to load   *|");
		System.out.println("|* a new ship roster enter 'y' .*|");
		System.out.println("|*  Otherwise a default package *|");
		System.out.println("|*        will be loaded.       *|");
		System.out.println("|================================|");
		
		while(choiceValid != true) {
		try {
			System.out.println("");
			choice = in.nextLine();
			if(choice.equalsIgnoreCase("y")) {
				System.out.println("\n|================================|");
				System.out.println("|     Enter your file choice     |");
				System.out.println("|     in the following format    |");
				System.out.println("|     ex. 'shipRoster.txt'       |");
				fileName = in.nextLine();
				choiceValid = true;
			}
			else if(choice.equalsIgnoreCase("n")) {
				System.out.println("\n|================================|");
				System.out.println("|    You have elected to load      |");
				System.out.println("|    the default ship package.     |");
				fileName = "shipRoster.txt";
				choiceValid = true;
			}
			else {
				System.out.println(" " + choice + "  is not Valid entry");
				System.out.println(" Please try another entry. ");
				waitForMillis(100);
				blankSpaceReset();
			}
		} catch (InputMismatchException e) {
			e.printStackTrace();
			System.err.println(e);
		}
		}
		for (int i = 0; i < 12; i++) {
			System.out.print("*  ");
			waitForMillis(200);
		}
		System.out.println("Thank you " + getUserName() + ", the file you have ");
		System.out.println(" selected to use is as follows : " + fileName);
		blankSpaceReset();
		return fileName;
	}

public void saveStarShips(String outputFileName, ArrayList<StarShip> dockedShips) {

}

public int ensureEntryInt(Scanner in) {
	int entry = 0;
	choiceValid = false;
	while(choiceValid != true) {
	try {
		entry = in.nextInt();
		choiceValid = true;

	} catch (InputMismatchException e) {
		System.err.println("|********************************|");
		System.err.println("| That is not a valid selection  |");
		System.err.println("|    Input your selection again  |");
		System.err.println("|********************************|");
	}
}
	return entry;
}

public void starShipStat(Scanner in) {
	System.out.println("|================================|");
	System.out.println("|*         Port Status          *|");
	System.out.println("|================================|");
}

public void displayBest() {
	System.out.println("|================================|");
	System.out.println("|*      Top Rated Starships     *|");
	System.out.println("|================================|");
}

public void transportShips(Scanner in) {
	System.out.println("|================================|");
	System.out.println("|*       Transport Ships        *|");
	System.out.println("|================================|");
}

public void warShips(Scanner in) {
	System.out.println("|================================|");
	System.out.println("|*        Defense Fleet         *|");
	System.out.println("|================================|");
}

public void shipMgmt(Scanner in) {
	System.out.println("|================================|");
	System.out.println("|*      Docking Management      *|");
	System.out.println("|================================|");
}

public String startMessage(Scanner in) {
	String name = null;

	System.out.println("|================================|");
	System.out.println("|*           Welcome            *|");
	System.out.println("|================================|");
	for (int i = 0; i < 12; i++) {
		System.out.print("*  ");
		waitForMillis(200);
	}
	System.out.println("\n|   Please enter your username:  |");
	try {
		System.out.println("");

		name = in.nextLine();
	} catch (InputMismatchException e) {

	}
	return name;
}

public void menuPrintOut() {
	System.out.println("|================================|");
	System.out.println("|*         Main Terminal        *|");
	System.out.println("|================================|");
	System.out.println("|1. Port Status                  |");
	System.out.println("|2. Top Rated StarShips          |");
	System.out.println("|3. Transport Ship Bay           |");
	System.out.println("|4. Defense Fleet Pre-Launch Bay |");
	System.out.println("|5. StarShip Docking Management  |");
	System.out.println("|================================|");
	System.out.println("|6. Exit Terminal                |");

}
	
	
}
