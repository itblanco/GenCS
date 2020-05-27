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

public class GenCS extends PApplet {
	
	PeasyCam cam;
	ToxiclibsSupport gfx;
	WETriangleMesh mesh;
	
	public void settings() {
		size(displayWidth - 500, displayHeight - 500, P3D);		
		PJOGL.setIcon("nour-icon.png");
	}

	public void setup() {
		surface.setTitle("Nour's Awesome Software");
		cam = new PeasyCam(this, 500);
		cam.setMinimumDistance(1);
		cam.setMaximumDistance(1000);
		cam.rotateZ(PI/4); 
		cam.rotateX(-PI/4);
		cam.setFreeRotationMode();
	}

	public void draw() {
		background(0x1c1c1c);
		scale(1,-1,1);
		drawAxes(50);
	}

	public void drawAxes(float size) {
		push();
		strokeWeight(2);
		// X Axis
		stroke(255,0,0);
		line(0,0,0,size,0,0);
		// Y Axis
		stroke(0,255,0);
		line(0,0,0,0,size,0);
		// Z Axis
		stroke(0,0,255);
		line(0,0,0,0,0,size);
		pop();
	}
	
	public void drawUI() {
		cam.beginHUD();
		cam.endHUD();
	}
	
	
	public static void main(String[] args) {
		PApplet.main(new String[] { gencs.GenCS.class.getName() });
	}
}
