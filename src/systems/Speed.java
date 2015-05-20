package systems;

import main.Game;

public class Speed {
  private Game game;
  private Points points;
  
  public Speed(Game game, Points points){
    this.game = game;
    this.points = points; 
  }
  
  public Integer updateSpeed(){
    int speed;
    int currentPoints = points.getPointsInt();
    if(currentPoints < 5){
      speed = 8; 
    } else if(currentPoints >= 5 && currentPoints < 10){
      speed = 7;
    } else if(currentPoints >= 10 && currentPoints < 15){
      speed = 6;
    } else if(currentPoints >= 15 && currentPoints < 20){
      speed = 5;
    } else if(currentPoints >= 20 && currentPoints < 30){
      speed = 4;
    } else if(currentPoints >= 30 && currentPoints < 40){
      speed = 3;
    } else if(currentPoints >= 40 && currentPoints < 50){
      speed = 2;
    } else { // fastest speed
      speed = 1;
    }
    return speed;
  }
}
