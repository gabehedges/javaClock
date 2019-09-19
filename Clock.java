/**
 * A simple class used to demonstrate the implemenation of Java classes.
 *
 * @author Gabriel Hedges.127 with Max Alter
 * @version 8/26/19
 */
//
import java.util.Scanner; 
public class Clock {
    private int hour;
    private int minute;
    private int second;
    private boolean am;
    private int month;
    private int day;
    private int year;
    

    /**
     * Simple no-argument constructor
     */
    public Clock() {
        this.hour = 1;
        this.minute = 0;
        this.second = 0;
        this.am = true;
        this.day = 1;
        this.month = 1;
        this.year = 2000;
    }
//Constructor to set TIME
    public Clock(int hour, int minute, int second, boolean am) {
        this.day = 1;
        this.month = 0;
        this.year = 2000;
    	Scanner keyboard = new Scanner(System.in);
    	
    	boolean valid = setTime(hour,minute,second,am); // Calls setTime method
    	while (!valid) { //If setTime is true, a valid time was entered and this loop will not execute. If set time evaluates to false,
    					 //this loop will prompt user for valid inputs until setTime evaluates to true
    		System.out.println("Time is invalid, please enter a valid time.");
    		System.out.println("Enter the hour: ");
    		hour = keyboard.nextInt();
    		System.out.println("Enter the minute: ");
    		minute = keyboard.nextInt();
    		System.out.println("Enter the second: ");
    		second = keyboard.nextInt();
    		System.out.println("Enter 'true' if it's AM and 'false' if it's PM: ");
    		am = keyboard.nextBoolean();
    	valid = setTime(hour,minute,second,am); //Calling setTime again and setting to variable 'valid'
    	}
    } 
 
    //Constructor to set DATE
    public Clock(int day, int month, int year) {
        this.hour = 1;
        this.minute = 0;
        this.second = 0;
        this.am = true;
    	Scanner keyboard = new Scanner(System.in);
    	
    	boolean valid = setDate(day,month,year); // Calls setDate method
    	while (!valid) { //If setTime is true, a valid time was entered and this loop will not execute. If set time evaluates to false,
    					 //this loop will prompt user for valid inputs until setTime evaluates to true
    		System.out.println("Date is invalid, please enter a valid date.");
    		System.out.println("Enter the year: ");
    		year = keyboard.nextInt();
    		System.out.println("Enter the month: ");
    		month = keyboard.nextInt();
    		System.out.println("Enter the day: ");
    		day = keyboard.nextInt();

    	valid = setDate(day,month,year); //Calling setTime again and setting to variable 'valid'
    	}
    }
//takes day, month, and year values and returns 'true' if date is valid and 'false' if date is invalid    
    
    public boolean setDate(int day, int month, int year) {
        boolean validTime = true;

        if ((day > 31) || (day < 1)) { //Checking for valid day input
        	validTime = false; }
        
        else if ((month >12) || (month < 1)) { //Checking for valid month input
        	validTime = false; }
        
        else if ((year > 2019) || (year < 1)) { //Checking for valid year input
        	validTime = false; }
        
        else { //Once all inputs are valid, sets class-level variables to equal valid method-level variables
        	validTime = true;
        	this.day = day;
            this.month = month;
            this.year = year;
        }
        
        return validTime;
    }
    public void setDay(int day) {
    	this.day = day;
    }
    public void setMonth(int month) {
    	this.month = month;
    }
    public void setYear(int year) {
    	this.year = year;
    }
    /**
     * Sets the hour, minute, second of the clock and whether it is morning or
     * evening
     *
     * @param hour
     *            - set the hour to this value
     * @param minute
     *            - set the minute to this value
     * @param second
     *            - set the second to this value
     * @param am
     *            - true when the time is a morning time, false otherwise
     */
    public boolean setTime(int hour, int minute, int second, boolean am) {
        boolean validTime = true;

        if ((hour > 12) || (hour <= 0)) { //Checking for valid hour input
        	validTime = false; }
        
        else if ((minute >59) || (minute < 0)) { //Checking for valid minute input
        	validTime = false; }
        
        else if ((second > 59) || (second < 0)) { //Checking for valid second input (between 0 and 59)
        	validTime = false; }
        
        else {
        	validTime = true;
        	this.hour = hour;
            this.minute = minute;
            this.second = second;
            this.am = am; }
        
        return validTime;
    }

    /**
     *
     * @return the current hour
     */
    public int getHour() {
        return this.hour;
    }

    /**
     *
     * @return the current minute value
     */
    public int getMinute() {
        return this.minute;
    }

    /**
     *
     * @return the current second value
     */
    public int getSecond() {
        return this.second;
    }

    /**
     * @return true if the clock is showing an AM time, false otherwise
     */
    public boolean getAM() {
        return this.am;
    }

    /**
     * Advances the time stored in the clock by 1 second
     */
    public void tick() {
        // TODO Add code so that, when called, the clock is
        // incremented by 1 second.  Remember to do the right
        // thing when seconds == 60, when minutes == 60, and when
        // hours == 12
    	second++;
    	
    	//Add minute if seconds = 60
    	if (second == 60) {
    		minute++;
    		second = 0;
    	}
    	//Add an hour if minutes = 60
    	if (minute == 60) {
    		hour++;
    		minute = 0;
    	}
    	//Make hours go to 1
    	if ((hour == 13) && (minute == 0) && (second == 0)) {
    		hour = 1;
    	}
    	//Switch AM/PM
    	if ((hour == 12) && (minute == 0) && (second == 0)) {
    		am = !am;
    		
            /* YEAR
             * AND
             * DATE
             */
            if (this.day == numberOfDays(this.month)) { //If it's already the last day of the month, set day=1
            	this.day = 1;
            	if (this.month==12) { //If December, set back to January and increment the year
            		this.month=1;
            		year++;
            	} else { month++; } //It's not December, so increment the month
            	
            } else { day++; } //If it's not the last day of the month, increment the day
    	}
    	

    }

    /**
     *
     * @return the current time as a String in hh:mm:ssAM format
     */
    @Override
    public String toString() { //Returns the current date and time as a String
        String result = "";
        String day = "";
        String secondsString ="";
        String minutesString ="";
        String dayString = "";
        String monthString = "";
        String yearString = "";
        int howManyZeros;
        
        if (this.month < 10) { //Adding necessary 0's to monthString
        	monthString = ("0" + this.month);
        } else {
        	monthString = Integer.toString(this.month);
        }
        
       if (this.day < 10) { //Adding necessary 0's to dayString
    	   dayString = ("0" + this.day);
       } else {
    	   dayString = Integer.toString(this.day);
       }
       
       int yearLength = String.valueOf(this.year).length(); //length of year (1,2,3, or 4 digits)
       if (yearLength <4) { //If year doesn't have all 4 digits
    	  howManyZeros = 4 - yearLength; 
    	  while (howManyZeros >0) { //Adding 0's to the front of yearString
    		  yearString = yearString +"0";
    	  }
    	  yearString = yearString + this.year; //Adding digits of year to yearString
       } else {
    	   yearString = Integer.toString(this.year);
       }
       
       
       
        if (am) { //If morning, day=AM. else, day = PM
        	day = "AM";
        }
        else {
        	day = "PM";
        }
        if (second<10) { //Adding a '0' to seconds string if it's only one digit
        	secondsString =  ("0" + second);
        } else {
        	secondsString = (Integer.toString(second));
        }
        
        if (minute<10) { //Adding a '0' to minutes string if it's only one digit
        	minutesString =  ("0" + minute);
        } else {
        	minutesString = (Integer.toString(minute));
        }
        result = (yearString + "-" + monthString + "-" + dayString + " " + hour + ":" + minutesString + ":" + secondsString + day);


        return result;
    }
    public int militaryInt() {
    	String timeString = militaryString(); //Call militaryString method
    	String cleanString = timeString.substring(0,4); //Get hour and minute from militaryString 
    	int mInt = Integer.parseInt(cleanString); //Parse integers from the cleanString

    	
    	return mInt;
    }
    public String militaryString() {
    	String militaryTimeOutput = "";
    	String militaryHours = "";
    	String militaryMinutes ="";
    	String militarySeconds = "";
    	int hourHolder;

    	
    	if ((am) && (hour<12)) {  //If it's morning...
            if (second<10) {
            	militarySeconds =  ("0" + second);
            } else {
            	militarySeconds = (Integer.toString(second)); }
            
            if (minute<10) {
            	militaryMinutes =  ("0" + minute);
            } else {
            	militaryMinutes = (Integer.toString(minute)); }
            if (hour < 10) {
            	militaryHours = ("0" + hour);
            } else {
            	militaryHours = (Integer.toString(hour));
            }
    	} else if ((!am) && (hour == 12)){ //If it's 12PM...
    		hourHolder = hour; 
    		militaryHours = Integer.toString(hourHolder); //converting hours to string
            if (second<10) {
            	militarySeconds =  ("0" + second);
            } else {
            	militarySeconds = (Integer.toString(second)); }
            
            if (minute<10) {
            	militaryMinutes =  ("0" + minute);
            } else {
            	militaryMinutes = (Integer.toString(minute)); }
    	}
    	else if ((am) && (hour == 12)) { //If it's 12AM... 

    		militaryHours = "00";
            if (second<10) {
            	militarySeconds =  ("0" + second);
            } else {
            	militarySeconds = (Integer.toString(second)); }
            
            if (minute<10) {
            	militaryMinutes =  ("0" + minute);
            } else {
            	militaryMinutes = (Integer.toString(minute)); }	

    	}
    	else { //Every PM Time except for 12pm

    		hourHolder = hour +12; //adding 12 to get the proper military format
    		militaryHours = Integer.toString(hourHolder); //converting hours to string
            if (second<10) {
            	militarySeconds =  ("0" + second);
            } else {
            	militarySeconds = (Integer.toString(second)); }
            
            if (minute<10) {
            	militaryMinutes =  ("0" + minute);
            } else {
            	militaryMinutes = (Integer.toString(minute)); }
    	}
    	
    	militaryTimeOutput = (militaryHours +  militaryMinutes + ":" + militarySeconds);
    	return militaryTimeOutput;
    }
    
    public int numberOfDays(int month) {

    	int numberOfDays;
    	if ((month==1) || (month==3) || (month==5) || (month==7) || (month==8) || (month==10) || (month==12)) {
    		numberOfDays = 31;
    	} else if ((month==4) || (month==6) || (month==9) || (month==11)) {
    		numberOfDays = 30;
    	} else {
    		numberOfDays = 28;
    	} 
    	return numberOfDays;
    }

}
