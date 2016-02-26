// Author: <Yanxin Jia>
// Date: <11/30/2014>
// Submitted for: 3>
// Course: CS505A
// Semester: Fall 2014

package ProgrammingAssignment3;

public class question3 {
	public static void main(String[] args) {
		System.out.println("\nOutput for question 3:");
		int[] vals = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130,
				140, 150 };
		int low = 30;
		int high = 90;
		System.out.println("There were " + count(low, high, vals)
				+ " values between " + low + " and " + high);
		low = 50;
		high = 50;
		System.out.println("There were " + count(low, high, vals)
				+ " values between " + low + " and " + high);

	}

	private static int count(int low, int high, int[] vals) {
		int cot = 0;
		for (int i = 0; i < vals.length; i++)
			if (vals[i] <= high && vals[i] >= low) {
				cot = cot + 1;
			}
		return cot;
	}
}