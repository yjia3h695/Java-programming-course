package hw6;

import java.util.Vector;

public class Stack<T> {
	private Vector<T> stack;
	private int top = 0;

	public Stack() {
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
		T temp = stack.get(top);
		stack.remove(top);
		top--;
		return temp;
	}

	public int size() {
		return top;
	}
}
