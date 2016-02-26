// Author: <Yanxin Jia>
// Date: <11/30/2014>
// Submitted for: 2>
// Course: CS505A
// Semester: Fall 2014

package ProgrammingAssignment3;

public class question2 {
	public static void main(String[] args) {
		System.out.println("\nOutput for question 2:");
		int[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println("The average of ");
		for (int i = 0; i < values.length; i = i + 1)
			System.out.print(values[i] + " ");
		System.out.println(" is " + average(values));
	}

	private static double average(int[] myArrays) {
		int sum = 0;
		for (int i = 0; i < myArrays.length; i++)
			sum = sum + myArrays[i];
		double aver = sum / myArrays.length;
		return aver;
	}
}