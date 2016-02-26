package hw5;

import java.io.*;

public class as1 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile randomfile = new RandomAccessFile("test.txt", "rw");
		for (int i = 1; i <= 100; i++) {
			randomfile.writeInt(i);
		}
		randomfile.seek(0);
		System.out.println("Ordered sequence of integers:");
		for (int i = 0; i < 100; i++) {
			System.out.println(randomfile.readInt());
		}
		randomfile.close();
	}
}