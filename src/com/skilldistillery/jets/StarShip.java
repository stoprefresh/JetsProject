package com.skilldistillery.jets;

public abstract class StarShip {

	protected double speed, price, range, fuelCapacity;
	protected String model, vesselName;
	protected int crewSize;
	protected boolean launched;

	
	public void returning() {
		System.out.println("Preparing [" + getVesselName() + "] for docking in ");
    	loading();
    	System.out.print("\n3 ");
    	loading();
    	System.out.print("\n2 ");
    	loading();
    	System.out.print("\n1 ");
    	System.out.println(" [" + getVesselName() + "] has reconnected.");
    	setLaunched(false);
	}
	
	
	
	public void depart() {

		System.out.println("Preparing [" + getVesselName() + "] for launch in ");
    	loading();
    	System.out.print("\n3 ");
    	loading();
    	System.out.print("\n2 ");
    	loading();
    	System.out.print("\n1 ");
    	System.out.println(" [" + getVesselName() + "] is away.");
    	System.out.println(" [" + getRange() + " (hrs)-Continuous Burn available]");
    	setLaunched(true);
    }
	
	public boolean isLaunched() {
		return launched;
	}

	public void setLaunched(boolean launched) {
		this.launched = launched;
	}

	public StarShip() {
	}
	
	public StarShip(String vesselName, String model, double speed,   
			double price, double fuelCapacity, int crewSize) {
		setVesselName(vesselName);
		setModel(model);
		setSpeed(speed);
		setPrice(price);
		setCrewSize(crewSize);
		setFuelCapacity(fuelCapacity);
	}
	
	protected double getSpeed() {
		return speed;
	}

	protected void setSpeed(double speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "StarShip [speed=" + speed + ", price=" + price + ", range=" + range + ", fuelCapacity=" + fuelCapacity
				+ ", model=" + model + ", vesselName=" + vesselName + ", crewSize=" + crewSize + "]";
	}

	protected double getPrice() {
		return price;
	}

	protected void setPrice(double price) {
		this.price = price;
	}

	protected double getRange() {
		return range;
	}

	protected void setRange(double fuelCapacity) {
		double r = (((fuelCapacity/.00325) / 60) / 24);
		this.range = (double) Math.round(r * 100) / 100;
		
	}

	protected double getFuelCapacity() {
		return fuelCapacity;
	}

	protected void setFuelCapacity(double fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	protected String getModel() {
		return model;
	}

	protected void setModel(String model) {
		this.model = model;
	}

	protected String getVesselName() {
		return vesselName;
	}

	protected void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}

	protected int getCrewSize() {
		return crewSize;
	}

	protected void setCrewSize(int crewSize) {
		this.crewSize = crewSize;
	}
	protected static void waitForMillis(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}
	
	protected void loading() {
		for (int i = 0; i < 12; i++) {
			System.out.print("*  ");
			waitForMillis(60);
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + crewSize;
		long temp;
		temp = Double.doubleToLongBits(fuelCapacity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(range);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(speed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((vesselName == null) ? 0 : vesselName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StarShip other = (StarShip) obj;
		if (crewSize != other.crewSize)
			return false;
		if (Double.doubleToLongBits(fuelCapacity) != Double.doubleToLongBits(other.fuelCapacity))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (Double.doubleToLongBits(range) != Double.doubleToLongBits(other.range))
			return false;
		if (Double.doubleToLongBits(speed) != Double.doubleToLongBits(other.speed))
			return false;
		if (vesselName == null) {
			if (other.vesselName != null)
				return false;
		} else if (!vesselName.equals(other.vesselName))
			return false;
		return true;
	}

}
