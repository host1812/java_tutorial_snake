package org.foo.training.snake.util;

public class LethalMoveException extends Exception {

	private static final long serialVersionUID = 1L;

	public LethalMoveException(String message) {
		super(message);
	}
}
