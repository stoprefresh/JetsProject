import java.util.*;

public class Station {

	private ArrayList<StarShip> dockedShips;
	private ArrayList<StarShip> disembarked;
	private int soulsAboard;
	private String userName;

	public Station() {
	}

	public void userMenu(Scanner in) {

		int selection = 0;
		boolean gameRun = true;
		userName = startMessage(in);

		while (gameRun == true) {
			menuPrintOut();

			try {
				selection = in.nextInt();

			} catch (InputMismatchException e) {
				System.err.println("|********************************|");
				System.err.println("| That is not a valid selection  |");
				System.err.println("|    Input your selection again  |");
				System.err.println("|********************************|");
			}
			if (gameRun == true) {
				if (selection == 1) {
					starShipStat(in);
					waitForMillis(120);
				} else if (selection == 2) {
					displayBest();
					waitForMillis(120);
				} else if (selection == 3) {
					transportShips(in);
					waitForMillis(120);
				} else if (selection == 4) {
					warShips(in);
					waitForMillis(120);
				} else if (selection == 5) {
					shipMgmt(in);
					waitForMillis(120);
				} else if (selection == 6) {
					gameRun = false;
					for(int i = 0; i < 12; i++) {
						System.out.print("*  ");
						waitForMillis(200);
					}
					System.out.println("\n|================================|");
					System.out.println("|*       Exiting Terminal       *|");
					System.out.println("|================================|");
				} else {
					System.out.println(" " + selection + " is not an available option.");
					System.out.println(" Returning to top menu ");
					waitForMillis(100);
					blankSpaceReset();
				}
			}
		}

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
		for(int i = 0; i < 12; i++) {
			System.out.print("*  ");
			waitForMillis(200);
		}
		System.out.println("\n|   Please enter your username:  |");
		try {
			System.out.println("");
			
			name = in.nextLine();	
		}
		catch(InputMismatchException e) {
			
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
	
	public void blankSpaceReset() {
		for(int i = 0; i < 10; i++) {
			System.out.println("");
		}
	}

	public void fileSave() {

	}

	public void fileRead() {

	}
	
	
	  public static void waitForMillis(long millis) {
	    try {
	      Thread.sleep(millis);
	    }
	    catch (InterruptedException e) {
	    }
	  }

}
