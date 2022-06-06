package proyecto3.interfaz;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;





@SuppressWarnings("serial")
public class PanelEdicionWBS extends JPanel implements ItemListener{
	
	private String opcion_selec;
	private JComboBox<String> cbbCategorias;
	public PanelEdicionWBS(PanelPrincipalWBS interfaz) {
		
		
		setBorder(new TitledBorder("Categorías"));
		setLayout(new BorderLayout());
		cbbCategorias = new JComboBox<>();
		cbbCategorias.addItemListener(this);
		add(cbbCategorias);
		cbbCategorias.addItem(" ");
		cbbCategorias.addItem("Paquete");
		cbbCategorias.addItem("Tarea");
		
		
	}
	@Override
	public void itemStateChanged(ItemEvent e)
	{
		if (e.getStateChange() == ItemEvent.SELECTED)
		{
			int seleccionado = cbbCategorias.getSelectedIndex();
			if (seleccionado == 0)
			{
				opcion_selec = "Paquete";
			}
			else if(seleccionado == 1){
				opcion_selec = "Tarea";
			}
		}
	}
}
