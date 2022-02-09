package assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Planner {

	private ArrayList<Event> events = new ArrayList<>();
	
	
	public ArrayList<Event> getEvents() {
		return events;
	}

	Planner(){}
	
	public static void printTitle() {
		String eType="Type";
		 String eMonth="Month";
		 String eDay="Day";
		 String eYear="Year";
		 String eHour="Hour";
		 String eMinute="Minute";
		 String eDesc="Description";
		 String eLoc="Location";
		 String eHours="Hours";
		
		System.out.printf("%s|%7s|%7s|%7s|%7s|%7s|%20s|%12s|%7s%n", 
				eType, eMonth, eDay, eYear, eHour, eMinute, eDesc, eLoc, eHours);
		System.out.println("======================================================================================");
	}
	
	public void displayAllEvents() {
		printTitle();
		System.out.print(events.toString());
	}
	
	
	public void displayEventsDaily(OurDate date) {
		printTitle();
		for(int i=0; i<events.size();i++) {
			if (date.isEqual(events.get(i).date)) {
				System.out.print(events.get(i).toString());}
			}
	}
	
	
	public void displayEventsWeekly(OurDate date) {

	}
	
	public void deleteEvent(OurDate myDate, OurTime myTime) {
	
		for(int i=0; i<events.size();i++) {
			if (myDate.isEqual(events.get(i).date) && myTime.isEqual(events.get(i).time)) {events.remove(i);}

		}
	}
	
	public void displayEventsMonthly(int month) {
		printTitle();
		for(int i=0; i<events.size();i++) {
			if (month==(events.get(i).date.getMonth()))
				System.out.print(events.get(i).toString());
		}
	}
	
	public int binarySearch(Event temp) {
		return 0;
	}
	
	public int findPosition(Event e) {
		
		return 0;
	}
	
	public void addEvent(Scanner input) {
		
		Event event = null;
		System.out.println("1. Meeting\r\n"
				+ "2. School\r\n"
				+ "3. Work\r\n"
				+ "4. Gym\r\n"
				+ "5. Social"
				+ "Enter type of event: ");
	int choice = input.nextInt();
	int eventType = choice;
	OurDate date = new OurDate();
	OurTime time = new OurTime();
	
	switch(choice) {
	
	case 1:
		date.readDate(input);
		time.readTime(input);
		event = new Meeting(eventType,date, time, null, null);
		event.readInfo(input);
		findPosition(event);
		events.add(event);
		break;	
		
	case 2:
		date.readDate(input);
		time.readTime(input);
		event = new School(eventType, date, time, null);
		event.readInfo(input);
		events.add(event);
		break;	
		
	case 3:
		date.readDate(input);
		time.readTime(input);
		event = new Work(eventType, date, time, null, null, 0);
		event.readInfo(input);
		events.add(event);
		break;
		
	case 4:
		date.readDate(input);
		time.readTime(input);
		event = new Gym(eventType, date, time, null);
		event.readInfo(input);
		events.add(event);
		break;
		
	case 5:
		date.readDate(input);
		time.readTime(input);
		event = new Social(eventType, date, time, null);
		event.readInfo(input);
		events.add(event);
		break;
		
	}
	
	}
	
		
	public void readEventsFromFile() {
		printTitle();
		int eType;
		int eMonth;
		int eDay;
		int eYear;
		int eHour;
		int eMinute;
		String eDesc;
		String eLoc = null;
		int eHours = 0;
		try {
			File file = new File("Events.txt");
			Scanner scan = new Scanner(file);

			while(scan.hasNextLine()) {
				
				String str = scan.nextLine();
				ArrayList<String> wrds= new ArrayList<String>(Arrays.asList(str.split(" ")));
				
				 eType=Integer.parseInt(wrds.get(0));
				 eMonth=Integer.parseInt(wrds.get(1));
				 eDay=Integer.parseInt(wrds.get(2));
				 eYear=Integer.parseInt(wrds.get(3));
				 eHour=Integer.parseInt(wrds.get(4));
				 eMinute=Integer.parseInt(wrds.get(5));
				 eDesc=wrds.get(6);
			
				
			switch(eType) {
				case 1: 
					eLoc=wrds.get(7);
					eHours=0;
					break;
				case 2:
					eLoc="";
					eHours=0;
					break;
				case 3:
					eLoc=wrds.get(7);
					eHours=Integer.parseInt(wrds.get(8));
					
					break;
				case 4:
					eLoc="";
					eHours=0;
					break;
				case 5:
					eLoc="";
					eHours=0;
					break;
			}
			switch(eType) {
			case 1: 
				System.out.printf("%4d|%7d|%7d|%7d|%7d|%7d|%20s|%12s|%n", 
						eType, eMonth, eDay, eYear, eHour, eMinute, eDesc, eLoc);
				Meeting eventM = new Meeting(eType, new OurDate(eDay, eMonth, eYear), new OurTime(eHour, eMinute), eDesc, eLoc);
				events.add(eventM);
				break;
			case 2:
				System.out.printf("%4d|%7d|%7d|%7d|%7d|%7d|%20s|%n", 
						eType, eMonth, eDay, eYear, eHour, eMinute, eDesc);
				School eventS = new School(eType,new OurDate(eDay, eMonth, eYear), new OurTime(eHour, eMinute), eDesc);
				events.add(eventS);
				break;
			case 3:
				System.out.printf("%4d|%7d|%7d|%7d|%7d|%7d|%20s|%12s|%7d%n", 
						eType, eMonth, eDay, eYear, eHour, eMinute, eDesc, eLoc, eHours);
				Work eventW = new Work(eType,new OurDate(eDay, eMonth, eYear), new OurTime(eHour, eMinute), eDesc, eLoc, eHours);
				events.add(eventW);
				break;
			case 4:
				System.out.printf("%4d|%7d|%7d|%7d|%7d|%7d|%20s|%n", 
						eType, eMonth, eDay, eYear, eHour, eMinute, eDesc);
				Gym eventG = new Gym(eType,new OurDate(eDay, eMonth, eYear), new OurTime(eHour, eMinute), eDesc);
				events.add(eventG);
				break;
			case 5:
				System.out.printf("%4d|%7d|%7d|%7d|%7d|%7d|%20s|%n", 
						eType, eMonth, eDay, eYear, eHour, eMinute, eDesc);
				Social eventSc = new Social(eType,new OurDate(eDay, eMonth, eYear), new OurTime(eHour, eMinute), eDesc);
				events.add(eventSc);
				break;
		}
			}
			}catch(FileNotFoundException ex) {System.out.print("There is no file found");}
	}
	}
	

