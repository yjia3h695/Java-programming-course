package memory_disk.tryout;

import memory_disk.PageReferenceGeneratorRandom;

public class TryPageRefGen {

	public static void main(String[] args) {
		try3();
	}
	
	public static void try1() {
		PageReferenceGeneratorRandom prg = new PageReferenceGeneratorRandom(10, 5, 1, 1, 12, 30, 2);
		for(int p : prg) {
			System.out.print(p + " ");
		}
		System.out.println();
	}
	
	public static void try2() {
		PageReferenceGeneratorRandom prg = new PageReferenceGeneratorRandom(10, 5, 1, 1, 12, 30, 2);
		while(prg.hasNext()) {
			System.out.print(prg.next()+ " ");
		}
		System.out.println();
	}
	
	public static void try3() {
		PageReferenceGeneratorRandom prg = new PageReferenceGeneratorRandom(10, 5, 1, 1, 12, 300, 2);
		int perLine = 25;
		int count = 0;
		for(int p : prg) {
			System.out.printf("%2d ", p);
			count++;
			if(count >= perLine) {
				System.out.println();
				count = 0;
			}
		}
		System.out.println();
	}
}
