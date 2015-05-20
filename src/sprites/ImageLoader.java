package sprites;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.net.URL;

import main.Game;

public class ImageLoader extends Applet {
  
  
  /* Retrieved from: https://www.youtube.com/watch?v=oXmUp4ZTW2Q */
  public static Image getImage(String path){
    Image tempImage = null;
    try{
      URL imageURL = ImageLoader.class.getResource(path);
      tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
      
    } catch (Exception e){
      System.out.println("An error occured" + e.getLocalizedMessage());
    }
    return tempImage;
  }
  
  public Object paint(Graphics g, int x, int y, int width, int height, String image_name){
    Image img = null;
    if(img == null){
      img = getImage(image_name);
    }
    Graphics2D g2 = (Graphics2D) g;
    return g2.drawImage(img, x, y, width, height, this);
  }
  
}
