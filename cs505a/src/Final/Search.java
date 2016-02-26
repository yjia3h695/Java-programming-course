package Final;

public class Search {

	int X(double y, double w, double[] z) {
		int i = 0;
		boolean a = false;
		int b = -1;
		while (i < z.length && !a) {
			if (z[i] < y / w) {
				a = true;
				b = i;
			}
			i = i + 1;
		}
		return b;
	}
}