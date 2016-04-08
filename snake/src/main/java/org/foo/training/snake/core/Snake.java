package org.foo.training.snake.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.foo.training.snake.util.*;

public class Snake {

	private Point tailDefault = new Point(1, 1);

	private Direction direction;
	private FixedSizeQueue<Point> snake;
	private Level level;

	public Snake(int size, Level level) {
		this.level = level;
		snake = new FixedSizeQueue<Point>(size);
		snake.add(tailDefault);
		for (int i = 0; i < size - 1; i++) {
			snake.add(snake.getLast().nextRight());
		}
	}
	
	public List<Point> getSnake() {
		List<Point> snakeOut = new ArrayList<Point>();
		Iterator<Point> it = snake.iterator();
		while(it.hasNext()) {
			snakeOut.add(it.next());
		}
		return snakeOut;
	}

	public void setGrow(int growSize) {
		snake.incrementSizeBy(growSize);
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void move() throws LethalMoveException {

		switch (direction) {
		case UP:
			if (isGoodMove(snake.getLast().nextUp())) {
				snake.add(snake.getLast().nextUp());
			} else {
				throw new LethalMoveException("Game Over");
			}
			break;
		case RIGHT:
			if (isGoodMove(snake.getLast().nextRight())) {
				snake.add(snake.getLast().nextRight());
			} else {
				throw new LethalMoveException("Game Over");
			}
			break;
		case DOWN:
			if (isGoodMove(snake.getLast().nextDown())) {
				snake.add(snake.getLast().nextDown());
			} else {
				throw new LethalMoveException("Game Over");
			}
			break;
		case LEFT:
			if (isGoodMove(snake.getLast().nextLeft())) {
				snake.add(snake.getLast().nextLeft());
			} else {
				throw new LethalMoveException("Game Over");
			}
			break;
		}
	}

	private boolean isGoodMove(Point point) {
		return (level.isWithinBoundaries(point) && !isSnake(point));
	}

	private boolean isSnake(Point point) {
		return snake.contains(point);
	}
}
