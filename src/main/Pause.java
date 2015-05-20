package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Pause {
  private Game game;
  
  public Pause(Game game){
    this.game = game;
  }

  public void paint(Graphics g) {
    g.setColor(Color.darkGray);
    Font title = new Font("Arial", Font.BOLD, 35);
    g.setFont(title);
    g.drawString("Cat Phishing", 80, 110);
    Font instructions = new Font("Arial", Font.PLAIN, 20);
    g.setFont(instructions);
    g.drawString("Press Space to continue", 80 , 140);
    g.drawString("the game.", 80 , 160);
    g.setFont(new Font("Arial", Font.PLAIN, 16));
    g.drawString("Catch the fish. Avoid the Water!", 2, 340);
    g.drawString("Use the left and right arrow keys to move.", 2, 358);
  }

  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_SPACE)
        game.gameGame();
  }
}
