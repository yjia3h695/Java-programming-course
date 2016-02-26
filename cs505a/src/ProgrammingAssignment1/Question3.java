// Author: <Yanxin Jia>
// Date: <11/03/2014>
// Submitted for: 3>
// Course: CS505A
// Semester: Fall 2014

package ProgrammingAssignment1;

import java.util.Scanner;

public class Question3 {
	public static void main(String[] args) {
		System.out.println("Please input a interger, input 9999 to exit");
		int sentinel = 9999;
		int lower = 0;
		int upper = 100;
		int sum = 0;
		float runningTotal = 0;
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		while (number != sentinel) {
			if (number >= lower && number <= upper) {
				sum = sum + number;
				runningTotal++;
				number = scan.nextInt();
			} else {
				sum = sum + 0;
				runningTotal = runningTotal + 0;
				number = scan.nextInt();
			}
			if (number == sentinel)
				break;

		}
		float average = sum / runningTotal;
		System.out.println("The average of values in the range zero through one hundred is: "+ average);
	}
}
