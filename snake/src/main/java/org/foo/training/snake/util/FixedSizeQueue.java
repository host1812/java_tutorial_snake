package org.foo.training.snake.util;

import java.util.Iterator;
import java.util.LinkedList;

public class FixedSizeQueue<T> implements Iterable<T> {

	LinkedList<T> queue;

	private int maxSize;

	public FixedSizeQueue(int maxSize) {
		this.maxSize = maxSize;
		queue = new LinkedList<T>();
	}

	public Iterator<T> iterator() {
		return queue.iterator();
	}

	public int getMaxSize() {
		return maxSize;
	}

	// Update the size when we call 'grow' on the snake. Grow size can very
	public void incrementSizeBy(int size) {
		this.maxSize += size;
	}

	public boolean contains(T t) {
		return queue.contains(t);
	}

	public void add(T t) {
		if (queue.size() == getMaxSize()) {
			queue.removeFirst();
		}
		queue.add(t);
	}

	public T getFirst() {
		return queue.getFirst();
	}

	public T getLast() {
		return queue.getLast();
	}
}
