/**
* @author  Maria Amirova (student #040980332)
* @date September 17, 2020
* @version 1.0 
* Assignment #1
*/
package assignment1;

import java.util.Scanner;

public class Assignment1 {

	
	public static void main(String[] args) {
		Planner p = new Planner();
		Scanner scan = new Scanner(System.in);
		int choice1=0;
		System.out.println("====================\nEVENTS PLANNER\n====================");
		while (choice1 != 8) {
			System.out.println(
				"\n1. Add an event from keyboard \n" + 
				"2. Display events of a day\n" + 
				"3. Display events of a week\n" + 
				"4. Display events of a month\n" + 
				"5. Delete an event\n" + 
				"6. Add events from a file\n" + 
				"7. Display all events\n" +
				"8. Quit\n"+
				"Enter your option: ");
		
		choice1 = scan.nextInt();
		switch(choice1) {
		 
		case 1:
			
			p.addEvent(scan);
			break;
	
		case 2:
			if (p.getEvents().isEmpty()){System.out.print("\nThere are no events added yet\n");
			}
			else {
			OurDate date = new OurDate();
			date.readDate(scan);
			p.displayEventsDaily(date);}
			break;
			
		case 3:		
			if (p.getEvents().isEmpty()){System.out.print("\nThere are no events added yet\n");
			}
			else {
			OurDate date1 = new OurDate();
			date1.readDate(scan);
			p.displayEventsWeekly(date1);}
			break;
						
		case 4:
			if (p.getEvents().isEmpty()){System.out.print("\nThere are no events added yet\n");
			}
			else {
			System.out.print("Enter month");
			int month=scan.nextInt();
			p.displayEventsMonthly(month);}
			break;
			
		case 5:
			if (p.getEvents().isEmpty()){System.out.print("\nThere are no events added yet\n");
			}
			else {
			OurDate myDate = new OurDate();
			OurTime myTime = new OurTime();
			myDate.readDate(scan);
			myTime.readTime(scan);
			
			p.deleteEvent(myDate, myTime);}
			break;
			
		case 6:
			p.readEventsFromFile();
			break;
			
		case 7:	
			if (p.getEvents().isEmpty()){System.out.print("\nThere are no events added yet\n");
			}
			else {
			p.displayAllEvents();}
			break;
						
		case 8:
			System.out.println("Good bye");
			break;
			
		default:
			System.out.println("Sorry, wrong choice. Please choose a number from 1 to 8");
			break;
		}}
		
	}


	}

