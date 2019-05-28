package com.skilldistillery.jets;

public class TransportShip extends StarShip implements TransportShipUtilities{

	private boolean suppliesLoaded;
	private int totalTonsSupplies;
	
	
	
	public TransportShip() {}
	
	public TransportShip(String vesselName, String model, double speed,   
			double price, double fuelCapacity, int crewSize, 
			int totalTonsSupplies, boolean suppliesLoaded) {
		setVesselName(vesselName);
		setModel(model);
		setSpeed(speed);
		setPrice(price);
		setFuelCapacity(fuelCapacity);
		setCrewSize(crewSize);
		this.totalTonsSupplies = totalTonsSupplies;
		this.suppliesLoaded = suppliesLoaded;
		super.setRange(fuelCapacity);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (suppliesLoaded ? 1231 : 1237);
		result = prime * result + totalTonsSupplies;
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
		TransportShip other = (TransportShip) obj;
		if (suppliesLoaded != other.suppliesLoaded)
			return false;
		if (totalTonsSupplies != other.totalTonsSupplies)
			return false;
		return true;
	}

	
	
	
	@Override
	public void loadSupplies() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void offloadSupplies() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "TransportShip [suppliesLoaded=" + suppliesLoaded + ", totalTonsSupplies=" + totalTonsSupplies + super.toString() +"]";
	}
	
	
}
