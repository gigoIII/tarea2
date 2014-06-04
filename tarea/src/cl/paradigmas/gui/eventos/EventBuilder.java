package cl.paradigmas.gui.eventos;

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

		    public void mousePressed(MouseEvent e){
		    	if(!v.getCanvas().isDibujandoTmp()){
		    		v.getCanvas().setDibujandoTmp(true);
		    		if(Ventana.LINEA==v.getSeleccionado()){
						Linea linea1=new Linea(e.getPoint(), e.getPoint());
						v.getCanvas().setDibujableTmp(linea1);
					}
		    	    if(Ventana.CIRCULO==v.getSeleccionado()){
		    	    	int radio = 50;
		    	    	Circulo circulo1 = new Circulo(e.getPoint(),radio);
		    	    	v.getCanvas().setDibujableTmp(circulo1);
		    	    }
		    	    v.getCanvas().repaint();
		    	}
		    }
		    
		    public void mouseReleased(MouseEvent e){
		    	if(v.getCanvas().isDibujandoTmp()){
		    		if(Ventana.LINEA==v.getSeleccionado()){
						Linea linea1 = (Linea)v.getCanvas().getDibujableTmp();
						v.getCanvas().setDibujableTmp(null);
						v.getCanvas().addDibujable(linea1);
					}
		    	    if(Ventana.CIRCULO==v.getSeleccionado()){
		    	    	Circulo circulo1 = (Circulo)v.getCanvas().getDibujableTmp();
		    	    	v.getCanvas().setDibujableTmp(null);
						v.getCanvas().addDibujable(circulo1);
		    	    }
		    	    v.getCanvas().setDibujandoTmp(false);
		    	    v.getCanvas().repaint();
		    	}
		    }
		    
		    public void mouseDragged(MouseEvent e){
		    	if(v.getCanvas().isDibujandoTmp()){
		    		if(Ventana.LINEA==v.getSeleccionado()){
		    			Linea linea1=(Linea)v.getCanvas().getDibujableTmp();
						linea1.setFin(e.getPoint());
		    		}
		    		v.getCanvas().repaint();
		    	}
		    }
		    
		};
	}
	
}
