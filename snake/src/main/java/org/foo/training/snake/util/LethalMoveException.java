package org.foo.training.snake.util;

public class LethalMoveException extends Exception {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 6681061903910663309L;
	private String message;
    
    public LethalMoveException(String message) {
       this.message = message;
    }
    
    public String toString(){ 
       return (message) ;
    }

}
