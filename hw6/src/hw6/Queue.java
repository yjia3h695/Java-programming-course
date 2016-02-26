package hw6;

import java.util.Vector;

public class Queue<T> {
	private Vector<T> stack;
	private int top = 0;
	private int bottom = 0;

	public Queue() {
		stack = new Vector<T>();
	}

	public void push(T object) {
		stack.add(object);
		top++;
	}

	public T pop() {
		if (top == 0) {
			return null;
		}
		T temp = stack.get(bottom);
		stack.remove(bottom);
		bottom++;
		return temp;
	}

	public int size() {
		return top - bottom;
	}
}
