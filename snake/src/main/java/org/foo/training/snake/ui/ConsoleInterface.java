package org.foo.training.snake.ui;

import org.foo.training.snake.core.UserInterface;

public class ConsoleInterface implements UserInterface {

	public void testInterface() throws Exception {
		
		for( int i=0; i<50; i++ ) {
			
			System.out.println("\nXXXXXXXXXXXXXXXXXXXXXX");
			System.out.println("\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			Thread.sleep(200);
			System.out.println("\nXXXXXXXXXXXXXXXXXXXXXX");
			Thread.sleep(500);
			System.out.print("\033[H\033[2J");
			
		}
		
	}

}
