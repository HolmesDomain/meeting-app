import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class schedule implements calendar{	
	int startd;
	int startm;
	int starty;
	int endd;
	int endm;
	int endy;
	int meetings;
	String dow;
	
	public schedule() {}
	
	private static final String COMMA_DELIMITER = ",";
	
	public static void main(String[] args) throws IOException{
		//Object created; used for BufferedReader 
		List<List<String>> records = new ArrayList<>();		
		//Instantiate 2 schedule objects
		schedule a = new schedule();
		schedule b = new schedule();
		
		try (BufferedReader br = new BufferedReader(new FileReader("./input.csv"))) {
		    // StringTokenizer?
			String line;
		    skipheader(br);
		    //Add read and save from CSV to object
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(COMMA_DELIMITER);
		        records.add(Arrays.asList(values));       
		    }
		    //Save data into single string variable to parse through 
	        //String: [[2018-05-02,  2018-12-31,  Wednesday], [2019-01-01,  2019-12-31,  Thursday]]
	        String startdate = records.toString();
	        
	        /*
	         * 
	         * Not practical if the data in the .CSV file changes at all.
	         * 
	         */
	        
	        //Add integers to the static schedule object - a
	        a.starty = Integer.parseInt(startdate.substring(2,6));
	        a.startm = Integer.parseInt(startdate.substring(7,9));
	        a.startd = Integer.parseInt(startdate.substring(10,12));
	        a.endy = Integer.parseInt(startdate.substring(15,19));
	        a.endm = Integer.parseInt(startdate.substring(20,22));
	        a.endd = Integer.parseInt(startdate.substring(23,25));
	        a.dow = startdate.substring(27,37);
	        //Add integers to the static schedule object - a
	        b.starty = Integer.parseInt(startdate.substring(41,45));
	        b.startm = Integer.parseInt(startdate.substring(46,48));
	        b.startd = Integer.parseInt(startdate.substring(49,51));
	        b.endy = Integer.parseInt(startdate.substring(54,58));
	        b.endm = Integer.parseInt(startdate.substring(59,61));
	        b.endd = Integer.parseInt(startdate.substring(62,64));
	        b.dow = startdate.substring(66,75);
	        //
			a.meetings = (int) a.meetingsLeft(a.startd,a.startm);
			b.meetings = (int) b.meetingsLeft(b.startd,b.startm);
			
			output(a,b);
		}
	}
	//Output Method/Function
	static void output(schedule a, schedule b) {
		System.out.println("There are " + a.meetings + " meeting occurances on" + a.dow + " with the schedule date entered: " + a.starty + '/' + a.startm + '/' + a.startd + " to " + a.endy + '/' + a.endm + '/' + a.endd + " ");
		System.out.println("There are " + b.meetings + " meeting occurances on" + b.dow + " with the schedule date entered: " + b.starty + '/' + b.startm + '/' + b.startd + " to " + b.endy + '/' + b.endm + '/' + b.endd + " ");
		moreMeetings(a,b);
	}
	//Skip header of CSV
	static void skipheader(BufferedReader br) throws IOException {
	    //Skip the header of the file ##
	    br.readLine();
	    br.readLine(); 
	}	
	//Find the elapsed days for the month
	public int findMonth(int m) {		
		int elapsed = 0;
		
		if(m == 1) {
			elapsed = jan;
		}
		if(m == 2) {
			elapsed = feb;
		}
		if(m == 3) {
			elapsed = mar;
		}
		if(m == 4) {
			elapsed = apr;
		}
		if(m == 5) {
			elapsed = may;
		}
		if(m == 6) {
			elapsed = jun;
		}
		if(m == 7) {
			elapsed = jul;
		}
		if(m == 8) {
			elapsed = aug;
		}
		if(m == 9) {
			elapsed = sep;
		}
		if(m == 10) {
			elapsed = oct;
		}
		if(m == 11) {
			elapsed = nov;
		}
		if(m == 12) {
			elapsed = dec;
		}

		return elapsed;
	}
	//Calculate Weeks 
	public double meetingsLeft(int day, int monthday) {
		return Math.floor((year(false) - (findMonth(monthday) + day)) /7);
	}
	//If true subtract 10 days from year calendar
	static int year(boolean x) {
		int days = 365;
		
		if (x == true) {
			 days = 365 - 10;
			 return days;
		}
		else
			return days;
	}
	//function to decide which schedule has more meeting occurances
	static void moreMeetings(schedule a,schedule b) {		
		if(a.meetings - b.meetings > 0)		
			System.out.print("Meetings on" + a.dow + " have more occurances");		
		else
			System.out.print("Meetings on" + b.dow + " have more occurances");
	}
}
