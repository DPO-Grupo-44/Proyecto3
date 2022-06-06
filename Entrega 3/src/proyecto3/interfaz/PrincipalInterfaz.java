package proyecto3.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import proyecto3.CargaDeDatos;
import proyecto3.Laboratorio;
import proyecto3.Principal;
import proyecto3.Proyecto;




@SuppressWarnings("serial")
public class PrincipalInterfaz extends JFrame implements ActionListener{
	
	public final static String CREADOR = "Creador de Nuevos Proyectos";
	public final static String RECARGA = "Recargar el proyecto creado";
	public final static String WBS = "Editar diagrama WBS";
	private PaginaProyectos paginaProyectos;
	private panelProyecto PanelProyecto;
	private CargaDeDatos calculadora;
	private Laboratorio lab;
	private CreadorProyectos creadorProyectos;
	private PanelWBS panelWBS;
	
	public PrincipalInterfaz () throws Exception{
		setLayout( new BorderLayout( ) );
		calculadora = new CargaDeDatos();
		cargarArchivos();
		
		JPanel panelArriba = new JPanel(new GridLayout(1, 2));
		add(panelArriba, BorderLayout.CENTER);
		
		JPanel panelIzquierdo = new JPanel(new BorderLayout());
		panelArriba.add(panelIzquierdo);
		
		paginaProyectos = new PaginaProyectos(this);
		panelIzquierdo.add(paginaProyectos, BorderLayout.CENTER);
		paginaProyectos.actualizarProyectos(lab.getProyectos());
		
		JPanel panelDerecha = new JPanel(new BorderLayout());
		panelArriba.add(panelDerecha);
		PanelProyecto = new panelProyecto();
		panelDerecha.add(PanelProyecto, BorderLayout.NORTH);
		
		panelWBS = new PanelWBS();
		panelDerecha.add(panelWBS, BorderLayout.CENTER);
		
		JPanel panelInferior = new JPanel(new BorderLayout());
		add(panelInferior, BorderLayout.SOUTH);
		JButton btncrearproy = new JButton("Crear Proyecto");
		btncrearproy.setActionCommand(CREADOR);
		btncrearproy.addActionListener(this);
		panelInferior.add(btncrearproy, BorderLayout.WEST);
		
		JButton btnrecargarproy = new JButton("Recargar Proyecto");
		btnrecargarproy.setActionCommand(RECARGA);
		btnrecargarproy.addActionListener(this);
		panelInferior.add(btnrecargarproy, BorderLayout.EAST);
		
		
		
		setTitle( "Proyectos" );
		setSize(1000, 700);
		setLocationRelativeTo( null );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}
	
	public void cargarArchivos() {
		lab = new Laboratorio();
		calculadora.leerArchivo_proyectos(lab);
		calculadora.leerArchivo_participantes(lab);
		
	}
	
	public void mostrarProyecto(Proyecto proy) {
		PanelProyecto.actualizarProyecto(proy);
	}

	
	public static void main( String[] pArgs )
	{
		try
		{
			
			UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

			PrincipalInterfaz interfaz = new PrincipalInterfaz( );
			
			interfaz.setVisible( true );
		}
		catch( Exception e )
		{
			e.printStackTrace( );
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(CREADOR)) {
			creadorProyectos = new CreadorProyectos();
			creadorProyectos.setVisible(true);
			
		}
		else if (e.getActionCommand().equals(RECARGA)) {
			Proyecto proyecto = creadorProyectos.getProyecto();
			lab.agregarProyectos(proyecto);
			paginaProyectos.actualizarProyectos(lab.getProyectos());
		}
	}
	
	
}
