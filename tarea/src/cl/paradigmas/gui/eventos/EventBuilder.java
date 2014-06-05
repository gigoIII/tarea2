package cl.paradigmas.gui.eventos;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import cl.paradigmas.gui.Ventana;
import cl.paradigmas.modelo.Circulo;
import cl.paradigmas.modelo.Linea;



final public class EventBuilder  {
	private EventBuilder(){
	}

	public static ActionListener crearLinea(final Ventana v){
		return new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e){
			    v.setSeleccionado(Ventana.LINEA); 	
		    }
		};
	}

	
	public static ActionListener crearCirculo(final Ventana v){	
		return new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				v.setSeleccionado(Ventana.CIRCULO);
			}
		};
	}
	
	public static ActionListener eventoLimpiar(final Ventana v){
		return new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				v.getCanvas().limpiar();
			}
		};
	}
	public static MouseAdapter dibujarLienzo(final Ventana v){
		return new MouseAdapter(){
			
			public void mouseClicked(MouseEvent e){
				if(Ventana.CIRCULO==v.getSeleccionado()){
					Circulo circulo1 = new Circulo(e.getPoint(),50);
					v.getCanvas().addDibujable(circulo1);
					v.getCanvas().repaint();
				}
			}

		    public void mousePressed(MouseEvent e){
		    	if(!v.getCanvas().isDibujandoTmp()&&Ventana.LINEA==v.getSeleccionado()){
		    		Point inicio = e.getPoint();
		    		v.getCanvas().setDibujandoTmp(true);
					Linea linea1=new Linea(inicio,inicio);
					v.getCanvas().setDibujableTmp(linea1);
		    	    v.getCanvas().repaint();
		    	}
		    }
		    
		    public void mouseReleased(MouseEvent e){
		    	if(v.getCanvas().isDibujandoTmp()&&Ventana.LINEA==v.getSeleccionado()){
		    		
					Linea linea1 = (Linea)v.getCanvas().getDibujableTmp();
					linea1.setFin(e.getPoint());
					v.getCanvas().addDibujable(linea1);
					linea1=null;
		    	    v.getCanvas().setDibujandoTmp(false);
		    	    v.getCanvas().repaint();
		    	}
		    }
		    
		    public void mouseDragged(MouseEvent e){
		    	if(v.getCanvas().isDibujandoTmp()&&Ventana.LINEA==v.getSeleccionado()){
		    		
		    		Linea linea1=(Linea)v.getCanvas().getDibujableTmp();
					linea1.setFin(e.getPoint());
		    		v.getCanvas().repaint();
		    	}
		    }
		    
		};
	}
	
}
