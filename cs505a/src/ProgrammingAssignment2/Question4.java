// Author: <Yanxin Jia>
// Date: <11/18/2014>
// Submitted for: 4>
// Course: CS505A
// Semester: Fall 2014

package ProgrammingAssignment2;

import java.util.*;

public class Question4 {
	public static void main(String args[]) {
		String[] toSort = new String[20];
		int numVals = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Please input up to 20 words");
		for (int i = 0; i < 20; i++) {
			String nv = input.nextLine();
			int index = 0;
			boolean found = false;
			int foundPos = 0;
			while (index < numVals && found == false) {
				if (nv.compareTo(toSort[index]) < 0) {
					found = true;
					foundPos = index;
				}
				index++;
			}

			if (found = false) {
				foundPos = numVals;
			}
			for (int j = numVals-1; j >= foundPos; j--) {
				toSort[j + 1] = toSort[j];
			}
			toSort[foundPos] = nv;
			numVals++;
		}
		for (int k = 0; k < 20; k++) {
			System.out.print(toSort[k] + ",");
		}
	}
}