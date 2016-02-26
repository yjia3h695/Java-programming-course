// Author: <Yanxin Jia>
// Date: <11/30/2014>
// Submitted for: 1>
// Course: CS505A
// Semester: Fall 2014

package ProgrammingAssignment3;

public class question1 {
	public static void main(String[] args) {
		System.out.println("Output for question 1");
		int numVals = 0;
		int[] myArray = new int[5];
		for (int i = 0; i < 7; i = i + 1) {
			if (insert(i + 1, 0, numVals, myArray)) {
				numVals = numVals + 1;
				System.out.println("Inserted value " + (i + 1)
						+ " at index 0 in array with " + (numVals - 1)
						+ " values.\n");
			} else {
				System.out.println("Could not insert value " + (i + 1)
						+ " at index 0 as the array was full");
			}
		}
		for (int i = 0; i < myArray.length; i = i + 1)
			System.out.println("List element " + (i + 1) + " is " + myArray[i]);
	}

	private static boolean insert(int V, int I, int C, int[] A) {
		if (C < A.length) {
			return true;
		} else {

			return false;
		}
	}
}