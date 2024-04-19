import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

  // initializing images
  PImage imgCrimsonBackgroound;
  PImage imgEmpressLight;
  PImage imgCultist;
  PImage imgDevotee;

  // Initializes Empress of Light
  float fltEmpressLightX = 0;
  float fltEmpressLightY = 100;
  int intEmpressLightSpeedX = 1;
  int intDegrees = 0;

  // Initializes Cultist Devotee
  float fltCultistX = 200;
  float fltCultistY = 600;
  int intCultistSpeedX = 1;
  float fltPrevPosX = 0;
  float fltPrevPosY = 0;
  float fltCultistRotation = 0;

  /**
   * Called once at the beginning of execution
   */
  public void settings() {
    size(800, 600);
  }

  /**
   * Called once at the beginning of execution. Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    imgCrimsonBackgroound = loadImage("Crimson_background.png");
    imgEmpressLight = loadImage("Lunatic_Cultist.gif"); // Empress of Light is the same as the cultist
    imgCultist = loadImage("Lunatic_Cultist.gif");
    imgDevotee = loadImage("Lunatic_Devotee.gif");
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

    // draws the crimson background
    image(imgCrimsonBackgroound, 0, 0);

    // updates the position of the cultist and the devotee
    calculateEmpressPosition();
    calculateCultistPosition();

    // drawing the cultist devotee
    pushMatrix();
    translate(fltCultistX, fltCultistY);
    rotate(fltCultistRotation);
    translate(-29, -16);

    image(imgDevotee, 0, 0);
    popMatrix();

    // draws a rectangular cloud above the empress of light
    fill(255);
    rect(fltEmpressLightX - 10, fltEmpressLightY - 20, 90, 15);

    // draws the empress of light
    image(imgEmpressLight, fltEmpressLightX, fltEmpressLightY);
    intDegrees += 1;
  }

  /**
   * Description: calculates the position of the Empress of Light
   */
  public void calculateEmpressPosition() {
    // Bounce upon collision with the edges of the screen
    int empressLightWidth = 100;
    if (fltEmpressLightX > width - empressLightWidth || fltEmpressLightX < 0)
        intEmpressLightSpeedX *= -1;

    fltEmpressLightX += intEmpressLightSpeedX;
    fltEmpressLightY += sin(radians(intDegrees));
  }

  /**
   * Calculates the position of the cultist devotee
   */
  public void calculateCultistPosition() {
    // Bounce upon collision with the edges of the screen
    if (fltCultistX > width - 0 || fltCultistX < 30)
        intCultistSpeedX *= -1;
    fltCultistX += intCultistSpeedX;
    fltCultistY = 500;
  }
}