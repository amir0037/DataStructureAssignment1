/**
* @author  Maria Amirova (student #040980332)
* @date September 17, 2020
* @version 1.0 
* Assignment #1
*/
package assignment1;

public class Gym extends Event {

	
	Gym(){
		
	}
	Gym (int eventType, OurDate date, OurTime time, String desc){
		super(eventType, date, time, desc);}
	
	public String toString() {
		return String.format("%s|%7s|%7s|%7s|%7s|%7s|%7s|%n", 
				eventType, super.date.getDay(), super.date.getMonth(), super.date.getYear(), 
				super.time.getHour(), super.time.getMinute(), desc);
}
}
