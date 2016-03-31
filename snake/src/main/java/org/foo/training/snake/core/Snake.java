package org.foo.training.snake.core;

import org.foo.training.snake.util.FixedSizeQueue;
import org.foo.training.snake.util.LethalMoveException;

public class Snake {

	private int size = 3; // default
	private Point tailDefault = new Point(1, 1);
	private boolean grow = false;
	// I don't touch color yet. No idea what the UI will do

	private enum Direction {
		UP, RIGHT, DOWN, LEFT
	};

	Direction direction;

	FixedSizeQueue<Point> snake;

	public Snake() {
		snake = new FixedSizeQueue<Point>(tailDefault);

		for (int i = 0; i < size - 1; i++) {
			snake.incrementSize(1);
			snake.add(tailDefault.nextRight());
		}
	}
	
	public FixedSizeQueue<Point> getSnake() {
		return snake;
	}
	
	public void setGrow(boolean grow) {
		this.grow = grow;
	}
	
	public void move(Direction direction, Level level) {

		try {
			switch (this.direction) {
			case UP:
				if (level.isWithinBoundaries(snake.getLast().nextUp())) {
					if (grow) snake.incrementSize(1);
					snake.add(snake.getLast().nextUp());
					break;
				}
				else {
					throw new LethalMoveException("Game Over");
				}
			case RIGHT:
				if (level.isWithinBoundaries(snake.getLast().nextRight())) {
					if (grow) snake.incrementSize(1);
					snake.add(snake.getLast().nextRight());
					break;
				}
				else {
					throw new LethalMoveException("Game Over");
				}
			case DOWN:
				if (level.isWithinBoundaries(snake.getLast().nextDown())) {
					if (grow) snake.incrementSize(1);
					snake.add(snake.getLast().nextDown());
					break;
				}
				else {
					throw new LethalMoveException("Game Over");
				}
			case LEFT:
				if (level.isWithinBoundaries(snake.getLast().nextLeft())) {
					if (grow) snake.incrementSize(1);
					snake.add(snake.getLast().nextLeft());
					break;
				}
				else { 
					throw new LethalMoveException("Game Over");
				}
			}
			
			setGrow(false);
			
		} catch (LethalMoveException e) {
			//TODO
		}

	}

}
