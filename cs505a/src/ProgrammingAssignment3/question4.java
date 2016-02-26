// Author: <Yanxin Jia>
// Date: <11/30/2014>
// Submitted for: 4>
// Course: CS505A
// Semester: Fall 2014

package ProgrammingAssignment3;

import java.util.Random;

public class question4 {
	public static void main(String[] args) {

		System.out.println("\nOutput for question 4:");
		int[] vals2 = new int[100];
		Random r = new Random();
		for (int i = 0; i < vals2.length; i = i + 1)
			vals2[i] = r.nextInt(200);
		for (int i = 0; i < 30; i = i + 1) {
			int result = linearSearch(i, vals2, vals2.length);
			if (result < 0)
				System.out.println("Did not find search value " + i);
			else
				System.out.println("Found search value " + i + " at index "
						+ result);
		}
	}

	private static int linearSearch(int i, int[] vals2, int length) {
		int result = 0;
		for (int n = 0; n < length; n++)
			if (i == vals2[n]) {
				result = n;
			} else {
				result = -1;
			}
		return result;
	}

}