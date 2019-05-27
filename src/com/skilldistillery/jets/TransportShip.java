package com.skilldistillery.jets;

public class TransportShip extends StarShip implements TransportShipUtilities{

	private boolean suppliesLoaded;
	private int totalTonsSupplies;
	
	
	
	public TransportShip() {}
	
	public TransportShip(String vesselName, String model, double speed,   
			double price, double fuelCapactiy, int crewSize, int totalTonsSupplies) {
		
	}
	public TransportShip(String vesselName, String model, double speed,   
			double price, double fuelCapacity, int crewSize, 
			int totalTonsSupplies, boolean suppliesLoaded) {
		
	}
	
	
	
	@Override
	public void loadSupplies() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void offloadSupplies() {
		// TODO Auto-generated method stub
		
	}
	
	
}
