package cl.paradigmas.modelo;

import java.awt.Graphics;
import java.awt.Point;

import cl.paradigmas.gui.Dibujable;

public class Circulo implements Dibujable{
	
	private Point posicion;
	private int radius;
	
	public Circulo(Point posicion, int radius){
		this.posicion = posicion;
		this.radius = radius;
	}

	public Point getPosicion() {
		return posicion;
	}

	public void setPosicion(Point posicion) {
		this.posicion = posicion;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public void dibujar(Graphics g) {
		g.drawOval(posicion.x, posicion.y, radius, radius);
	}
	
}
