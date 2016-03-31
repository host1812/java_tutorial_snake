package org.foo.training.snake.core;

public class Level {
	
	private Point[][] field;
	private static final int MIN_SIZE = 10;
	private static final int MAX_SIZE = 30;
	private int width;
	private int height;
 
	public Level() {
		initField();
	}
	
	public Point[][] getField() {
		return field;
	}

	public void initField() {
		width = (int)(MIN_SIZE + (MAX_SIZE - MIN_SIZE)*Math.random());
		height = (int)(MIN_SIZE + (MAX_SIZE - MIN_SIZE)*Math.random());
		
		field = new Point[width][height];
		
		for (int i=0;i<width;i++) {
			for (int j=0;j<height;j++) {
				field[i][j] = new Point(i,j);
			}
		}
	}
	
	public boolean isWithinBoundaries(Point point) {
		if (point.x <= width && point.y <= height) {
			return true;
		}
		return false;
	}
	
	
}
