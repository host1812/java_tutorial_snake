package org.foo.training.snake.util;

import java.util.LinkedList;

public class FixedSizeQueue<E> extends LinkedList<E> {
	
	/**
	 * Don't ask.. it appears LinkedList is serializable...
	 */
	private static final long serialVersionUID = 6681061903910663309L;
	
	private int size = super.size(); 
	
	public FixedSizeQueue(E e) { 
		super.add(e);
	}
	
	// Update the size when we call 'grow' on the snake
	public void incrementSize(int size) {
		this.size += size;
	}
	
	@Override
	public boolean add(E e) {
		if ( super.size() == this.size ) {
			super.removeFirst();
		}
		super.add(e);
		return true;
	}
}
