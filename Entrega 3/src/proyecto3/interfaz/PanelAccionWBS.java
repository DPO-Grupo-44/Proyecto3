package proyecto3.interfaz;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PanelAccionWBS extends JPanel implements ChangeListener{
	private JRadioButton radio1, radio2;
	private ButtonGroup grupoBotones;
	
	public PanelAccionWBS() {
		grupoBotones = new ButtonGroup();

        //Añado los 3 radioButton con su ChangeListener
        radio1=new JRadioButton("Paquete");
        radio1.setBounds(10,20,100,30);
        radio1.addChangeListener(this);
        add(radio1);
        grupoBotones.add(radio1);

        radio2=new JRadioButton("Tarea");
        radio2.setBounds(10,70,100,30);
        radio2.addChangeListener(this);
        add(radio2);
        grupoBotones.add(radio2);

  
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}
}

