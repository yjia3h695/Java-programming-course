package hw5;

import java.io.*;

public class as2 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("test.txt");
		DataInputStream in = new DataInputStream(fis);
		System.out.println("The loaded list is:");
		for (int i = 1; i <= 100; i++) {
			System.out.println(in.readInt());
		}
		in.close();

	}
}