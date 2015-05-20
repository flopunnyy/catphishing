/**
 * http ://www.edu4java.com/en/game/game0-en.html
 */
package main;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import sprites.Background;
import sprites.Cat;
import sprites.Fish;
import sprites.Hearts;
import sprites.Water;
import systems.Lives;
import systems.Points;
import systems.Speed;

public class Game extends JPanel{
  
  private Menu menu = new Menu();
  private Pause pause = new Pause(this);
  
  public static int GAME_WIDTH = 300;
  public static int GAME_HEIGHT = 400;
  public static int DIAMETER = 60; // size of largest sprites
  
  public Background bg = new Background(this);
  public Cat cat = new Cat(this);
  public Hearts hearts = new Hearts(this);
  public Lives lives  = new Lives(this, hearts);
  public Water water = new Water(this, hearts);
  public Points points = new Points(this);
  public Fish fish = new Fish(this, points);

  KeyboardInput ki = new KeyboardInput(this, cat, menu, pause);
  Speed speed = new Speed(this, points);
  
  public void resetGame(){
    bg = new Background(this);
    cat = new Cat(this);
    hearts = new Hearts(this);
    lives  = new Lives(this, hearts);
    water = new Water(this, hearts);
    points = new Points(this);
    fish = new Fish(this, points);
    
    ki = new KeyboardInput(this, cat, menu, pause);
    ki.setKeboardInput();
    speed = new Speed(this, points);
  }
  
  /*Creating States: https://www.youtube.com/watch?v=FZWX5WoGW00*/
  private enum STATE{
    MENU,
    GAME,
    PAUSE,
  };

  private static STATE State = STATE.MENU; // current state
  
  public Game() {
    ki.setKeboardInput();
  }
     
  private void move() {
      cat.move();
      hearts.move();
      water.move();
      fish.move();
  }
  
  @Override
  public void paint(Graphics g) {
      super.paint(g);
      Graphics2D g2d = (Graphics2D) g;
      g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, // makes the edges smoother 
              RenderingHints.VALUE_ANTIALIAS_ON);
        bg.paint(g2d);
      if(State == STATE.MENU){
        menu.paint(g2d);
        if(menu.game()){
          gameGame();
        } 
      } else if (State == STATE.PAUSE){
        pause.paint(g2d);
      } else if (State == STATE.GAME){
        bg.paintText(g2d);
        cat.paint(g2d);
        hearts.paint(g2d);
        lives.paint(g2d, hearts.numHearts());
        water.paint(g2d);
        points.paint(g2d);
        fish.paint(g2d); 
      }
  }
  /**
   * 
   * Returns the current speed of the game. Game speeds up. 
   * 
   * @return Current speed of the game.
   */
  public Integer updateSpeed(){
      return speed.updateSpeed();
  }
  
  public void gameOver() { 
    int n = JOptionPane.showConfirmDialog(this, "Game Over: You got " + 
            points.getPointsStr() + " point(s)!!! Do you want to play again?", "Game Over", JOptionPane.YES_NO_OPTION);
    if(n == JOptionPane.YES_OPTION){
      resetGame();
      State = STATE.MENU;
      menu = new Menu();
      JOptionPane.showMessageDialog(this, "Restarting :3");
    } 
    if(n == JOptionPane.NO_OPTION){
      System.exit(ABORT);
    }
  }
  
  public void gameMenu(){
      gamePause();
      int n = JOptionPane.showConfirmDialog(this, "Are you sure you want to go the main menu?", "Menu", JOptionPane.YES_NO_OPTION);
      if(n == JOptionPane.YES_OPTION){
        resetGame();
        State = STATE.MENU;
        menu = new Menu();
        JOptionPane.showMessageDialog(this, "Restarting :3");
      } 
      if(n == JOptionPane.NO_OPTION){
        gameGame();
      }
  }
  
  public void gamePause(){
    State = STATE.PAUSE;
  }
  
  public void gameGame(){
    State = STATE.GAME;
  }
  
  /* http://stackoverflow.com/questions/8396870/joptionpane-yes-or-no-window */
  public void gameQuit(){
    State = STATE.PAUSE;
    int n = JOptionPane.showConfirmDialog(this, "Are you sure you want to quit?", "Quit", JOptionPane.YES_NO_OPTION);
    if(n == JOptionPane.YES_OPTION){
      System.exit(ABORT);
    }
    if(n == JOptionPane.NO_OPTION){
      gameGame();
    }
  }
  
  public static void main(String[] args) throws InterruptedException {
      JFrame frame = new JFrame("Cat Phishing");
      Game game = new Game();
      frame.add(game);
      frame.setSize(GAME_WIDTH, GAME_HEIGHT);
      frame.setResizable(false);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      while (true) {
           game.repaint();
           if (State == STATE.GAME){ //Gameplay 
             int speed = game.updateSpeed();
             Thread.sleep(speed); 
             game.move();
           }
     }      
  }
}
