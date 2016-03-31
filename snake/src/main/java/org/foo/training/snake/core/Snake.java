package org.foo.training.snake.core;

import org.foo.training.snake.util.FixedSizeQueue;

public class Snake {

	private int size = 3; // default
	private int speed = 1; // default
	private Point tailDefault = new Point(1, 1);
	// I don't touch color yet. No idea what the UI will do

	private enum Direction {
		UP, RIGHT, DOWN, LEFT
	};

	Direction direction;

	FixedSizeQueue<Point> snake;

	public Snake() {
		snake = new FixedSizeQueue<Point>(tailDefault);

		for (int i = 0; i < size - 1; i++) {
			snake.setNewSize(1);
			snake.add(tailDefault.nextRight());
		}
	}

	public void move(Direction direction, Level level) {

		try {
			switch (this.direction) {
			case UP:
				if (level.isWithinBoundaries(snake.getLast().nextUp())) {
					snake.add(snake.getLast().nextUp());
				}
			case RIGHT:
				if (level.isWithinBoundaries(snake.getLast().nextRight())) {
					snake.add(snake.getLast().nextRight());
				}
			case DOWN:
				if (level.isWithinBoundaries(snake.getLast().nextDown())) {
					snake.add(snake.getLast().nextDown());
				}
			case LEFT:
				if (level.isWithinBoundaries(snake.getLast().nextLeft())) {
					snake.add(snake.getLast().nextLeft());
				}
			}
		} catch (Exception e) {
			// todo
		}

	}

}
