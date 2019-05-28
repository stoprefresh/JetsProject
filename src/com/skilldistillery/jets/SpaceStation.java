package com.skilldistillery.jets;

import java.io.*;
import java.util.*;

public class SpaceStation {

	private String userName;

	private boolean gameRun, choiceValid;

	public SpaceStation() {

	}

	public void userMenu(Scanner in) {

		
		setGameRun(true);
		setUserName(startMessage(in));

		List<StarShip> starship = readStarShips(getFileName(in));

		while (isGameRun() == true) {

			menuPrintOut();

			int selection = in.nextInt();

			switch (selection) {

			case 1:
				loading();
				portStatus(starship, in);
				break;

			case 2:
				loading();
				transportBay(starship, in);
				break;

			case 3:
				loading();
				defFleetPre(starship, in);
				break;

			case 4:
				loading();
				starship = dockMgmt(starship, in);
				break;

			case 5:
				setGameRun(false);
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

	private StarShip builder(Scanner in) {
		String vesselName, model;
		boolean menuOption = false;
		double speed = 0.0, price = 0.0, fuelCapacity = 0.0;
		int crewSize = 0;
		StarShip x = null;

		while (menuOption != true) {
			System.out.println("\n\n|================================|");
			System.out.println("|*     StarShip Commisioning    *|");
			System.out.println("|================================|");
			System.out.println("|1. WarShip Requisition          |");
			System.out.println("|2. Corporate Transport Request  |");
			System.out.println("|3. Private StarShip Order Form  |");
			System.out.println("|4. Review and Approve           |");
			System.out.println("|================================|");
			System.out.println("|5. Return to Main Menu          |");
			int selection = in.nextInt();

			switch (selection) {
			case 1:
				boolean weaponSysActive = false;
				int totalTorpedos = 12, pointDefense = 6;
				System.out.println("You have selected to Requisition a WarShip.");
				System.out.println("Please enter the following information.");
				System.out.println("");
				model = in.nextLine();
				System.out.println("Enter a Model Type:");
				model = in.nextLine();
				System.out.println("Enter a Vessel Name:");
				vesselName = in.nextLine();
				
				System.out.println("\nEnter the vessels speed in km/s:");
				speed = ensureEntryDouble(in);
				
				System.out.println("\nEnter the Price:");
				price = ensureEntryDouble(in);

				System.out.println("\nEnter the vessels Fuel Capacity:");
				fuelCapacity = ensureEntryDouble(in);

				System.out.println("\nEnter the Maximum number of crew Members:");
				crewSize = ensureEntryInt(in);

				StarShip w = new WarShip(vesselName, model, speed, price, fuelCapacity, crewSize, weaponSysActive,
						totalTorpedos, pointDefense);
				x = w;
				waitForMillis(150);
				break;
			case 2:
				boolean suppliesLoaded = false;
				int totalTonsSupplies = 150;
				System.out.println("You have selected to Request a Transport from Coporate.");
				System.out.println("Please enter the following information.");

				System.out.println("");
				model = in.nextLine();
				System.out.println("Enter a Model Type:");
				model = in.nextLine();
				System.out.println("Enter a Vessel Name:");
				vesselName = in.nextLine();

				System.out.println("Enter the vessels speed in km/s:");
				speed = ensureEntryDouble(in);

				System.out.println("Enter the Price:");
				price = ensureEntryDouble(in);

				System.out.println("Enter the vessels Fuel Capacity:");
				fuelCapacity = ensureEntryDouble(in);

				System.out.println("Enter the Maximum number of crew Members:");
				crewSize = ensureEntryInt(in);

				StarShip t = new TransportShip(vesselName, model, speed, price, fuelCapacity, crewSize,
						totalTonsSupplies, suppliesLoaded);
				x = t;
				waitForMillis(150);
				break;
			case 3:
				System.out.println("You have selected to Purchase a Private Vessel.");
				System.out.println("Please enter the following information.");

				System.out.println("");
				model = in.nextLine();
				System.out.println("Enter a Model Type:");
				model = in.nextLine();
				System.out.println("Enter a Vessel Name:");
				vesselName = in.nextLine();

				System.out.println("Enter the vessels speed in km/s:");
				speed = ensureEntryDouble(in);

				System.out.println("Enter the Price:");
				price = ensureEntryDouble(in);

				System.out.println("Enter the vessels Fuel Capacity:");
				fuelCapacity = ensureEntryDouble(in);

				System.out.println("Enter the Maximum number of crew Members:");
				crewSize = ensureEntryInt(in);

				StarShip s = new StandardShip(vesselName, model, speed, price, fuelCapacity, crewSize);
				x = s;
				waitForMillis(150);
				break;
			case 4:
				System.out.println("Vessel [" + x.getVesselName() + "]" + " : Model [" + x.getModel() + "] : Type ["
						+ x.getClass().getSimpleName() + "]");
				System.out.print("Speed [ " + x.getSpeed() + "-km/s]" + " : [" + x.getRange()
						+ " (hrs)-Continuous Burn] : Price [" + x.getPrice() + "]\n\n");

				System.out.println("\n\nIf you are statified with your order you may now exit.");

				break;
			case 5:

				menuOption = true;
				waitForMillis(150);
				break;
			default:
				System.out.println(" " + selection + " is not an available option.");
				System.out.println(" Returning to top menu ");
				waitForMillis(100);
				break;

			}
		}
		return x;

	}

	private List<StarShip> dockMgmt(List<StarShip> starship, Scanner in) {

		List<StarShip> dockedShips = starship;
		boolean menuOption = false;

		while (menuOption != true) {
			System.out.println("\n\n|================================|");
			System.out.println("|*  StarShip Docking Management *|");
			System.out.println("|================================|");
			System.out.println("|1. Display Docked Ships         |");
			System.out.println("|2. Launch All Ships             |");
			System.out.println("|3. Display Localized Ships      |");
			System.out.println("|4. Dock All Ships               |");
			System.out.println("|5. Commision a new vessel       |");
			System.out.println("|6. Retire a vessel              |");
			System.out.println("|================================|");
			System.out.println("|7. Return to Main Menu          |");
			int selection = in.nextInt();

			switch (selection) {
			case 1:
				for (StarShip a : starship) {
					if ((a instanceof StarShip) && (a.isLaunched() == false)) {
						System.out.println(
								"Vessel [" + a.getVesselName() + "]" + " : Model [" + a.getModel() + "] : Type ["
										+ a.getClass().getSimpleName() + "] : Crew Size [" + a.getCrewSize() + "]\n\n");
					}
				}
				waitForMillis(150);
				break;
			case 2:
				for (StarShip a : starship) {
					if ((a instanceof StarShip) && (a.isLaunched() == false)) {
						System.out.println();
						((StarShip) a).depart();
					}
				}
				waitForMillis(150);
				break;
			case 3:
				for (StarShip a : starship) {
					if ((a instanceof StarShip) && (a.isLaunched() == true)) {
						System.out.println(
								"Vessel [" + a.getVesselName() + "]" + " : Model [" + a.getModel() + "] : Type ["
										+ a.getClass().getSimpleName() + "] : Crew Size [" + a.getCrewSize() + "]\n\n");
					}
				}
				waitForMillis(150);
				break;
			case 4:
				for (StarShip a : starship) {
					if ((a instanceof StarShip) && (a.isLaunched() == true)) {
						System.out.println();
						((StarShip) a).returning();
					}
				}
				waitForMillis(150);
				break;
			case 5:
				starship.add(builder(in));
				waitForMillis(150);
				break;
			case 6:
				starship.remove(scrapShip(starship, in));
				waitForMillis(150);
				break;
			case 7:
				menuOption = true;
				waitForMillis(150);
				break;
			default:
				System.out.println(" " + selection + " is not an available option.");
				System.out.println(" Returning to top menu ");
				waitForMillis(100);
				break;

			}

		}
		return dockedShips;
	}

	private int scrapShip(List<StarShip> starship, Scanner in) {

		System.out.println("\n\nIn this section, you may scrap one of the vessels at the station");

		for (StarShip a : starship) {
			System.out.println(starship.indexOf(a) + 1 + ". " + a.vesselName);
			
		}
		System.out.println("Choose one of the displayed ships to be scrapped.");
		int scrapone = in.nextInt() - 1;
		return scrapone;
	}

	private void defFleetPre(List<StarShip> starship, Scanner in) {
		boolean menuOption = false;

		while (menuOption != true) {
			System.out.println("\n\n|================================|");
			System.out.println("|* Defense Fleet Pre-Launch Bay *|");
			System.out.println("|================================|");
			System.out.println("|1. Display War Ships            |");
			System.out.println("|2. Prep for Launch              |");
			System.out.println("|3. Launch Defense Fleet         |");
			System.out.println("|4. Weapons Free                 |");
			System.out.println("|5. Return Defense Fleet         |");
			System.out.println("|================================|");
			System.out.println("|6. Return to Main Menu          |");
			int selection = in.nextInt();

			switch (selection) {

			case 1:
				for (StarShip a : starship) {
					if ((a instanceof WarShip) && (a.isLaunched() == false)) {
						System.out.println("Vessel [" + a.getVesselName() + "] : Point Defense Battery ["
								+ ((WarShip) a).getPointDefense() + " : Max Torpedos ["
								+ ((WarShip) a).getTotalTorpedos() + "] \n Model [" + a.getModel() + "] : Type ["
								+ a.getClass().getSimpleName() + "] : Crew Size [" + a.getCrewSize()
								+ "] \n Weapon System Online [" + ((WarShip) a).isWeaponSysActive() + "]\n\n");
					}
				}
				waitForMillis(150);
				break;
			case 2:
				for (StarShip a : starship) {
					if ((a instanceof WarShip) && (a.isLaunched() == false)) {
						System.out.println();
						((WarShip) a).prelaunch();
					}
				}
				waitForMillis(150);
				break;
			case 3:
				for (StarShip a : starship) {
					if ((a instanceof WarShip) && (a.isLaunched() == false)) {
						System.out.println();
						((WarShip) a).depart();
					}
				}
				waitForMillis(150);
				break;
			case 4:
				for (StarShip a : starship) {
					if ((a instanceof WarShip) && (a.isLaunched() == true)) {
						System.out.println();
						((WarShip) a).engage();
					}
				}
				waitForMillis(150);
				break;
			case 5:
				for (StarShip a : starship) {
					if ((a instanceof WarShip) && (a.isLaunched() == true)) {
						System.out.println();
						((WarShip) a).returning();
					}
				}
				waitForMillis(150);
				break;
			case 6:
				menuOption = true;
				waitForMillis(150);
				break;
			default:
				System.out.println(" " + selection + " is not an available option.");
				System.out.println(" Returning to top menu ");
				waitForMillis(100);
				break;
			}
		}
	}

	private void transportBay(List<StarShip> starship, Scanner in) {
		boolean menuOption = false;

		while (menuOption != true) {
			System.out.println("\n\n|================================|");
			System.out.println("|*        Transport Bay         *|");
			System.out.println("|================================|");
			System.out.println("|1. Display Transport Ships      |");
			System.out.println("|2. Stage Ships for loading      |");
			System.out.println("|3. Begin Off-Load               |");
			System.out.println("|4. Launch Transport Convoy      |");
			System.out.println("|5. Prep for Return              |");
			System.out.println("|================================|");
			System.out.println("|6. Return to Main Menu          |");
			int selection = in.nextInt();

			switch (selection) {

			case 1:
				for (StarShip a : starship) {
					if ((a instanceof TransportShip) && (a.isLaunched() == false)) {
						System.out.println("Vessel [" + a.getVesselName() + "]" + " : Max Tons of Cargo ["
								+ ((TransportShip) a).getTotalTonsSupplies() + "] : Model [" + a.getModel()
								+ "] : Type [" + a.getClass().getSimpleName() + "] : Crew Size [" + a.getCrewSize()
								+ "] \n Loaded for Transit [" + ((TransportShip) a).isSuppliesLoaded() + "]\n\n");
					}
				}
				waitForMillis(150);
				break;
			case 2:
				for (StarShip a : starship) {
					if ((a instanceof TransportShip) && (a.isLaunched() == false)) {
						System.out.println();
						((TransportShip) a).loadSupplies();
					}
				}
				break;
			case 3:
				for (StarShip a : starship) {
					if ((a instanceof TransportShip) && (a.isLaunched() == false)) {
						System.out.println();
						((TransportShip) a).offloadSupplies();
					}
				}
				break;
			case 4:
				for (StarShip a : starship) {
					if ((a instanceof TransportShip) && (a.isLaunched() == false)) {
						System.out.println();
						((TransportShip) a).depart();
					}
				}
				waitForMillis(150);
				break;
			case 5:
				for (StarShip a : starship) {
					if ((a instanceof TransportShip) && (a.isLaunched() == true)) {
						System.out.println();
						((TransportShip) a).returning();
					}
				}

				waitForMillis(150);
				break;
			case 6:
				menuOption = true;
				waitForMillis(150);
				break;
			default:
				System.out.println(" " + selection + " is not an available option.");
				System.out.println(" Returning to top menu ");
				waitForMillis(100);
				break;
			}
		}
	}

	private void portStatus(List<StarShip> starship, Scanner in) {
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
					if ((a instanceof StarShip) && (a.isLaunched() == false)) {
						System.out.println(
								"Vessel [" + a.getVesselName() + "]" + " : Model [" + a.getModel() + "] : Type ["
										+ a.getClass().getSimpleName() + "] : Crew Size [" + a.getCrewSize() + "]\n\n");
					} else {
						System.out.println(" [" + a.getVesselName() + "] Has already launched.");
					}

				}

				waitForMillis(150);
				break;
			case 2:
				for (StarShip a : starship) {
					if ((a instanceof StarShip) && (a.isLaunched() == false)) {
						System.out.println("Vessel [" + a.getVesselName() + "]" + " : Model [" + a.getModel()
								+ "] : Type [" + a.getClass().getSimpleName() + "]");
						System.out.print("Speed [ " + a.getSpeed() + "-km/s]" + " : [" + a.getRange()
								+ " (hrs)-Continuous Burn] : Price [" + a.getPrice() + "]\n\n");
					} else {
						System.out.println(" [" + a.getVesselName() + "] Has already launched.");
					}
				}
				waitForMillis(150);
				break;
			case 3:
				for (StarShip a : starship) {
					if ((a instanceof StarShip) && (a.isLaunched() == false)) {
						if (a.getSpeed() > fastest) {
							fastest = a.getSpeed();
							f = a.getVesselName();
						}
						if (a.getRange() > highestRange) {
							highestRange = a.getRange();
							r = a.getVesselName();
						}
					}
				}
				System.out.println("Top performers currently on station.");
				System.out.println("Fastest:" + f + " at " + fastest + "-km/s");
				System.out.println("Longest Running: " + r + " at " + highestRange + " (hrs)-Continuous Burn");
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

	private double ensureEntryDouble(Scanner in) {
		double entry = 0;

		try {

			entry = Double.parseDouble(in.nextLine());

		} catch (InputMismatchException e) {
			System.err.println("|********************************|");
			System.err.println("| That is not a valid selection  |");
			System.err.println("|    Input your selection again  |");
			System.err.println("|********************************|");
		}

		return entry;
	}

	private int ensureEntryInt(Scanner in) {
		int entry = 0;
		try {
			entry = Integer.parseInt(in.nextLine());

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

//	private void saveStarShips(List<StarShip> dockedShips, Scanner in) {

//		try {
//		      FileWriter fw = new FileWriter(outFileName);
//		      PrintWriter pw = new PrintWriter(fw);
//		      for (StarShip s : starship) {
//		        StringBuilder sb = new StringBuilder();
//		        sb.append(p.getName());
//		        sb.append('\t');
//		        sb.append(p.getOrbit());
//		        sb.append('\t');
//		        sb.append(p.getDiameter());
//		        pw.println(sb);
//		      }
//		      pw.close();
//		    }
//		    catch (IOException e) {
//		      e.printStackTrace();
//		    }
//		  }
//	}

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
		setUserName(null);

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

			setUserName(in.nextLine());

		} catch (InputMismatchException e) {

		}
		return getUserName();
	}

	private String getFileName(Scanner in) {

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

	private String getUserName() {
		return userName;
	}

	private void setUserName(String userName) {
		this.userName = userName;
	}

	private boolean isGameRun() {
		return gameRun;
	}

	private void setGameRun(boolean gameRun) {
		this.gameRun = gameRun;
	}

	private boolean isChoiceValid() {
		return choiceValid;
	}

	private void setChoiceValid(boolean choiceValid) {
		this.choiceValid = choiceValid;
	}

}
