package org.foo.training.snake.core;

import org.junit.Test;
import static org.junit.Assert.*;

public class LevelTest {
	
	@Test
	public void shouldCreateFieldWithCorrectBoundaries () {
		Level level = new Level();
		int min = 10;
		int max = 30;
		Point[][] result = level.getField();
		int width = result.length;
		int height = result[0].length;
		
		assertTrue(width>=min && width<=max);
		assertTrue(height>=min && height<=max);		
	}
	
	@Test
	public void shouldCreateFieldWithCustomBoundaries () {
		Level level = new Level(161,387);
		Point[][] result = level.getField();
		int width = result.length;
		int height = result[0].length;
		
		assertTrue(width == 161);
		assertTrue(height == 387);		
	}
	
	@Test
	public void shouldInitializeCorrectCoordinates () {
		Level level = new Level();
		Point[][] result = level.getField();
		int width = result.length;
		int height = result[0].length;
		
		for (int i=0;i<width;i++) {
			for (int j=0;j<height;j++) {
				Point point = result[i][j];
				assertEquals(i,point.x);
				assertEquals(i,point.x);
			}
		}	
	}
	
	@Test
	public void isWithinBoundariesWorks() {
		Level level = new Level(2,2);
		Point point1 = new Point(1,1);
		Point point2 = new Point(2,2);
		Point point3 = new Point(-1,-1);
		Point point4 = new Point(5,6);
		
		assertTrue(level.isWithinBoundaries(point1));
		assertFalse(level.isWithinBoundaries(point2));
		assertFalse(level.isWithinBoundaries(point3));
		assertFalse(level.isWithinBoundaries(point4));	
	}
}
