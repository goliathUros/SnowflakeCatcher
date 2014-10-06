SnowFlake[] freezie;
int i;

void setup()
{
  background(150);
  size(500,500);
  freezie = new SnowFlake[100];
  for (int i = 0; i < freezie.length; i++) {
    freezie[i] = new SnowFlake();
  }
}

void draw()
{
  for (int i = 0; i < freezie.length; i++) {
    freezie[i].erase();
    freezie[i].lookDown();
    freezie[i].move();
    freezie[i].wrap();
    freezie[i].show();
  }
}

void mouseDragged()
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

  void show()
  {
    fill(42,220,0);
    ellipse(x,y, 5,5);

    fill(150);
    rectMode(CENTER);
    rect(250, 500, 500, 5);
  }

  void lookDown()
  {
    if (get(x,y+3) != color(150)) {
      isMoving = false;
    } else { 
      isMoving = true;
    }
  }

  void erase()
  {
    noStroke();
    fill(150);
    ellipse(x, y, 7.5, 7.5);
  }

  void move()
  {
    if (isMoving) {
      y = y + 1;
    }
  }

  void wrap()
  {
    if (y >= 495) {
      y = 0;
      x = (int) (Math.random()*500);
    }
  }
  
}


