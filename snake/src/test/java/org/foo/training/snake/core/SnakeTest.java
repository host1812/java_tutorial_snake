package org.foo.training.snake.core;

import org.foo.training.snake.util.Direction;
import org.foo.training.snake.util.LethalMoveException;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

public class SnakeTest {
	
	@Test
	public void createDefaultSnake() {
		Level level = Mockito.mock(Level.class);
		SnakeOld snakeOld = new SnakeOld(3, level);
		List<Point> result = snakeOld.getSnake();
		
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

		SnakeOld snakeOld = new SnakeOld(3, level);
		snakeOld.setDirection(Direction.RIGHT);
		snakeOld.move();
		List<Point> result = snakeOld.getSnake();
		
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

		SnakeOld snakeOld = new SnakeOld(3, level);
		List<Point> result = snakeOld.getSnake();
		
		assertTrue(result.size() == 3);

		snakeOld.setDirection(Direction.RIGHT);
		snakeOld.setGrow(1);
		snakeOld.move();
		result = snakeOld.getSnake();
		
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

		SnakeOld snakeOld = new SnakeOld(3, level);
		snakeOld.setDirection(Direction.RIGHT);
		snakeOld.move();
	}
	
	@Test(expected = LethalMoveException.class)
	public void snakeLethalMoveCollidesItself() throws LethalMoveException {
		Level level = Mockito.mock(Level.class);
		when(
				level.isWithinBoundaries(any(Point.class))
			).thenReturn(true);

		SnakeOld snakeOld = new SnakeOld(3, level);
		snakeOld.setGrow(2);
		snakeOld.setDirection(Direction.RIGHT);
		snakeOld.move();
		snakeOld.move();

		List<Point> result = snakeOld.getSnake();
		
		assertTrue(1 == result.get(0).x && 1 == result.get(0).y);
		assertTrue(5 == result.get(4).x && 1 == result.get(4).y);

		snakeOld.setDirection(Direction.DOWN);
		snakeOld.move();

		result = snakeOld.getSnake();
		assertTrue(2 == result.get(0).x && 1 == result.get(0).y);
		assertTrue(5 == result.get(4).x && 2 == result.get(4).y);

		snakeOld.setDirection(Direction.LEFT);
		snakeOld.move();

		result = snakeOld.getSnake();
		assertTrue(3 == result.get(0).x && 1 == result.get(0).y);
		assertTrue(4 == result.get(4).x && 2 == result.get(4).y);

		snakeOld.setDirection(Direction.UP);
		snakeOld.move();

		result = snakeOld.getSnake();
	}
	
}
	