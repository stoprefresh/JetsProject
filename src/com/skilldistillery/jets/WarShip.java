package com.skilldistillery.jets;

public class WarShip extends StarShip implements WarShipUtilities {

	private boolean weaponSysActive;
	private int totalTorpedos, pointDefense;

	public WarShip() {
	}
	
	public WarShip(String vesselName, String model, double speed,   
			double price, double fuelCapacity, int crewSize,
			boolean weaponSysActive, int totalTorpedos, int pointDefense) {
		
		setVesselName(vesselName);
		setModel(model);
		setSpeed(speed);
		setPrice(price);
		super.setFuelCapacity(fuelCapacity);
		setCrewSize(crewSize);
		this.weaponSysActive = weaponSysActive;
		this.totalTorpedos = totalTorpedos;
		this.setPointDefense(pointDefense);
		super.setRange(fuelCapacity);
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + pointDefense;
		result = prime * result + totalTorpedos;
		result = prime * result + (weaponSysActive ? 1231 : 1237);
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		WarShip other = (WarShip) obj;
		if (pointDefense != other.pointDefense)
			return false;
		if (totalTorpedos != other.totalTorpedos)
			return false;
		if (weaponSysActive != other.weaponSysActive)
			return false;
		return true;
	}




	

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public void engage() {
		// TODO Auto-generated method stub
	}

	@Override
	public void defend() {
		// TODO Auto-generated method stub
	}



	public int getPointDefense() {
		return pointDefense;
	}



	public void setPointDefense(int pointDefense) {
		this.pointDefense = pointDefense;
	}

}
