package org.foo.training.snake.core;

import org.foo.training.snake.util.*;

public class Snake {

	private Point tailDefault = new Point(1, 1);

	private Direction direction;
	private FixedSizeQueue<Point> snake;
	private Level level;

	public Snake(int size, Level level) {
		this.level = level;
		snake = new FixedSizeQueue<Point>(size);
		for (int i = 0; i < size - 1; i++) {
			snake.add(tailDefault.nextRight());
		}
	}

	public FixedSizeQueue<Point> getSnake() {
		return snake;
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
				break;
			} else {
				throw new LethalMoveException("Game Over");
			}
		case RIGHT:
			if (isGoodMove(snake.getLast().nextRight())) {
				snake.add(snake.getLast().nextRight());
				break;
			} else {
				throw new LethalMoveException("Game Over");
			}
		case DOWN:
			if (isGoodMove(snake.getLast().nextDown())) {
				snake.add(snake.getLast().nextDown());
				break;
			} else {
				throw new LethalMoveException("Game Over");
			}
		case LEFT:
			if (isGoodMove(snake.getLast().nextLeft())) {
				snake.add(snake.getLast().nextLeft());
				break;
			} else {
				throw new LethalMoveException("Game Over");
			}
		}
	}

	private boolean isGoodMove(Point point) {
		return (level.isWithinBoundaries(point) && !isSnake(point));
	}

	private boolean isSnake(Point point) {
		return snake.contains(point);
	}
}
