package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import sprites.Cat;

public class KeyboardInput {
  private Game game;
  private Cat cat;
  private Menu menu;
  private Pause pause;
  
  public KeyboardInput(Game game, Cat cat, Menu menu, Pause pause){
    this.game = game;
    this.cat = cat;
    this.menu = menu;
    this.pause = pause;
  }
  
  public void setKeboardInput(){
      game.addKeyListener(new KeyListener() {
      @Override
      public void keyTyped(KeyEvent e) { 
      }
  
      @Override
      public void keyReleased(KeyEvent e) {
          cat.keyReleased(e);
      }
  
      @Override
      public void keyPressed(KeyEvent e) {
          cat.keyPressed(e);
          menu.keyPressed(e);
          pause.keyPressed(e);
      }
  });
  game.setFocusable(true);
  }
}
