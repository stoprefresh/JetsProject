package com.skilldistillery.jets;

public class StandardShip extends StarShip{

	public StandardShip() {}
	
	public StandardShip(String vesselName, String model, double speed,   
			double price, double fuelCapacity, int crewSize) {
		super();
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
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
		
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

}
