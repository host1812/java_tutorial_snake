package org.foo.training.snake.core;

import org.junit.Test;
import static org.junit.Assert.*;

public class LevelTest {
	
	@Test
	public void initFieldShouldCreateFieldWithCorrectBoundaries () {
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
	public void initFieldShouldInitializeCorrectCoordinates () {
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
}
