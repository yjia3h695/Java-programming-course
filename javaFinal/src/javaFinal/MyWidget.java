package javaFinal;

public class MyWidget implements IEventListener {

	public void onEvent() {
		System.out.println("The Event Occurred");
	}

	public static void main(String[] args) {
		MyWidget w = new MyWidget();
		w.onEvent();
	}
}
