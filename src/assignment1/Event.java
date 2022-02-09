package assignment1;

import java.util.Scanner;

public class Event {
		
	protected int eventType;
	protected String desc;
	protected OurDate date;
	protected OurTime time;
	
	Event(){
		
	}
	Event(int eventType, OurDate date, OurTime time, String desc) {
		this.eventType=eventType;
		this.date = date;
		this.time = time;
		this.desc = desc;
	}
	
	public String toString() {
		
		return String.format("%s|%7s|%7s|%7s|%7s|%7s|%20s|%12s|%7s%n", 
				eventType, date.getDay(), date.getMonth(), date.getYear(), time.getHour(), time.getMinute(), desc);
	}
	
	public void readInfo(Scanner input) {
		System.out.print("Enter desc \n");
		this.desc=input.next();
	}
	
	public boolean isEqual (Event e) {
		return true;
		}
		
	public boolean isGreater (Event e) {
			return true;
		}
	
	public void readInfoFromFile(Scanner input) {
		
	}
	public OurDate getDate() {
		return date;
	}
	public void setDate(OurDate date) {
		this.date = date;
	}
	
	
	
	
	
	
}
