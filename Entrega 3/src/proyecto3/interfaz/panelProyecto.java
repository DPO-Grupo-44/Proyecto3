package proyecto3.interfaz;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import proyecto3.Proyecto;


public class panelProyecto extends JPanel implements ActionListener{

	public final static String AGREGAR_PARTICIPANTE = "Agregar Participante";
	public final static String AGREGAR_ACTIVIDAD = "Agregar Actividad";



	private Proyecto proyecto;
	private JTextField nombre;
	private JTextField descr;
	private JTextField dueno;
	private JTextField fechai;
	private JTextField fechaf;
	private JButton agregarParticipante;
	private JButton AgregarActividad;
	
	
	public panelProyecto() {
		setBorder(new TitledBorder("Proyecto"));
		nombre = new JTextField(" ");
		nombre.setEditable(false);
		
		descr = new JTextField(" ");
		descr.setEditable(false);
		
		dueno = new JTextField(" ");
		dueno.setEditable(false);
		
		fechai = new JTextField(" ");
		fechai.setEditable(false);
		
		fechaf = new JTextField(" ");
		fechaf.setEditable(false);
		
		agregarParticipante = new JButton(AGREGAR_PARTICIPANTE);
		agregarParticipante.setActionCommand(AGREGAR_PARTICIPANTE);
		agregarParticipante.addActionListener(this);
		
		AgregarActividad = new JButton(AGREGAR_ACTIVIDAD);
		AgregarActividad.setActionCommand(AGREGAR_ACTIVIDAD);
		AgregarActividad.addActionListener(this);
		
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(4, 4, 4, 4), 0, 0);
		
		add(new JLabel("Nombre:"), gc);
		gc.gridy++;
		add(new JLabel("Descripcion:"), gc);
		gc.gridy++;
		add(new JLabel("Dueno:"), gc);
		gc.gridy++;
		add(new JLabel("Fecha Inicio:"), gc);
		gc.gridy++;
		add(new JLabel("Fecha Finalizacion:"), gc);
		gc.gridy++;

		gc.gridx = 1;
		gc.gridy = 0;
		gc.weightx = 10;
		add(nombre, gc);

		gc.gridy++;
		add(descr, gc);

		gc.gridy++;
		add(dueno, gc);
		
		gc.gridy++;
		add(fechai, gc);
		
		gc.gridy++;
		add(fechaf, gc);
		
		gc.gridy++;
		add(agregarParticipante, gc);
		
		gc.gridy++;
		add(AgregarActividad, gc);

		
	}
	
	public void actualizarProyecto(Proyecto nuevolibro)
	{
		proyecto = nuevolibro;
		if (proyecto != null)
		{
			nombre.setText(nuevolibro.getNombre());
			descr.setText(nuevolibro.getDescripcion());
			dueno.setText(nuevolibro.getDueno().getNombre());
			fechai.setText(nuevolibro.getFechaIStr());
			fechaf.setText(nuevolibro.getFechaFStr());
		}
		else
		{
			nombre.setText("");
			descr.setText("");
			dueno.setText("");
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals(AGREGAR_ACTIVIDAD)) {
			
		}
		else if (e.getActionCommand().equals(AGREGAR_PARTICIPANTE)){
			
		}
		
		
	}

}
