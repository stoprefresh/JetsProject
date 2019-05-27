package com.skilldistillery.jets;

public class WarShip extends StarShip implements WarShipUtilities {

	private boolean weaponSysActive;
	private int totalTorpedos, pointDefense;

	public WarShip() {
	}

	public WarShip(String vesselName, String model, double speed,   
			double price, double fuelCapactiy, int crewSize) {

	}
	public WarShip(String vesselName, String model, double speed,   
			double price, double fuelCapacity, int crewSize,
			boolean weaponSysActive, int totalTorpedos, int pointDefense) {

	}

	

	@Override
	public void engage() {
		// TODO Auto-generated method stub
	}

	@Override
	public void defend() {
		// TODO Auto-generated method stub
	}

}
