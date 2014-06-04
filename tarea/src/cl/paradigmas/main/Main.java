package cl.paradigmas.main;

import java.awt.event.MouseAdapter;

import javax.swing.JToggleButton;

import cl.paradigmas.gui.Ventana;
import cl.paradigmas.gui.eventos.EventBuilder;


public class Main {
	
	public static void main(String[] args) {
		Ventana ventana = new Ventana();
		
		ventana.getToolbar().getBtnLimpiar().addActionListener(EventBuilder.eventoLimpiar(ventana));
		ventana.getToolbar().addBtn("LINEA", new JToggleButton("LINEA"));
		ventana.getToolbar().addBtn("CIRCULO", new JToggleButton("CIRCULO"));
		ventana.getToolbar().getBtn("LINEA").addActionListener(EventBuilder.crearLinea(ventana));
		ventana.getToolbar().getBtn("CIRCULO").addActionListener(EventBuilder.crearCirculo(ventana));
		MouseAdapter raton=EventBuilder.dibujarLienzo(ventana);
		ventana.getCanvas().addMouseMotionListener(raton);
		ventana.getCanvas().addMouseListener(raton);
		
		ventana.setVisible(true);
	}

}
