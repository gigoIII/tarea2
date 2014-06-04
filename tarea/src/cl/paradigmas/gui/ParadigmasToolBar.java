package cl.paradigmas.gui;

import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

@SuppressWarnings("serial")
public class ParadigmasToolBar extends JToolBar {
	
	private HashMap<String, JToggleButton> botones;
	private JButton btnLimpiar;
	private ButtonGroup grupoBtn;
	
	public ParadigmasToolBar(){
		setFloatable(false);
		setOrientation(JToolBar.HORIZONTAL);
		btnLimpiar = new JButton("LIMPIAR");
		botones = new HashMap<>();
		grupoBtn = new ButtonGroup();
		this.add(btnLimpiar);
	}
	
	public void addBtn(String key, JToggleButton btn){
		botones.put(key, btn);
		addButtonsToToolbar();
	}
	
	public JToggleButton getBtn(String key){
		if(botones.containsKey(key)){
			return botones.get(key);
		}
		return null;
	}
	
	public void removeBtn(String key) {
		if(botones.containsKey(key)) {
			botones.remove(key);
			addButtonsToToolbar();
		}
	}
	
	public void addButtonsToToolbar() {
		this.removeAll();
		this.grupoBtn.clearSelection();
		for (JToggleButton btn : botones.values()) {
			this.add(btn);
			grupoBtn.add(btn);
		}
		this.add(btnLimpiar);
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

}
