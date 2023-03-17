import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import OOP.Mydate;

public class Main {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        System.out.print("Enter month: ");
        int month = scanner.nextInt();
        System.out.print("Enter day: ");
        int day = scanner.nextInt();
        
        Mydate date = new Mydate(year, month, day);
        System.out.println("Date: " + date.toString());
        
        System.out.println("Next day: " + date.nextDay().toString());
        System.out.println("Next month: " + date.nextMonth().toString());
        System.out.println("Next ỷear: " + date.nextYear().toString());
        System.out.println("Previous day: " + date.previousDay().toString());
        System.out.println("Previous month: " + date.previousMonth().toString());
        System.out.println("Previous year: " + date.previousYear().toString());
        scanner.close();
	}

}
