package org.foo.training.snake;

import org.foo.training.snake.core.UserInterface;
import org.foo.training.snake.ui.ConsoleInterface;

public class GameRunner {

	public static void main(String[] args) throws Exception {
		UserInterface iface = new ConsoleInterface();
		iface.testInterface();
	}
}
