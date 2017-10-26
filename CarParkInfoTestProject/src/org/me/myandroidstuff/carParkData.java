package org.me.myandroidstuff;

public class carParkData {

	public String carParkIdentity;
	public String carParkOccupancy;
	public String carParkStatus;
	public String occupiedSpaces;
	public String totalCapacity;
	
	public carParkData()
	{
		carParkIdentity = "";
		carParkOccupancy = "";
		carParkStatus = "";
		occupiedSpaces = "";
		totalCapacity = "";
	}
	
	public carParkData(String aCarParkIdentity, String aCarParkOccupancy, String aCarParkStatus,
			           String aOccupiedSpaces, String aTotalCapacity)
	 {
		carParkIdentity = aCarParkIdentity;
		carParkOccupancy = aCarParkOccupancy;
		carParkStatus = aCarParkStatus;
		occupiedSpaces = aOccupiedSpaces;
		totalCapacity = aTotalCapacity;
	 }
	
	public String getcarParkIdentity()
	{
		return carParkIdentity;
	}
	
	public void setcarParkIdentity(String aCarParkIdentity)
	{
		 carParkIdentity = aCarParkIdentity;
	}
	
	public String getcarParkOccupancy()
	{
		return carParkOccupancy;
	}
	
	public void setcarParkOccupancy(String aCarParkOccupancy)
	{
		 carParkOccupancy = aCarParkOccupancy;
	}
	
	public String getcarParkStatus()
	{
		return carParkStatus;
	}
	
	public void setcarParkStatus(String aCarParkStatus)
	{
		 carParkStatus = aCarParkStatus;
	}
	
	public String getoccupiedSpaces()
	{
		return occupiedSpaces;
	}
	
	public void setoccupiedSpaces(String aOccupiedSpaces)
	{
		occupiedSpaces = aOccupiedSpaces;
	}
	
	public String gettotalCapacity()
	
	{
		return totalCapacity;
	}
	
	public void settotalCapacity(String aTotalCapacity)
	{
		totalCapacity = aTotalCapacity;
		
	}
	
	public String toString()
	{
		String temp;
		
		temp = carParkIdentity + " " + carParkOccupancy + " " + carParkStatus + " " + 
		       occupiedSpaces +  " " + totalCapacity;
		
		return temp;
	}
	
}
// Mathew McGerty - S1036834
