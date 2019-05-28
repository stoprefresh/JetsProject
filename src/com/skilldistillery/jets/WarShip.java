package com.skilldistillery.jets;

public class WarShip extends StarShip implements WarShipUtilities {

	private boolean weaponSysActive;
	private int totalTorpedos, pointDefense;

	public WarShip() {
	}
	
	public WarShip(String vesselName, String model, double speed,   
			double price, double fuelCapacity, int crewSize,
			boolean weaponSysActive, int totalTorpedos, int pointDefense) {
		super();
		setVesselName(vesselName);
		setModel(model);
		setSpeed(speed);
		setPrice(price);
		super.setFuelCapacity(fuelCapacity);
		setCrewSize(crewSize);
		setWeaponSysActive(false);
		setTotalTorpedos(totalTorpedos);
		setPointDefense(pointDefense);
		super.setRange(fuelCapacity);
		super.setLaunched(false);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	
	@Override
	public boolean prelaunch() {
		if(isWeaponSysActive() == true) {
			loading();
			System.out.println("\nStation Defense Ship [" + getVesselName() 
			+ "] has already completed her pre-launch checks. Ready for sorte.");
		}
		else {
		System.out.println("\nStation Defense Ship [" + getVesselName() 
		+ "] prepping for sorte.");
		setWeaponSysActive(true);
		System.out.println("Weapons Systems Online [" + isWeaponSysActive() + "]");
		loading();
		}
		return isWeaponSysActive();
	}

	@Override
	public boolean engage() {
		if(isWeaponSysActive() == true) {
		getTotalTorpedos();
		System.out.println("[" + getVesselName() 
		+ "] has begun an attack run on our mock target.");
		loading();
		setWeaponSysActive(false);
		System.out.println("Target destroyed, Torpedo magazines have been fully expended.");
		System.out.println("[" + getVesselName() + "] Weapon Systems Online [" + isWeaponSysActive() + "]");
		loading();
		}
		else {
			System.out.println("[" + getVesselName() + "] Weapon Systems Online [" + isWeaponSysActive() + "]");
			loading();
		}
		return isWeaponSysActive();
	}

	@Override
	public boolean defend() {
		getPointDefense();
		setWeaponSysActive(false);
		loading();
		return isWeaponSysActive();
	}



	public int getPointDefense() {
		return pointDefense;
	}



	public void setPointDefense(int pointDefense) {
		this.pointDefense = pointDefense;
	}
	
	public boolean isWeaponSysActive() {
		return weaponSysActive;
	}

	public void setWeaponSysActive(boolean weaponSysActive) {
		this.weaponSysActive = weaponSysActive;
	}

	public int getTotalTorpedos() {
		return totalTorpedos;
	}

	public void setTotalTorpedos(int totalTorpedos) {
		this.totalTorpedos = totalTorpedos;
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
	


}
