package systems;

import java.awt.Font;
import java.awt.Graphics2D;

import sprites.Hearts;
import main.Game;

public class Lives {
  private Game game;
  private Hearts heart;
  
  public Lives(Game game, Hearts heart){
    this.game = game;
    this.heart = heart;
  }
  
  public void paint(Graphics2D g, int numHearts){
       Graphics2D g2 = (Graphics2D) g;
      if(numHearts >= 1){
        heart.paint(g2, 250, 43);
      } if (numHearts >= 2){
        heart.paint(g2, 210, 43);
      } if (numHearts >= 3){
        heart.paint(g2, 170, 43);
      }
  }

}
