// Author: <Yanxin Jia>
// Date: <11/18/2014>
// Submitted for: 3>
// Course: CS505A
// Semester: Fall 2014

package ProgrammingAssignment2;

import java.util.*;

public class arrayInsertion {
	public static void main(String args[]) {
		int[] myArray = new int[50];
		int count = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Please input 8 interger");
		for (int i = 0; i < 8; i++) {
			myArray[i] = input.nextInt();
			count++;
		}
		System.out.print("The array you have input is:");
		for (int n = 0; n < count; n++) {
			System.out.print(myArray[n] + ",");
		}
//Code for insertion portion start//
		for (int insert = count; insert >= 4; insert--) {
			myArray[insert + 1] = myArray[insert];
		}
		myArray[4] = 25;
		count++;
		System.out.print("The array after insertion is:");
		for (int n = 0; n < count; n++) {
			System.out.print(myArray[n] + ",");
		}
		//Code for deletion portion start//
		for (int del = 4; del < count; del++) {
			myArray[del] = myArray[del+1];
		}
		count--;
		System.out.print("The array after remove is:");
		for (int n = 0; n < count; n++) {
			System.out.print(myArray[n] + ",");
		}
	}
}