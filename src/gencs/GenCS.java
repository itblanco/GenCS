package gencs;

import processing.core.*;
import processing.opengl.PJOGL;
import toxi.geom.*;
import toxi.geom.mesh.*;
import toxi.physics3d.*;
import toxi.physics3d.behaviors.*;
import toxi.physics3d.constraints.*;
import toxi.processing.*;
import peasy.*;
import controlP5.*;

public class GenCS extends PApplet {
	
	PeasyCam cam;
	ToxiclibsSupport gfx;
	WETriangleMesh mesh;
	ControlP5 cp5;
	
	public void settings() {
		size(displayWidth - 500, displayHeight - 500, P3D);		
		PJOGL.setIcon("nour-icon.png");
	}

	public void setup() {
		surface.setTitle("Nour's Awesome Software");
		perspective(PI/3, (float)width/(float)height, 1, 10000);
		cam = new PeasyCam(this, 500);
		cam.rotateZ(PI/4); 
		cam.rotateX(-PI/4);
		cam.setSuppressRollRotationMode();
		cam.setActive(false);
		
		cp5 = new ControlP5(this);
		cp5.setAutoDraw(false);
		cp5.addSlider("Test1");
		cp5.addSlider("Test2");
		cp5.addSlider("Test3");
	}

	public void draw() {
		background(0x1c1c1c);
		scale(1,-1,1);
				
		drawGrid(10, 5, 50);
		drawAxes(50);
		drawUI();
	}

	public void drawAxes(float size) {
		push();
		strokeWeight(2);
		// X Axis
		stroke(0xffff0000);
		line(0,0,0,size,0,0);
		// Y Axis
		stroke(0xff00ff00);
		line(0,0,0,0,size,0);
		// Z Axis
		stroke(0xff0000ff);
		line(0,0,0,0,0,size);
		pop();
	}
	
	public void drawGrid(float size, int majorLines, int extend) {
		push();
		stroke(0x2c);
		strokeWeight(1);
		float gridSize = size*extend;
		int count  = 0;
		for(float i = -gridSize; i <= gridSize; i += size) {
			if(count % majorLines != 0) {
				line(i, -gridSize, i, gridSize);
				line(-gridSize, i, gridSize, i);				
			}	
			count++;
		}
		count = 0;
		for(float i = -gridSize; i <= gridSize; i += size) {			
			if(count % majorLines == 0) {
				stroke(0x80);
				strokeWeight(2);
				line(i, -gridSize, i, gridSize);
				line(-gridSize, i, gridSize, i);				
			}
			count++;
		}
		pop();
	}
	
	public void drawUI() {
		cam.beginHUD();
		cp5.draw();
		cam.endHUD();
	}
	
	public void keyPressed() {
		if(keyCode == ALT) {
			cam.setActive(true);
			cam.setFreeRotationMode();
		}
	}
	
	public void keyReleased() {
		cam.setActive(false);
	}
	
	public static void main(String[] args) {
		PApplet.main(new String[] { gencs.GenCS.class.getName() });
	}
}
