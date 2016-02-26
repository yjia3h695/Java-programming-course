// Author: <Yanxin Jia>
// Date: <11/18/2014>
// Submitted for: 2>
// Course: CS505A
// Semester: Fall 2014

package ProgrammingAssignment2;

import java.util.*;

public class Question2 {
	public static void main(String args[]) {
		String[] names = { "James", "John", "Robert", "Michael", "William","David", "Richard", "Charles", "Joseph", "Thomas" };
		Arrays.sort(names);
		String keyname = "";
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the name to find: ");
		keyname = input.nextLine();
		for (String n : names) {
			if (n.equals(keyname))
				System.out.print(" A match was found");
		}
	}
}