import java.util.*;

public class test {

	public static void main(String[] args) {
		double area, perimeter;

		// This instance of Rectangle, called rec1, uses the default
		// constructor for our class, thus it sets width and height
		// to 1.0
		Rectangle rec1 = new Rectangle();

		// This instance of Rectangle, called rec2, uses the second
		// constructor from our class it sets the width to 2.3 and the
		// height to 1.3
		Rectangle rec2 = new Rectangle(2.3, 1.3);

		Scanner keyboard = new Scanner(System.in);

		// This asks the user to enter a double for the width of rec1
		// and sets rec1's width equal to the input by using the setWidth()
		// method
		System.out.println("Enter the width for rec1:");
		rec1.setWidth(keyboard.nextDouble());

		// This asks the user to enter a double for the height of rec1
		// and sets rec1's height equal to the input by using the setHeight()
		// method
		System.out.println("Enter the height for rec1:");
		rec1.setHeight(keyboard.nextDouble());

		// Now that the width and height have been set in rec1 were going to
		// calculate the area
		// and Perimeter of that Rectangle object.
		area = rec1.getArea();
		perimeter = rec1.getPerimeter();

		System.out.println("The area for rec1 is: " + area);
		System.out.println("The pereimeter for rec1 is: " + perimeter);

		// We can do the same thing with rec2 and get different results since
		// they are different
		// Rectangle objects and hold different data.
		System.out.println("The area for rec2 is: " + rec2.getArea());
		System.out
				.println("The pereimeter for rec2 is: " + rec2.getPerimeter());

		// Prints out the number of Rectangle instances in the current program.
		System.out.println("There are " + Rectangle.getInstances()
				+ " instances of the Rectangle class.");
	}
}
