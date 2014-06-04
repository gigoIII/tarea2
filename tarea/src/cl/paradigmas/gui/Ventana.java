package cl.paradigmas.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
@SuppressWarnings("serial")
public class Ventana extends JFrame {
	
	public final static int NINGUNO=0;
	public final static int CIRCULO=1;
	public final static int LINEA=2;
	
	private Canvas canvas;
	private ParadigmasToolBar toolbar;
	private int seleccionado;
	
	public Ventana(){
		this.canvas = new Canvas();
		this.toolbar = new ParadigmasToolBar();
		this.setSize(new Dimension(800,800));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.add(toolbar, BorderLayout.NORTH);
		this.add(canvas, BorderLayout.CENTER);
		this.setSeleccionado(NINGUNO);
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	public ParadigmasToolBar getToolbar() {
		return toolbar;
	}

	public void setToolbar(ParadigmasToolBar toolbar) {
		this.toolbar = toolbar;
	}

	public int getSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(int seleccionado) {
		this.seleccionado = seleccionado;
	}
	
	

}
