package assignment1;

public class School extends Event {

	School(){
		
	}
	School (int eventType, OurDate date, OurTime time, String desc){
		super(eventType, date, time, desc);
		
	}

	
	public String toString() {
		return String.format("%s|%7s|%7s|%7s|%7s|%7s|%7s|%n", 
				eventType, super.date.getDay(), super.date.getMonth(), super.date.getYear(), 
				super.time.getHour(), super.time.getMinute(), desc);
}
}
