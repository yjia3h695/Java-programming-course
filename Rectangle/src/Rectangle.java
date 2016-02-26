public class Rectangle {
	// These are the fields used to store the width and height of your Rectangle
	// object.
	private double width, height;

	// This is a static field used to keep track of the number of Rectangle
	// object instances.
	private static int counter = 0;

	// Constructor for the class, used to set up all data when a
	// Rectangle object is created. This default constructor creates
	// a Rectangle object with a width and height of 1.0
	public Rectangle() {
		width = 1.0;
		height = 1.0;
		counter++;
	}

	// This is another constructor for the Rectangle class that accepts
	// two arguments that are of the type double. This is what the you
	// will use when you know what the width and height of the Rectangle
	// object is when you create it. The constructor takes w and h and
	// sets them equal to width and height respectively.
	public Rectangle(double w, double h) {
		width = w;
		height = h;
		counter++;
	}

	// This is a setter method, it is used to change the value of width
	// to whatever w is.
	public void setWidth(double w) {
		width = w;
	}

	// This is a setter method, it is used to change the value of height
	// to whatever h is.
	public void setHeight(double h) {
		height = h;
	}

	// This is a getter method, it is used to retrieve the value of width
	// at the current time.
	public double getWidth() {
		return width;
	}

	// This is a getter method, it is used to retrieve the value of height
	// at the current time.
	public double getHeight() {
		return height;
	}

	// Here is the getArea method, it uses the width and height
	// field that is stored in your rectangle object to
	// calculate the area.
	public double getArea() {
		return width * height;
	}

	// Here is the getPerimeter method, it uses the width and height
	// field that is stored in your rectangle object to
	// calculate the parameter.
	public double getPerimeter() {
		return (2 * width) + (2 * height);
	}

	// Here is a static method used to count the number of Rectangle instances
	// are currently created.
	public static int getInstances() {
		return counter;
	}
}
