import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SnowflakeCatcher extends PApplet {

SnowFlake[] freezie;
int i;

public void setup()
{
  background(150);
  size(500,500);
  freezie = new SnowFlake[100];
  for (int i = 0; i < freezie.length; i++) {
    freezie[i] = new SnowFlake();
  }
}
public void draw()
{
  for (int i = 0; i < freezie.length; i++) {
    freezie[i].erase();
    freezie[i].lookDown();
    freezie[i].move();
    freezie[i].wrap();
    freezie[i].show();
  }
}
public void mouseDragged()
{
  fill(0);
  rectMode(CENTER);
  rect(mouseX,mouseY, 15,15);
}

class SnowFlake
{
  int x, y;
  boolean isMoving;
  SnowFlake()
  {
    x = (int) (Math.random()*500);
    y = (int) (Math.random()*500);
    isMoving = true;
  }
  public void show()
  {
    fill(42,220,0);
    ellipse(x,y, 5,5);

    fill(150);
    rectMode(CENTER);
    rect(250, 490, 500, 10);
  }
  public void lookDown()
  {
    if (get(x,y+3) != color(150)) {
      isMoving = false;
    } else { 
      isMoving = true;
    }
  }
  public void erase()
  {
    noStroke();
    fill(150);
    ellipse(x, y, 7.5f, 7.5f);
  }
  public void move()
  {
    if (isMoving) {
      y = y + 1;
    }
  }
  public void wrap()
  {
    if (y >= 490) {
      y = 0;
      x = (int) (Math.random()*500);
    }
  }
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
