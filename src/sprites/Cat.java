package sprites;

import java.applet.Applet;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import main.Game;

public class Cat extends Applet{
  private static final int Y = Game.GAME_HEIGHT - 100;
  int CAT_DIAMETER = Game.DIAMETER;
  int x = 0; 
  int xa = 0;
  private Game game;
  
  public Cat(Game game){
      this.game = game; 
  }
  
  public void move() {
      if (x + xa > 0 && x + xa < game.getWidth()-CAT_DIAMETER)
          x = x + xa;
  }

  public void paint(Graphics2D g) {
    ImageLoader il = new ImageLoader();
    il.paint(g, x, Y, CAT_DIAMETER, CAT_DIAMETER, "cat.png");
  }
  
  public void keyReleased(KeyEvent e) { 
      xa = 0;
  }
  
  public void keyPressed(KeyEvent e) {
      if (e.getKeyCode() == KeyEvent.VK_LEFT) 
          xa = -1;
      if (e.getKeyCode() == KeyEvent.VK_RIGHT) 
          xa = 1;
      if (e.getKeyCode() == KeyEvent.VK_P)
          game.gamePause();
      if (e.getKeyCode() == KeyEvent.VK_Q)
          game.gameQuit();
      if (e.getKeyCode() == KeyEvent.VK_M)
          game.gameMenu();
  }
  
  public Rectangle getBounds() { 
    return new Rectangle(x, Y, CAT_DIAMETER, CAT_DIAMETER);
  }
  
  public int getTopY() {
    return Y;
  }
}
