import processing.core.PApplet;
import processing.core.PImage; //import the PImage library

public class Sketch extends PApplet {

  PImage imgMeteor; // declare a global image variable
  PImage imgMissile;
  PImage imgBackground;
  //

  float fltMeteorX = -100;
  float fltMeteorY = 0;

  float fltMissileX = 200;
  float fltMissileY = 400-50;

  float fltCirX = 100;
  float fltCirY = width/10;

  float fltCirSpeedX = 2;
  float fltCirSpeedY = 1;


  public void settings() {
    size(400, 400);

  }

  public void setup() {

    imgMeteor = loadImage("spaceMeteors_003.png"); // load the image into the program
    //resize meteor
    imgMeteor.resize(imgMeteor.width/4,imgMeteor.height/4);

    // load missile
    imgMissile = loadImage("spaceMissiles_006.png");

    imgBackground = loadImage("spaceBack.jpeg");



    // load rocket
    // resize rocket
  }

  public void draw() {
    background(128);
    image(imgBackground, 0, 0);

    // draw Meteor and move
    image(imgMeteor,fltMeteorX,fltMeteorY);
    fltMeteorX += 1;
    //fltMeteorY += 1;


    // draw circle and move
    circle(fltCirX, fltCirY, 20);
    fltCirX += fltCirSpeedX;
    fltCirY += fltCirSpeedY;

    if (fltCirX < 0+10 || fltCirX > width-10) {
      fltCirSpeedX *= -1;
    }

    if (fltCirY < 0+10  || fltCirY > height-10) {
      fltCirSpeedY *= -1;
    }

    // draw missle and move
    image(imgMissile, fltMissileX, fltMissileY);
    fltMissileY -= 0.5;




  }
}