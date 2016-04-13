package org.foo.training.snake.ui;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import org.foo.training.snake.core.UserInterface;

public class ConsoleInterface implements UserInterface {

  @Override
  public void testInterface() throws Exception {
    
    Terminal terminal = new DefaultTerminalFactory().createTerminal();
    terminal.clearScreen();

    for (int i = 0; i < 50; i++) {

      terminal.setCursorVisible(false);
      
      KeyStroke ks = terminal.pollInput();
      
      terminal.setCursorPosition(0, i);
      terminal.putCharacter('X');
      if(ks != null) {
        terminal.setCursorPosition(1, 0);
        switch(ks.getKeyType()) {
          case ArrowDown:
            terminal.putCharacter('D');
            break;

          case ArrowUp:
            terminal.putCharacter('U');
            break;

          case ArrowLeft:
            terminal.putCharacter('L');
            break;

          case ArrowRight:
            terminal.putCharacter('R');
            break;

          default:
            break;
        }
      }
      
      Thread.sleep(500);
      if(i%10 == 0) {
        terminal.clearScreen();
      }
      //System.out.print("\033[H\033[2J");
    }
  }
}
