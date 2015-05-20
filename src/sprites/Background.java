package sprites;

import java.awt.Font;
import java.awt.Graphics2D;

import main.Game;

public class Background {
  private Game game;

  public Background(Game game){
    this.game = game; 
  }
  
  public void paint(Graphics2D g) {
    ImageLoader il = new ImageLoader();
    il.paint(g, 0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, "ship.png");
  }
  
  public void paintText(Graphics2D g){
    int fontSize = 16;
    g.setFont(new Font("Arial", Font.PLAIN, fontSize));
    g.drawString("Catch the fish. Avoid the Water!", 2, 20);
    g.drawString("Use the left and right arrow keys to move.", 2, 38);
    g.drawString("Press P to pause. Press Q to quit.", 2, 340);
    g.drawString("Press M to go to the main menu.", 2, 358);
  }
}
