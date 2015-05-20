package sprites;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Random;

import systems.Points;
import main.Game;

public class Fish extends Applet{
  int FISH_WIDTH = 39;
  int FISH_HEIGHT = 49;
  int x = FISH_WIDTH;
  int y = 0;
  int xa = 1;
  int ya = 1;
  Random randomGenerator = new Random();
  private Image apple = null;
  private Game game;
  private Points points;
  
  public Fish(Game game, Points p){
      this.game= game;
      points = p;
  }

  public Points move() {
        if (y + ya > game.getHeight() - Game.DIAMETER){ // once the fish hits the bottom, reset 
          y = 0; 
          x = randomGenerator.nextInt(Game.GAME_WIDTH - 2*Game.DIAMETER) + Game.DIAMETER;
        }
        if (collision()){ // get points for every fish you catch 
          points.updatePoints(); 
          y = 0; 
          x = randomGenerator.nextInt(Game.GAME_WIDTH - 2*Game.DIAMETER) + Game.DIAMETER;
        }
        y = y + ya;
        return points;
  }

  private boolean collision() { 
      return game.cat.getBounds().intersects(getBounds());
  }

  public void paint(Graphics2D g) {
    ImageLoader il = new ImageLoader();
    il.paint(g, x, y, FISH_WIDTH, FISH_HEIGHT, "fish.png");
  }
  
  public Rectangle getBounds() { 
      return new Rectangle(x, y, FISH_WIDTH, FISH_HEIGHT);
  }
}
