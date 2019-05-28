package com.skilldistillery.jets;

public abstract class StarShip {

	protected double speed, price, range, fuelCapacity;
	protected String model, vesselName;
	protected int crewSize;

	public StarShip() {
	}
	
	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "StarShip [speed=" + speed + ", price=" + price + ", range=" + range + ", fuelCapacity=" + fuelCapacity
				+ ", model=" + model + ", vesselName=" + vesselName + ", crewSize=" + crewSize + "]";
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRange() {
		return range;
	}

	public void setRange(double fuelCapacity) {
		double r = (((fuelCapacity/.00325) / 60) / 24);
		this.range = (double) Math.round(r * 100) / 100;
		
	}

	public double getFuelCapacity() {
		return fuelCapacity;
	}

	public void setFuelCapacity(double fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVesselName() {
		return vesselName;
	}

	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}

	public int getCrewSize() {
		return crewSize;
	}

	public void setCrewSize(int crewSize) {
		this.crewSize = crewSize;
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
