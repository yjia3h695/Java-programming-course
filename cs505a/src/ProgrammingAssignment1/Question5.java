// Author: <Yanxin Jia>
// Date: <11/03/2014>
// Submitted for: 5>
// Course: CS505A
// Semester: Fall 2014

package ProgrammingAssignment1;

import java.util.Scanner;

public class Question5 {
	public static void main(String[] args) {
		System.out.println("Please input a interger, input 9999 to exit");
		int sentinel = 9999;
		int lower = 0;
		int upper = 100;
		int runningTotal = 0;
		int outTotal = 0;
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		while (number != sentinel) {
			if (number >= lower && number <= upper) {
				runningTotal++;
				number = scan.nextInt();
			} else {
				outTotal = outTotal + 1;
				number = scan.nextInt();
			}
			if (number == sentinel)
				break;
		}
		System.out.println("Number of in-range values: " + runningTotal);
		System.out.println("Number of out-of-range values: " + outTotal);
	}
}
