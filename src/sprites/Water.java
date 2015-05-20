package sprites;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Random;

import main.Game;

public class Water extends Applet{
  int WATER_WIDTH = 36;
  int WATER_HEIGHT = 44;
  int x = Game.GAME_WIDTH - 2*WATER_WIDTH;
  int y = 0;
  int xa = 1;
  int ya = 1;
  Random randomGenerator = new Random();
  private Image water = null;
  private Game game;
  private Hearts heart;

  public Water(Game game, Hearts heart){
      this.game= game;
      this.heart = heart;
  }

  public void move() {
        if (y + ya > game.getHeight() - Game.DIAMETER){
          // once the water hits the ground, start the next water
          y = 0; 
          x = randomGenerator.nextInt(Game.GAME_WIDTH - 2*Game.DIAMETER) + Game.DIAMETER;
        }
        if (collision()){ 
          if(heart.numHearts() <= 1){
              game.gameOver();
          } else{
            heart.removeHeart();
            y = 0; 
            x = randomGenerator.nextInt(Game.GAME_WIDTH - 2*Game.DIAMETER) + Game.DIAMETER;
          }
        }
        y = y + ya;
  }

  private boolean collision() { 
      return game.cat.getBounds().intersects(getBounds());
  }

  public void paint(Graphics2D g) {
    ImageLoader il = new ImageLoader();
    il.paint(g, x, y, WATER_WIDTH, WATER_HEIGHT, "water.png");
  }
  
  public Rectangle getBounds() { // position of the apple
      return new Rectangle(x, y, WATER_WIDTH, WATER_HEIGHT);
  }
}
