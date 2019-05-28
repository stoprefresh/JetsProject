package com.skilldistillery.jets;

import java.io.*;
import java.util.*;

public class SpaceStation {

	private String userName;

	private boolean gameRun, choiceValid;

	public SpaceStation() {

	}

	public void userMenu(Scanner in) {

		int selection = 0;
		gameRun = true;
		setUserName(startMessage(in));

		List<StarShip> starship = readStarShips(getFileName(in));

		while (gameRun == true) {

			menuPrintOut();

			selection = ensureEntryInt(in);

			switch (selection) {

			case 1:
				loading();
				portStatus(starship, in);
				break;

			case 2:
				loading();
				
				break;

			case 3:
				loading();
				break;

			case 4:
				loading();
				break;
			case 5:
				gameRun = false;
				loading();
				System.out.println("\n|================================|");
				System.out.println("|*       Exiting Terminal       *|");
				System.out.println("|================================|");
				break;
			default: {
				System.out.println(" " + selection + " is not an available option.");
				System.out.println(" Returning to top menu ");
				waitForMillis(100);

			}
			}
		}
	}
	
	public void transportBay(List<StarShip> starship, Scanner in) {
		boolean menuOption = false;
		
		while(menuOption != true) {
			System.out.println("\n\n|================================|");
			System.out.println("|*         Port Status          *|");
			System.out.println("|================================|");
			System.out.println("|1. Display Docked Ships         |");
			System.out.println("|2. Detailed Ship Information    |");
			System.out.println("|3. Top Rated StarShips          |");
			System.out.println("|================================|");
			System.out.println("|4. Return to Main Menu          |");
			int selection = in.nextInt();
			
			
		}
		
		
	}

	public void portStatus(List<StarShip> starship, Scanner in) {
		boolean menuOption = false;
		double fastest = 0.0, highestRange = 0.0;
		String f = null, r = null;
		
		while (menuOption != true) {
			System.out.println("\n\n|================================|");
			System.out.println("|*         Port Status          *|");
			System.out.println("|================================|");
			System.out.println("|1. Display Docked Ships         |");
			System.out.println("|2. Detailed Ship Information    |");
			System.out.println("|3. Top Rated StarShips          |");
			System.out.println("|================================|");
			System.out.println("|4. Return to Main Menu          |");
			int selection = in.nextInt();

			switch (selection) {

			case 1:
				for (StarShip a : starship) {
					System.out.println("Vessel [" + a.getVesselName() + "]"
					+ " : Model [" + a.getModel() + "] : Type [" 
							+ a.getClass().getSimpleName() + "] : Crew Size [" 
					+ a.getCrewSize() + "]\n\n");
				}
				waitForMillis(150);
				break;
			case 2:
				for(StarShip a : starship) {
					System.out.println("Vessel [" + a.getVesselName() + "]"
							+ " : Model [" + a.getModel() + "] : Type [" 
									+ a.getClass().getSimpleName() + "]");
					System.out.print("Speed [ " + a.getSpeed() + "-km/s]"	
							+ " : [" + a.getRange() + " (hrs)-Continuous Burn] : Price [" 
							+ a.getPrice() + "]\n\n");
				}
				waitForMillis(150);
				break;
			case 3:
				for (StarShip a : starship) {
					if(a.getSpeed() > fastest) {
						fastest = a.getSpeed();
						f = a.getVesselName();
					}
					if(a.getRange() > highestRange) {
						highestRange = a.getRange();
						r = a.getVesselName();
					}
				}
				System.out.println("Top performers currently on station.");
				System.out.println("Fastest:" + f + " at " + fastest + "-km/s");
				System.out.println("Longest Running: " + r + " at " + highestRange
						+ " (hrs)-Continuous Burn");
				break;
			case 4:
				menuOption = true;
				waitForMillis(150);
				break;
			default:
				System.out.println(" " + selection + " is not an available option.");
				System.out.println(" Returning to top menu ");
				waitForMillis(100);
			}
		}
	}

	private void loading() {
		for (int i = 0; i < 12; i++) {
			System.out.print("*  ");
			waitForMillis(60);
		}
	}
	
	public int ensureEntryInt(Scanner in) {
		int entry = 0;

		try {
			entry = in.nextInt();

		} catch (InputMismatchException e) {
			System.err.println("|********************************|");
			System.err.println("| That is not a valid selection  |");
			System.err.println("|    Input your selection again  |");
			System.err.println("|********************************|");
		}

		return entry;
	}

	private List<StarShip> readStarShips(String fileName) {

		List<StarShip> ships = new ArrayList<>();

		try (BufferedReader readFile = new BufferedReader(new FileReader(fileName))) {

			String newLine;

			while ((newLine = readFile.readLine()) != null) {

				boolean weaponSysActive = false;
				boolean suppliesLoaded = false;

				String[] shipRecord = newLine.split(", ");

				String vesselName = shipRecord[0];

				String model = shipRecord[1];

				double speed = Double.parseDouble(shipRecord[2]);

				double price = Double.parseDouble(shipRecord[3]);

				double fuelCapacity = Double.parseDouble(shipRecord[4]);

				int crewSize = Integer.parseInt(shipRecord[5]);

				if (shipRecord[6].equalsIgnoreCase("true")) {
					weaponSysActive = true;
					int totalTorpedos = Integer.parseInt(shipRecord[8]);
					int pointDefense = Integer.parseInt(shipRecord[9]);
					StarShip w = new WarShip(vesselName, model, speed, price, fuelCapacity, crewSize, weaponSysActive,
							totalTorpedos, pointDefense);
					ships.add(w);
				} else if (shipRecord[7].equalsIgnoreCase("true")) {
					suppliesLoaded = true;
					int totalTonsSupplies = Integer.parseInt(shipRecord[8]);
					StarShip t = new TransportShip(vesselName, model, speed, price, fuelCapacity, crewSize,
							totalTonsSupplies, suppliesLoaded);
					ships.add(t);
				} else if (weaponSysActive == false && suppliesLoaded == false) {
					StarShip s = new StandardShip(vesselName, model, speed, price, fuelCapacity, crewSize);
					ships.add(s);
				}
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		return ships;
	}

	public void saveStarShips(String outputFileName, ArrayList<StarShip> dockedShips) {
  // TODO needs to be completed
	}

	private void menuPrintOut() {
		System.out.println("|================================|");
		System.out.println("|*         Main Terminal        *|");
		System.out.println("|================================|");
		System.out.println("|1. Port Status                  |");
		System.out.println("|2. Transport Ship Bay           |");
		System.out.println("|3. Defense Fleet Pre-Launch Bay |");
		System.out.println("|4. StarShip Docking Management  |");
		System.out.println("|================================|");
		System.out.println("|5. Exit Terminal                |");

	}

	private String startMessage(Scanner in) {
		String name = null;

		System.out.println("|================================|");
		System.out.println("|*           Welcome            *|");
		System.out.println("|================================|");
		for (int i = 0; i < 12; i++) {
			System.out.print("*  ");
			waitForMillis(60);
		}
		System.out.println("\n|   Please enter your username:  |");
		try {
			System.out.println("");

			name = in.nextLine();

		} catch (InputMismatchException e) {

		}
		return name;
	}

	public String getFileName(Scanner in) {

		String fileName = null, choice = null;
		setChoiceValid(false);

		System.out.println("|================================|");
		System.out.println("|*  If you would like to load   *|");
		System.out.println("|* a new ship roster enter 'y'  *|");
		System.out.println("|*    enter 'n' for a default   *|");
		System.out.println("|*         ship roster.         *|");
		System.out.println("|================================|");

		while (isChoiceValid() != true) {
			try {
				System.out.println("");
				choice = in.nextLine();
				if (choice.equalsIgnoreCase("y")) {
					System.out.println("\n|================================|");
					System.out.println("|     Enter your file choice     |");
					System.out.println("|     in the following format    |");
					System.out.println("|     ex. 'shipRoster.txt'       |");
					fileName = in.nextLine();
					setChoiceValid(true);
				} else if (choice.equalsIgnoreCase("n")) {
					System.out.println("\n|================================|");
					System.out.println("|    You have elected to load    |");
					System.out.println("|    the default ship package.   |");
					fileName = "shipRoster.txt";
					setChoiceValid(true);
				} else {
					System.out.println(" " + choice + "  is not Valid entry");
					System.out.println(" Please try another entry. ");
					waitForMillis(100);

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
		System.out.println("\n\n\n");
		System.out.println("\nThank you " + getUserName() + ", the file you have ");
		System.out.println("selected to use is as follows : \n");
		System.out.print("\t*");
		System.out.print(fileName);
		System.out.println("*");
		waitForMillis(200);
		System.out.println("\n\n\n");
		return fileName;
	}

	protected static void waitForMillis(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isGameRun() {
		return gameRun;
	}

	public void setGameRun(boolean gameRun) {
		this.gameRun = gameRun;
	}

	public boolean isChoiceValid() {
		return choiceValid;
	}

	public void setChoiceValid(boolean choiceValid) {
		this.choiceValid = choiceValid;
	}

}
