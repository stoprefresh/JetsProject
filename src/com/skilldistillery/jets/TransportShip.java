package com.skilldistillery.jets;

public class TransportShip extends StarShip implements TransportShipUtilities{

	private boolean suppliesLoaded;
	private int totalTonsSupplies;
	
	public TransportShip() {}
	
	public TransportShip(String vesselName, String model, double speed,   
			double price, double fuelCapacity, int crewSize, 
			int totalTonsSupplies, boolean suppliesLoaded) {
		super();
		setVesselName(vesselName);
		setModel(model);
		setSpeed(speed);
		setPrice(price);
		setFuelCapacity(fuelCapacity);
		setCrewSize(crewSize);
		this.totalTonsSupplies = totalTonsSupplies;
		this.suppliesLoaded = suppliesLoaded;
		super.setRange(fuelCapacity);
		super.setLaunched(false);
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

	
	
	
	
	public boolean loadSupplies() {
		if(isSuppliesLoaded() == true) {
			loading();
			System.out.println("\n [" + super.getVesselName() 
		   + "] is already fullyloaded.");
		}
		else {
		System.out.println("Preparring to load supplies.");
		setSuppliesLoaded(true);
		loading();
		System.out.println("\n [" + super.getVesselName() 
		   + "] is finished loading supplies");
		System.out.println(getTotalTonsSupplies() + " tons onboard.");
		}
		return isSuppliesLoaded();
	}
		
	public boolean offloadSupplies() {
		if(isSuppliesLoaded() == false) {
			loading();
			System.out.println("\n [" + super.getVesselName() 
		   + "] has already off-loaded her supplies.");
		}
		else {
		System.out.println("Preparring to off-load supplies.");
		setSuppliesLoaded(false);
		loading();
		System.out.println("\n [" + super.getVesselName() 
		   + "] is finished off-loading supplies");
		}
		return isSuppliesLoaded();
	}

	@Override
	public String toString() {
		return "TransportShip [suppliesLoaded=" + suppliesLoaded + ", totalTonsSupplies=" + totalTonsSupplies + super.toString() +"]";
	}
	
	public boolean isSuppliesLoaded() {
		return suppliesLoaded;
	}

	public void setSuppliesLoaded(boolean suppliesLoaded) {
		this.suppliesLoaded = suppliesLoaded;
	}

	public int getTotalTonsSupplies() {
		return totalTonsSupplies;
	}

	public void setTotalTonsSupplies(int totalTonsSupplies) {
		this.totalTonsSupplies = totalTonsSupplies;
	}
}
