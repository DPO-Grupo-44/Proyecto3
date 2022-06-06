package proyecto3.interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import proyecto3.Participante;
import proyecto3.Proyecto;

@SuppressWarnings("serial")
public class CreadorProyectos extends JFrame implements ActionListener {
	
	public final static String CREAR_PROYECTO = "crear proyecto";
	
	private JTextField txtNombreProy;
	private JTextField txtDescr;
	private JTextField txtTipoProy;
	private JTextField txtdueno;
	private JTextField txtcorreo;
	private JTextField txtfechai;
	private JTextField txtfechaf;
	private JTextField tipo;
	private JButton btncrearProy;
	private Proyecto proy;
	
	
	public CreadorProyectos() {
		setBorder(new TitledBorder("Creador de Proyectos"));
		txtNombreProy = new JTextField(" ");
		txtNombreProy.setEditable(true);
		
		txtDescr = new JTextField(" ");
		txtDescr.setEditable(true);
		
		txtdueno = new JTextField(" ");
		txtdueno.setEditable(true);
		
		txtcorreo = new JTextField(" ");
		txtcorreo.setEditable(true);
		
		txtfechai = new JTextField(" ");
		txtfechai.setEditable(true);
		
		txtfechaf = new JTextField(" ");
		txtfechaf.setEditable(true);
		
		tipo = new JTextField(" ");
		tipo.setEditable(true);
		
		btncrearProy = new JButton(CREAR_PROYECTO);
		btncrearProy.setActionCommand(CREAR_PROYECTO);
		btncrearProy.addActionListener(this);

		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(4, 4, 4, 4), 0, 0);
		
		add(new JLabel("Nombre:"), gc);
		gc.gridy++;
		add(new JLabel("Descripcion:"), gc);
		gc.gridy++;
		add(new JLabel("Dueno:"), gc);
		gc.gridy++;
		add(new JLabel("Correo:"), gc);
		gc.gridy++;
		add(new JLabel("Fecha Inicio:"), gc);
		gc.gridy++;
		add(new JLabel("Fecha Finalizacion:"), gc);
		gc.gridy++;
		
		
	
		gc.gridx = 1;
		gc.gridy = 0;
		gc.weightx = 10;
		add(txtNombreProy, gc);

		gc.gridy++;
		add(txtDescr, gc);

		gc.gridy++;
		add(txtdueno, gc);
		
		gc.gridy++;
		add(txtcorreo, gc);
		
		gc.gridy++;
		add(txtfechai, gc);
		
		gc.gridy++;
		add(txtfechaf, gc);
		
		gc.gridy++;
		add(btncrearProy, gc);
		
		setTitle( "Creador de Proyectos" );
		setSize(1000, 700);
		setLocationRelativeTo( null );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		
	}
	
	

	private void setBorder(TitledBorder titledBorder) {
		// TODO Auto-generated method stub
		
	}



	public String darNombre() {
		return txtNombreProy.getText();
	}
	
	public String darDescr() {
		return txtDescr.getText();
	}
	public String darTipo() {
		return txtTipoProy.getText();
	}
	public String darDueno() {
		return txtdueno.getText();
	}
	
	public String darCorreo() {
		return txtcorreo.getText();
	}
	public void limpiar()
	{
		txtNombreProy.setText("");
		txtDescr.setText("");		
		txtTipoProy.setText("");
		txtdueno.setText("");	
	}

	@Override
	public void actionPerformed(ActionEvent eventop) {
		String comando = eventop.getActionCommand( );
		if( comando.equals( CREAR_PROYECTO ) )
		{
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate fechainicio = LocalDate.parse(txtfechai.getText().strip(), formatter);
			LocalDate fechafin = LocalDate.parse(txtfechaf.getText().strip(), formatter);
			Participante dueno = new Participante(darDueno(), darCorreo());
			Proyecto proyecto = new Proyecto(darNombre(), darDescr(), fechainicio, dueno, fechafin);
			proy = proyecto;
			proy.agregarParticipantes(dueno);
			dispose();
		}
		
	}
	
	public Proyecto getProyecto() {
		return proy;
	}

}
