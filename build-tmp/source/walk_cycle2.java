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

public class walk_cycle2 extends PApplet {

ArrayList<Animation> animations;
PImage rue;
PImage ruedevant;


public void setup(){

animations = new ArrayList<Animation>();  // Create an empty ArrayList

size(displayWidth, displayHeight);
frameRate(12);
rue = loadImage("rue.gif");
ruedevant = loadImage("rue2.gif");
}

public void draw(){
	image(rue, 0,0, displayWidth, displayHeight );
	for (int i = 0; i = animations.size()-1; i++) {
		Animation animation = animations.get(i);
		animation.display();
		animation.move();


//	if (animation.finished()) {
// Items can be deleted with remove().
//      animation.remove(i);
//  }

}
image(ruedevant, 0,0, displayWidth, displayHeight );

}


public void mousePressed(){
	animations.add(new Animation("walk_cycle", 15, mouseX-50, mouseY-75, 100, 150, 6, 3));

}

class Animation {

	PImage[] images;
	int imageCount;
	int frame;
	float xpos;
	float ypos;
	float xwidth;
	float ywidth;
	int wspeed;
	int yspeed;

	Animation(String imagePrefix, int count, float _xpos, float _ypos, float _xwidth, float _ywidth, int _wspeed, int _yspeed) {
		xpos = _xpos;
		ypos = _ypos;
		xwidth = _xwidth;
		ywidth = _ywidth;
		wspeed =_wspeed;
		yspeed = _yspeed;
		imageCount = count;
		images = new PImage[imageCount];

		for (int i = 0; i < imageCount; i++) {
      // Use nf() to number format 'i' into four digits
      String filename = imagePrefix + i + ".gif";
      images[i] = loadImage(filename);
  }
}

public void display() {
	frame = (frame+1) % imageCount;
	image(images[frame], xpos, ypos, xwidth, ywidth);
}

public void move() {
    // Add speed to y location
    xpos = xpos -= wspeed;
    ypos = ypos -= yspeed;
}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--stop-color=#cccccc", "walk_cycle2" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
