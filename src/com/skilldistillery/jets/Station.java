package com.skilldistillery.jets;

import java.io.*;
import java.util.*;

public class Station {

	private List<StarShip> dockedShips;
	private List<StarShip> disembarked;
	private int soulsAboard;
	private String userName;
	boolean choiceValid, gameRun;

	public Station() {
	}

	public void userMenu(Scanner in) {

		MenuNavigation menu = new MenuNavigation();
		
		int selection = 0;
		gameRun = true;
		userName = menu.startMessage(in);
		dockedShips = menu.readStarShips(menu.getFileName(in));

		while (gameRun == true) {
			menu.menuPrintOut();
			
			selection = menu.ensureEntryInt(in);
			
			if (gameRun == true) {
				if (selection == 1) {
					menu.starShipStat(in);
					blankSpaceReset();
					waitForMillis(120);
				} else if (selection == 2) {
					menu.displayBest();
					blankSpaceReset();
					waitForMillis(120);
				} else if (selection == 3) {
					menu.transportShips(in);
					blankSpaceReset();
					waitForMillis(120);
				} else if (selection == 4) {
					menu.warShips(in);
					blankSpaceReset();
					waitForMillis(120);
				} else if (selection == 5) {
					menu.shipMgmt(in);
					blankSpaceReset();
					waitForMillis(120);
				} else if (selection == 6) {
					gameRun = false;
					for (int i = 0; i < 12; i++) {
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
	
	

	protected void blankSpaceReset() {
		for (int i = 0; i < 10; i++) {
			System.out.println("");
		}
	}

	protected static void waitForMillis(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}

}
