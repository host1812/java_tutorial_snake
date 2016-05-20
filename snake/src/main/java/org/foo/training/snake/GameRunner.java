package org.foo.training.snake;

import org.foo.training.snake.logic.GameState;
import org.foo.training.snake.renderers.ConsoleRenderer;
import org.foo.training.snake.renderers.Renderer;

public class GameRunner {

	public static void main(String[] args) throws Exception {
//		UserInterface iface = new ConsoleInterface();
//		iface.testInterface();

		// OK here is infinite main game loop.
		// This main loop ticks all the time.
		// We use simple state machine to determine current
		// game active state.

		GameState state = GameState.PLAYING;

		Renderer r = new ConsoleRenderer();
		// Logic l = new Logic(r);
		// l.setup();

		while (state != GameState.QUIT) {
			if (state == GameState.PLAYING) {
				r.frame();
			}
		}
		System.out.println("Thanks for playing me! See you soon...");
	}
}
