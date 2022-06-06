package proyecto3.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;




@SuppressWarnings("serial")
public class PanelPrincipalWBS extends JFrame implements ActionListener{
	public final static String Aceptar = "Aceptar cambios";
	private PanelEdicionWBS panelListaWBS;
	private PanelAccionWBS panelAccion;
	private JLabel nombret;
	private JLabel descrt;
	private JTextField nombre;
	private JTextField descr;
	private JButton aceptar;
	
	public PanelPrincipalWBS() {
		
		JPanel panelArriba = new JPanel(new GridLayout(1, 2));
		add(panelArriba, BorderLayout.NORTH);
		JPanel panelIzquierdo = new JPanel(new BorderLayout());
		panelArriba.add(panelIzquierdo);
		panelAccion = new PanelAccionWBS();
		panelIzquierdo.add(panelAccion, BorderLayout.CENTER);
		nombret = new JLabel("Nombre: ");
		descrt = new JLabel("Descripcion: ");
		nombre = new JTextField(" ");
		nombre.setEditable(true);
		descr = new JTextField(" ");
		descr.setEditable(true);
		aceptar = new JButton("Acepar");
		aceptar.setActionCommand(Aceptar);
		aceptar.addActionListener(this);
		JPanel panelCentro = new JPanel(new GridLayout(5,1));
		panelCentro.add(nombret);
		panelCentro.add(nombre);
		panelCentro.add(descrt);
		panelCentro.add(descr);
		panelCentro.add(aceptar);
		add(panelCentro, BorderLayout.CENTER);
		
	

      



      
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Edicion WBS");
		setSize(1000, 700);
		
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
