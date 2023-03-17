package OOP;
import java.util.Scanner;
import java.time.DayOfWeek;
import java.time.LocalDate;
public class Mydate {
	private int year;
	private int month;
	private int day;
	
	public static String[] Months(){
		String[] m = {"Jan","Feb","Mar","Apr","May","Jun","July","Aug","Sep","Oct","Nov","Dec"};
		return m;
	}
	public static String[] Days(){
		String[] d = {"Mon","Tue","Wed","Thur","Fri","Sat","Sun"};
		return d;
	}
	public static int[] Day_In_Months(){
		int[] dim = {31,28,31,30,31,30,31,31,30,31,30,31};
		return dim;
	}
	public boolean isLeapYear(int year) {
		if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return true;
		}
		return false;
	}
	public boolean isValidDate(int year, int month, int day) {
		int[] daymax = Day_In_Months();
		if(day > 0 && day <= daymax[month - 1] && month > 0 && month <= 12 && year > 0) {
			return true;
		}
		return false;
	}
	public static String getDayOfWeek(int year, int month, int day) {
	    LocalDate date = LocalDate.of(year, month, day);
	    DayOfWeek dow = date.getDayOfWeek();
	    String dayOfWeek = dow.toString();
	    return dayOfWeek;
	}
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
	public int getDay() {
		return day;
	}
	public void setDate(int year, int month, int day) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public Mydate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}
	@Override
	public String toString() {
	    String[] months = Mydate.Months();
	    return String.format("%s %d %s %d", Mydate.getDayOfWeek(year, month, day), day, months[month - 1], year);
	}
	public Mydate nextDay() {
        int nextYear = year;
        int nextMonth = month;
        int nextDay = day + 1;
        
        if (nextDay > Day_In_Months()[month - 1]) {
            nextDay = 1;
            nextMonth++;
            if (nextMonth > 12) {
                nextMonth = 1;
                nextYear++;
            }
        }
        
        Mydate nextDate = new Mydate(nextYear, nextMonth, nextDay);
        return nextDate;
    }
	public Mydate nextMonth() {
	    int newYear = year;
	    int newMonth = month;
	    int newDay = day;
	    
	    if (newMonth == 12) {
	        newYear++;
	        newMonth = 1;
	    } else {
	        newMonth++;
	    }
	    
	    int[] daysInMonth = Day_In_Months();
	    if (newMonth == 2 && isLeapYear(newYear)) {
	        daysInMonth[1] = 29;
	    } else {
	        daysInMonth[1] = 28;
	    }
	    if (newDay > daysInMonth[newMonth - 1]) {
	        newDay = daysInMonth[newMonth - 1];
	    }
	    
	    return new Mydate(newYear, newMonth, newDay);
	}
	public Mydate nextYear() {
	    int newYear = year + 1;
	    int newMonth = month;
	    int newDay = day;
	    
	    int[] daysInMonth = Day_In_Months();
	    if (newMonth == 2 && isLeapYear(newYear)) {
	        daysInMonth[1] = 29;
	    } else {
	        daysInMonth[1] = 28;
	    }
	    if (newDay > daysInMonth[newMonth - 1]) {
	        newDay = daysInMonth[newMonth - 1];
	    }
	    
	    return new Mydate(newYear, newMonth, newDay);
	}

    public Mydate previousDay() {
        int d = this.getDay();
        int m = this.getMonth();
        int y = this.getYear();
        int[] dim = Day_In_Months();
        int lastDayPrevMonth;
        if (m == 1) { 
            lastDayPrevMonth = dim[11];
            m = 12;
            y--;
        } else { 
            lastDayPrevMonth = dim[m - 2];
            m--;
        }
        if (d == 1) { 
            d = lastDayPrevMonth;
        } else {
            d--;
        }
        return new Mydate(y, m, d);
    }

    public Mydate previousMonth() {
        int d = this.getDay();
        int m = this.getMonth();
        int y = this.getYear();
        if (m == 1) { 
            m = 12;
            y--;
        } else { 
            m--;
        }
        int[] dim = Day_In_Months();
        if (d > dim[m - 1]) { 
            d = dim[m - 1];
        }
        return new Mydate(y, m, d);
    }

    public Mydate previousYear() {
        int d = this.getDay();
        int m = this.getMonth();
        int y = this.getYear();
        if (y == 1) { 
            return new Mydate(y, m, d);
        } else { 
            y--;
        }
        return new Mydate(y, m, d);
    }
}
