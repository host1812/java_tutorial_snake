package org.foo.training.snake.core;

public class Level {

	private Point[][] field;
	
	private static final int MIN_SIZE = 10;
	private static final int MAX_SIZE = 30;

	public Level() {
		initField();
	}
	
	protected Level(int width, int height) {
		initField(width, height);
	}
	
	public Point[][] getField() {
		return field;
	}

	private void initField() {
		int width = (int) (MIN_SIZE + (MAX_SIZE - MIN_SIZE) * Math.random());
		int height = (int) (MIN_SIZE + (MAX_SIZE - MIN_SIZE) * Math.random());
		
		initField(width, height);
	}
	
	private void initField(int width, int height) {
		field = new Point[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				field[i][j] = new Point(i, j);
			}
		}
	}

	public int getWidth() {
		return field.length;
	}

	public int getHeight() {
		return field[0].length;
	}

	public boolean isWithinBoundaries(Point point) {
		return (point.x < getWidth() &&
				point.x >= 0 &&
				point.y < getHeight() &&
				point.y >= 0);
	}
}
