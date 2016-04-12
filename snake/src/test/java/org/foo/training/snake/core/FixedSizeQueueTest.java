package org.foo.training.snake.core;

import org.junit.Test;
import static org.junit.Assert.*;

import org.foo.training.snake.util.FixedSizeQueue;

public class FixedSizeQueueTest {
	
	@Test
	public void fixedSizeQueueShouldBeAddingElementsTillMax() {
		FixedSizeQueue<String> result = new FixedSizeQueue<String>(2);
		result.add("One");
		result.add("Two");
		
		assertEquals(2,result.getMaxSize());
		assertEquals("One",result.getFirst());
		assertEquals("Two",result.getLast());
	}
	
	@Test
	public void fixedSizeQueueShouldBeRemovingFistElementIfMaxSizeReached() {
		FixedSizeQueue<String> result = new FixedSizeQueue<String>(2);
		result.add("One");
		result.add("Two");
		result.add("Three");
		
		assertEquals("Two",result.getFirst());
		assertEquals("Three",result.getLast());
	}
	
	@Test
	public void fixedSizeQueueShouldShouldStartAddingElementsAgainOnceMaxSizeIncresed() {
		FixedSizeQueue<String> result = new FixedSizeQueue<String>(2);
		result.add("One");
		result.add("Two");
		result.add("Three");
		result.incrementSizeBy(1);
		result.add("Four");
		
		assertEquals("Two",result.getFirst());
		assertEquals("Four",result.getLast());
	}
	
	
}
