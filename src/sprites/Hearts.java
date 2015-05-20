package sprites;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import main.Game;

public class Hearts {
  int HEART_WIDTH = 30;
  int HEART_HEIGHT = 28;
  int heart_counter = 0; 
  Random randomGenerator = new Random();
  int x = Game.GAME_WIDTH + HEART_WIDTH;
  int y = 0;
  int xa = 1;
  int ya = 1;
  private Game game;
  public int numHearts = 3;

  public Hearts(Game game){
    this.game = game; 
  }
  
  public void move() {
    heart_counter += 1;
    if (y + ya > game.getHeight() - Game.DIAMETER){
      // once the water hits the ground, start the next water
      y = 0; 
      if(heart_counter % 13 == 0){ // hearts only fall sometimes 
        x = randomGenerator.nextInt(Game.GAME_WIDTH - 2*Game.DIAMETER) + Game.DIAMETER;
      } else {
        x = Game.GAME_WIDTH + HEART_WIDTH;
      }
    }
    if (collision()){ 
      if(numHearts() < 3){
        addHeart();
        y = 0; 
        if(heart_counter % 13 == 0){ // hearts only fall sometimes 
          x = randomGenerator.nextInt(Game.GAME_WIDTH - 2*Game.DIAMETER) + Game.DIAMETER;
        } else {
          x = Game.GAME_WIDTH + HEART_WIDTH;
        }
      }
    }
    y = y + ya;
}
  
  private boolean collision() {
    return game.cat.getBounds().intersects(getBounds());
  }
  
  public void paint(Graphics2D g){
    ImageLoader il = new ImageLoader();
    il.paint(g, x, y, HEART_WIDTH , HEART_HEIGHT, "heart.png");
  }

  public void paint(Graphics2D g, int x, int y) {
    ImageLoader il = new ImageLoader();
    il.paint(g, x, y, HEART_WIDTH , HEART_HEIGHT, "heart.png");
  }
  
  public Rectangle getBounds() { 
    return new Rectangle(x, y, HEART_WIDTH, HEART_HEIGHT);
  }
  
  public void addHeart(){
    numHearts += 1;
  }
  
  public void removeHeart(){
    numHearts -= 1;
  }
  
  public Integer numHearts(){
    return numHearts;
  }
  
}
