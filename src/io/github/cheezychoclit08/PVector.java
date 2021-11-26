package io.github.cheezychoclit08;

import java.util.Random;

//@author Torin

public class PVector {
	//Fields
	public double x = 0, y = 0;
	
	//Constructors
	public PVector(double xIn, double yIn) {
		this.x = xIn;
		this.y = yIn;
	}
	
	public PVector() {
		new PVector(0, 0);
	}
	
	public PVector(Random r, double maxX, double maxY) {
		new PVector(r.nextDouble(), r.nextDouble());
	}
	
	//Mutators
	public void set(double xIn, double yIn) {
		this.x = xIn;
		this.y = yIn;
	}
	
	public void add(PVector p) {
		this.x += p.x;
		this.y += p.y;
	}
	
	public void add(double a) {
		this.add(new PVector(a, a));
	}
	
	public void subtract(PVector p) {
		this.x -= p.x;
		this.y -= p.y;
	}
	
	public void subtract(double a) {
		this.subtract(new PVector(a, a));
	}
	
	public void mult(PVector p) {
		this.x *= p.x;
		this.y *= p.y;
	}
	
	public void mult(double a) {
		this.mult(new PVector(a, a));
	}
	
	public void div(PVector p) {
		this.x /= p.x;
		this.y /= p.y;
	}
	
	public void div(double a) {
		this.div(new PVector(a, a));
	}
	
	public void normalize() {
		this.div(this.mag());
	}
	
	//Accessors
	public static PVector add(PVector p1, PVector p2) {
		double rx = p1.x + p2.x;
		double ry = p1.y + p2.y;
		return new PVector(rx, ry);
	}
	
	public static PVector add(PVector p, double a) {
		return add(p, new PVector(a, a));
	}
	
	public static PVector subtract(PVector p1, PVector p2) {
		double rx = p1.x - p2.x;
		double ry = p1.y - p2.y;
		return new PVector(rx, ry);
	}
	
	public static PVector subtract(PVector p, double a) {
		return subtract(p, new PVector(a, a));
	}
	
	public static PVector mult(PVector p1, PVector p2) {
		double rx = p1.x * p2.x;
		double ry = p1.y * p2.y;
		return new PVector(rx, ry);
	}
	
	public static PVector mult(PVector p, double a) {
		return mult(p, new PVector(a, a));
	}
	
	public static PVector div(PVector p1, PVector p2) {
		double rx = Math.round(p1.x / p2.x);
		double ry = Math.round(p1.y / p2.y);
		return new PVector(rx, ry);
	}
	
	public static PVector div(PVector p, double a) {
		return div(p, new PVector(a, a));
	}
	
	public double mag() {
		return (Math.round(Math.sqrt((this.x * this.x) + (this.y * this.y))));
	}
	
	public static double dist(PVector p1, PVector p2) {
		double xd = 0, yd = 0;
		if(p1.x > p2.x) {
			xd = p1.x - p2.x;
			yd = p1.y - p2.y;
		} else {
			xd = p2.x - p1.x;
			yd = p2.y - p1.y;
		}
		return new PVector(xd, yd).mag();
	}
	
	public PVector copy() {
		//Performs deep copy
		double x = this.x, y = this.y;
		return new PVector(x, y);
	}

	public PVector midpoint(PVector[] pArr) {
		double al = pArr.length;
		double allX = 0, allY = 0;
		for(PVector p : pArr) {
			allX += p.x;
			allY += p.y;
		}
		
		allX /= al;
		allY /= al;

		return new PVector(allX, allY);
	}
}
