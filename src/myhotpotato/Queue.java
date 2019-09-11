package myhotpotato;

import java.util.ArrayList;

public class Queue<E> {

	ArrayList<E> playerQueue;
	
	public Queue() {
		playerQueue = new ArrayList<E>();
			
	}
	
	public void enqueue(E element) {
		playerQueue.add(element);
	}
	
	public E dequeue() {
		E player;
		player = playerQueue.remove(0);
		return player;
		
	}
	
	public E dequeueBefore(int param) {
		E player;
		player = playerQueue.remove(param);
		return player;
	}
	
	public E takeFirst() {
		E player = null;
		try {
		int index = playerQueue.size();
		player = playerQueue.remove(index - 1);
		return player;
		}catch(Exception e){
			System.out.println("Error: Queue is empty");
		}
		return null;
	}
	
	public E peek() {
		boolean empty = isEmpty();
		if(!empty) {
			int index = playerQueue.size() - 1;
			E newValue = playerQueue.get(index);
			return newValue;
		}
		return null;
	}
	
	public boolean isEmpty() {
		int size = playerQueue.size();
		if(size == 0) {
			return true;
		}
		return false;
	}
	
	public boolean isOnePlayer() {
		int size = playerQueue.size();
		if(size == 1) {
			return true;
		}
		return false;
	}
	
	public void clear() {
		playerQueue.clear();
	}
	public int getSize() {
		int size = playerQueue.size();
		return size;
	}

	public E getValue(int i) {
		E value = playerQueue.get(i);
		return value;
	}
}
