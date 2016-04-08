package org.foo.training.snake.core;

import org.foo.training.snake.util.Direction;
import org.foo.training.snake.util.LethalMoveException;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.util.List;

public class SnakeTest {
	
	@Test
	public void createDefaultSnake() {
		Level level = Mockito.mock(Level.class);
		Snake snake = new Snake(3, level);
		List<Point> result = snake.getSnake();
		
		assertTrue(1 == result.get(0).x && 1 == result.get(0).y);
		assertTrue(2 == result.get(1).x && 1 == result.get(1).y);
		assertTrue(3 == result.get(2).x && 1 == result.get(2).y);
	}
	
	@Test
	public void snakeMovesWithoutGrowing() throws LethalMoveException {
		Level level = Mockito.mock(Level.class);
		when(
				level.isWithinBoundaries(any(Point.class))
			).thenReturn(true);
		
		Snake snake = new Snake(3, level);
		snake.setDirection(Direction.RIGHT);
		snake.move();
		List<Point> result = snake.getSnake();
		
		assertTrue(2 == result.get(0).x && 1 == result.get(0).y);
		assertTrue(3 == result.get(1).x && 1 == result.get(1).y);
		assertTrue(4 == result.get(2).x && 1 == result.get(2).y);
	}
	
	@Test
	public void snakeMovesWithGrowing() throws LethalMoveException {
		Level level = Mockito.mock(Level.class);
		when(
				level.isWithinBoundaries(any(Point.class))
			).thenReturn(true);
		
		Snake snake = new Snake(3, level);
		List<Point> result = snake.getSnake();
		
		assertTrue(result.size() == 3);
		
		snake.setDirection(Direction.RIGHT);
		snake.setGrow(1);
		snake.move();
		result = snake.getSnake();
		
		assertTrue(result.size() == 4);
		assertTrue(1 == result.get(0).x && 1 == result.get(0).y);
		assertTrue(2 == result.get(1).x && 1 == result.get(1).y);
		assertTrue(3 == result.get(2).x && 1 == result.get(2).y);
		assertTrue(4 == result.get(3).x && 1 == result.get(3).y);
	}
	
	@Test(expected = LethalMoveException.class)
	public void snakeLethalMoveLevelBoundaries() throws LethalMoveException {
		Level level = Mockito.mock(Level.class);
		when(
				level.isWithinBoundaries(any(Point.class))
			).thenReturn(false);
		
		Snake snake = new Snake(3, level);
		snake.setDirection(Direction.RIGHT);
		snake.move();
	}
	
	@Test(expected = LethalMoveException.class)
	public void snakeLethalMoveCollidesItself() throws LethalMoveException {
		Level level = Mockito.mock(Level.class);
		when(
				level.isWithinBoundaries(any(Point.class))
			).thenReturn(true);
		
		Snake snake = new Snake(3, level);
		snake.setGrow(2);
		snake.setDirection(Direction.RIGHT);
		snake.move();
		snake.move();
		
		List<Point> result = snake.getSnake();
		
		assertTrue(1 == result.get(0).x && 1 == result.get(0).y);
		assertTrue(5 == result.get(4).x && 1 == result.get(4).y);
		
		snake.setDirection(Direction.DOWN);
		snake.move();
		
		result = snake.getSnake();
		assertTrue(2 == result.get(0).x && 1 == result.get(0).y);
		assertTrue(5 == result.get(4).x && 2 == result.get(4).y);
		
		snake.setDirection(Direction.LEFT);
		snake.move();
		
		result = snake.getSnake();
		assertTrue(3 == result.get(0).x && 1 == result.get(0).y);
		assertTrue(4 == result.get(4).x && 2 == result.get(4).y);
		
		snake.setDirection(Direction.UP);
		snake.move();
		
		result = snake.getSnake();
	}
	
}
	