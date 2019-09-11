package myhotpotato;

import java.util.ArrayList;

public class Stack<E> {

	ArrayList<E> playersOutStack;
	
	public Stack() {
		playersOutStack = new ArrayList<E>();
	}
	
	public void push(E element) {
		playersOutStack.add(element);
	}
	
	public E pop() {
		int index = playersOutStack.size();
		return playersOutStack.remove(index - 1);
	}
	
	public E peek() {
		boolean empty = isEmpty();
		if(!empty) {
			int index = playersOutStack.size() - 1;
			E newValue = playersOutStack.get(index);
			return newValue;
		}
		return null;
	}
	
	public boolean isEmpty() {
		int size = playersOutStack.size();
		if(size == 0) {
			return true;
		}
		return false;
	}
	
	public void clear() {
		playersOutStack.clear();
	}
}
