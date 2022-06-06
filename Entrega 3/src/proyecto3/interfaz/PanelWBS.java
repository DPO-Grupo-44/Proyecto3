package proyecto3.interfaz;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class PanelWBS extends JPanel{

	private JTree arbol;
	
	public PanelWBS() {
		setBorder(new TitledBorder("Modelo WBS"));
		DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Raiz");
		DefaultTreeModel modelo = new DefaultTreeModel(raiz);
		
		arbol =	new JTree(modelo);
		
		setLayout(new BorderLayout());
		add(arbol, BorderLayout.CENTER);
		
		
	}
}
