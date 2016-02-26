package memory_disk.tryout;

import memory_disk.PageReferenceGenerator;
import memory_disk.PageReferenceGeneratorFile;

public class TryPageReferenceGeneratorFile {

	public static void main(String[] args) {
		PageReferenceGenerator prg = new PageReferenceGeneratorFile("tex.din", 12);
		for(int x : prg) {
			System.out.println(x);
		}
	}

}
