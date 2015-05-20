package systems;

import java.awt.Font;
import java.awt.Graphics2D;

import main.Game;

public class Points {
  public int points;
  private Game game; 
  
  public Points(Game game){
    this.game = game;
  }
  
  public Integer paint(Graphics2D g){
    int fontSize = 18;
    g.setFont(new Font("Arial", Font.PLAIN, fontSize));
    Graphics2D g2 = (Graphics2D) g;
    g2.drawString("Points: " + this.getPointsStr(), 2, 60);
    return points;
  }
  
  public void updatePoints(){
    points += 1;
  }
  
  public String getPointsStr(){
    return String.valueOf(points);
  }
  
  public int getPointsInt(){
    return points;
  }
}
