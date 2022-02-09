package assignment1;

import java.util.Scanner;

public class Meeting extends Event {

	private String location;

	Meeting(){
		
	}
	
	Meeting(int eventType, OurDate date, OurTime time, String desc, String location){
		super(eventType,date, time, desc);
		this.location=location;
	}
	public String toString() {
		return String.format("%s|%7s|%7s|%7s|%7s|%7s|%20s|%12s|%n", 
				eventType, super.date.getDay(), super.date.getMonth(), super.date.getYear(), 
				super.time.getHour(), super.time.getMinute(), desc, location);
	}
	
	public void readInfo(Scanner input) {
		super.readInfo(input);
		System.out.print("Enter location \n");
		this.location=input.next();
	}
	
	public void readInfoFromFile(Scanner input) {
		
	}
	

	
	
	
	
	
}
