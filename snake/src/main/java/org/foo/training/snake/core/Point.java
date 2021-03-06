package org.foo.training.snake.core;

import java.util.Objects;

public class Point {
	public final int x;
	public final int y;
		
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point nextRight() {
		return new Point(x+1,y);
	}
	
	public Point nextLeft() {
		return new Point(x-1,y);
	}
	
	public Point nextUp() {
		return new Point(x,y-1);
	}
	
	public Point nextDown() {
		return new Point(x,y+1);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) { return false; } 
		if (getClass() != o.getClass()) { return false; }
		Point other = (Point) o;
		return (this.x == other.x && this.y == other.y);	
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(x,y);
	}
}
