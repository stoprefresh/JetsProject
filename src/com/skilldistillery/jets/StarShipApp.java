package com.skilldistillery.jets;

import java.util.*;

public class StarShipApp {

	public static void main(String[] args) {

		StarShipApp ssA = new StarShipApp();

		ssA.startApp();

	}

	public void startApp() {

		SpaceStation homebase = new SpaceStation();

		Scanner kb = new Scanner(System.in);

		homebase.userMenu(kb);

		kb.close();

	}
}
