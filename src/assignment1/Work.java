package assignment1;

import java.util.Scanner;

public class Work extends Event {

	private String location;
	private double numHours;
	
	Work(){
	}
	
	Work(int eventType, OurDate date, OurTime time, String desc, String location, int numHours){
		super(eventType, date, time, desc);
		this.location=location;
		this.numHours=numHours;
	}
	
	public String toString() {
		return String.format("%s|%7s|%7s|%7s|%7s|%7s|%7s|%20s|%7s%n", 
				eventType, super.date.getDay(), super.date.getMonth(), super.date.getYear(), 
				super.time.getHour(), super.time.getMinute(), desc, location, numHours);
	}
	
	public void readInfo(Scanner input) {
		super.readInfo(input);
		System.out.println("Enter location \n");
		this.location=input.next();
		System.out.println("Enter hours \n");
		this.numHours=input.nextInt();
	}
	
	public void readInfoFromFile(Scanner input) {
		
	}
	
}
