// Author: <Yanxin Jia>
// Date: <11/30/2014>
// Submitted for: 5>
// Course: CS505A
// Semester: Fall 2014

package ProgrammingAssignment3;

import java.util.Random;

public class question5 {
	public static void main(String[] args) {

		System.out.println("\nOutput for question 5:");
		Random r1 = new Random();
		int[] vals3 = new int[10];
		for (int i = 0; i < 50; i = i + 1) {
			int index = r1.nextInt(10);
			System.out.println("Incrementing index " + index);
			incElements(index, vals3);
		}
		System.out.println("Final values in array are:");
		for (int i = 0; i < vals3.length; i = i + 1)
			System.out.print(vals3[i] + " ");
		System.out.println();
	}

	private static void incElements(int index, int[] vals3) {
		vals3[index] = vals3[index] + 1;
	}
}