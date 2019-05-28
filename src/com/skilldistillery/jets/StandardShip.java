package com.skilldistillery.jets;

public class StandardShip extends StarShip{

	
	public StandardShip() {}
	
	
	public StandardShip(String vesselName, String model, double speed,   
			double price, double fuelCapacity, int crewSize) {
		setVesselName(vesselName);
		setModel(model);
		setSpeed(speed);
		setPrice(price);
		setCrewSize(crewSize);
		setFuelCapacity(fuelCapacity);
		super.setRange(fuelCapacity);
	}

	

	@Override
	public String toString() {
		return super.toString();
	}
	
}
