package proyecto3.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import proyecto3.Proyecto;



public class PaginaProyectos extends JPanel implements ListSelectionListener{
	
	private PrincipalInterfaz principal;
	private JList<Proyecto> listaProyectos;
	private DefaultListModel<Proyecto> modeloProyectos;
	
	public PaginaProyectos(PrincipalInterfaz interfaz)
	{

		principal = interfaz;
		setBorder(new TitledBorder("Proyectos"));
		setLayout(new BorderLayout());
		modeloProyectos = new DefaultListModel<Proyecto>();
		listaProyectos = new JList<>(modeloProyectos);
		listaProyectos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaProyectos.addListSelectionListener(this);

		JScrollPane panel = new JScrollPane(listaProyectos);
		add(panel);
}
	public void actualizarProyectos(ArrayList<Proyecto> proyectos)
	{
		modeloProyectos.clear();
		for (Proyecto proyecto: proyectos)
		{
			modeloProyectos.addElement(proyecto);
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting())
		{
			Proyecto libro = listaProyectos.getSelectedValue();
			if (libro != null) {
				principal.mostrarProyecto(libro);
		}
		
	}
}
}