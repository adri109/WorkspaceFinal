import java.awt.BorderLayout;
import java.awt.EventQueue;

import com.mysql.cj.xdevapi.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Panel;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Cursor;
import java.awt.Dimension;

public class PantallaPrincipal extends JFrame {

	private JPanel contentPane;
	private CardLayout gestorPantallas;
	
	// Declaración de Paneles del programa
	private JPanel creaEmple;
	private JPanel fichaEmple;
	private JPanel borraEmple;
	private JPanel comisionEmple;
	private JPanel creaSucu;
	private JPanel borraSucu;
	private JPanel fichaSucu;
	private JPanel creaContr;
	private JPanel fichaContr;
	private JPanel tipoContr;
	private JPanel creaCli;
	private JPanel borraCli;
	private JPanel creaInci;
	private JPanel parteAsis;
	private JPanel facturas;
	private JPanel informes;
	public static JTextField txtNomSucu;
	public static JTextField txtDirSucu;
	public static JTextField txtCpSucu;
	public static JTextField txtMunicipioSucu;
	public static JTextField txtCifSucu;
	public static JTextField txtCccSucu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal frame = new PantallaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 1086, 698);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
				JMenu mnuSucursal = new JMenu("Sucursal");
				menuBar.add(mnuSucursal);
				
						JMenuItem submnuCrearSucursal = new JMenuItem("Crear sucursal");
						submnuCrearSucursal.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								gestorPantallas.show(contentPane, "creaSucu");
							}
						});
						mnuSucursal.add(submnuCrearSucursal);
						
								JMenuItem submnuFichasSucursal = new JMenuItem("Ver fichas de sucursal");
								submnuFichasSucursal.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										gestorPantallas.show(contentPane, "fichaSucu");
										fichaSucu.removeAll();
										Connection cnx = Conexion.conectar();
										
										String[] columnNames = {"ID_SUCURSAL","NOMBRE SUCURSAL", "DIRECCIÓN", "CP", "MUNICIPIO", "CIF", "CCC"};
										DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
											@Override
											public Class<?> getColumnClass(int columnIndex) {
												return String.class;
											}
											
											@Override
											public boolean isCellEditable(int row, int column) {
												return column == 1 || column == 2 || column == 3 || column == 4 || column == 5 || column == 6 || column == 7;
											}
										};
										
										JTable table = new JTable(model);
										table.setBackground(Color.white);
										
										JScrollPane scrollPane = new JScrollPane(table);
										scrollPane.setPreferredSize(new Dimension(1000, 400));
										
										fichaSucu.add(scrollPane);
										
										String sql = "SELECT * FROM sucursal";
										

										try {
											java.sql.Statement sentencia = cnx.createStatement();
											ResultSet resultado = ((java.sql.Statement) sentencia).executeQuery(sql);
											while (resultado.next()) {
												String[] ln = new String[8];
												ln[0] = resultado.getString(1);
												ln[1] = resultado.getString(2);
												ln[2] = resultado.getString(3);
												ln[3] = resultado.getString(4);
												ln[4] = resultado.getString(5);
												ln[5] = resultado.getString(6);
												ln[6] = resultado.getString(7);
												model.addRow(ln);
											}
										} catch (SQLException sqlE1) {
											// TODO Auto-generated catch block
											sqlE1.printStackTrace();
										}
										
										table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
										fichaSucu.revalidate();
										fichaSucu.repaint();
									}
								});
								mnuSucursal.add(submnuFichasSucursal);
								
										JMenuItem submnuBorrarSucursal = new JMenuItem("Borrar Sucursal");
										submnuBorrarSucursal.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												gestorPantallas.show(contentPane, "borraSucu");
											}
										});
										mnuSucursal.add(submnuBorrarSucursal);

		JMenu mnuEmpleados = new JMenu("Empleados");
		menuBar.add(mnuEmpleados);

		JMenuItem submnuCrearEmpleado = new JMenuItem("Crear empleado");
		submnuCrearEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestorPantallas.show(contentPane, "creaEmple");
			}
		});
		mnuEmpleados.add(submnuCrearEmpleado);

		JMenuItem submnuFichaEmpleados = new JMenuItem("Ver fichas de empleados");
		submnuFichaEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestorPantallas.show(contentPane, "fichaEmple");
				
			}
		});
		mnuEmpleados.add(submnuFichaEmpleados);

		JMenuItem submnuBorrarEmpleado = new JMenuItem("Borrar empleado");
		submnuBorrarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestorPantallas.show(contentPane, "borraEmple");
			}
		});
		mnuEmpleados.add(submnuBorrarEmpleado);

		JMenuItem submnuComisiones = new JMenuItem("Comisiones");
		submnuComisiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestorPantallas.show(contentPane, "comisionEmple");
			}
		});
		mnuEmpleados.add(submnuComisiones);
		
				JMenu mnuCliente = new JMenu("Clientes");
				menuBar.add(mnuCliente);
				
						JMenuItem submnuAñadirCliente = new JMenuItem("Añadir cliente");
						submnuAñadirCliente.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								gestorPantallas.show(contentPane, "creaCli");
							}
						});
						mnuCliente.add(submnuAñadirCliente);
						
								JMenuItem submnuBorrarCliente = new JMenuItem("Borrar cliente");
								submnuBorrarCliente.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										gestorPantallas.show(contentPane, "borraCli");
									}
								});
								mnuCliente.add(submnuBorrarCliente);

		JMenu mnuContratos = new JMenu("Contratos");
		menuBar.add(mnuContratos);

		JMenuItem submnuContratoNuevo = new JMenuItem("Contrato nuevo");
		submnuContratoNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestorPantallas.show(contentPane, "creaContr");
			}
		});
		mnuContratos.add(submnuContratoNuevo);

		JMenuItem submnuFichasContratos = new JMenuItem("Ver fichas de contrato");
		submnuFichasContratos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestorPantallas.show(contentPane, "fichaContr");
			}
		});
		mnuContratos.add(submnuFichasContratos);

		JMenuItem submnuTipoContrato = new JMenuItem("Añadir tipo de contrato");
		submnuTipoContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestorPantallas.show(contentPane, "tipoContr");
			}
		});
		mnuContratos.add(submnuTipoContrato);

		JMenu mnuIncidencias = new JMenu("Incidencias");
		menuBar.add(mnuIncidencias);


		JMenuItem submnuNuevaIncidencia = new JMenuItem("Nueva incidencia");
		submnuNuevaIncidencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestorPantallas.show(contentPane, "creaInci");
			}
		});
		mnuIncidencias.add(submnuNuevaIncidencia);

		JMenuItem submnuParteAsistencia = new JMenuItem("Parte de asistencia");
		submnuParteAsistencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestorPantallas.show(contentPane, "parteAsis");
			}
		});
		mnuIncidencias.add(submnuParteAsistencia);

		JMenu mnuFacturas = new JMenu("Facturas");
		menuBar.add(mnuFacturas);
		
		JMenuItem submnuPFacturas = new JMenuItem("Panel Facturas");
		submnuPFacturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestorPantallas.show(contentPane, "facturas");
			}
		});
		mnuFacturas.add(submnuPFacturas);

		JMenu mnuInformes = new JMenu("Informes");
		menuBar.add(mnuInformes);
		
		JMenuItem submnuPInformes = new JMenuItem("Panel Informes");
		submnuPInformes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestorPantallas.show(contentPane, "informes");
			}
		});
		mnuInformes.add(submnuPInformes);


		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		gestorPantallas = new CardLayout();
		contentPane.setLayout(gestorPantallas);

		// Panel Crear Empleados
		creaEmple = new JPanel();

		// Panel Crear Empleados
		fichaEmple = new JPanel();

		// Panel Borrar Empleados
		borraEmple = new JPanel();

		// Panel Comisiones Empleados
		comisionEmple = new JPanel();

		// Panel Crear Sucursal
		creaSucu = new JPanel();

		// Panel Ficha Sucursal
		fichaSucu = new JPanel();

		// Panel Borrar Sucursal
		borraSucu = new JPanel();

		// Panel Crea Contrato
		creaContr = new JPanel();

		// Panel Ficha Contrato
		fichaContr = new JPanel();

		// Panel Tipo Contrato Añadir
		tipoContr = new JPanel();

		// Panel Crear Cliente
		creaCli = new JPanel();

		// Panel Borra Clientes
		borraCli = new JPanel();

		// Panel Crea Incidnecia
		creaInci = new JPanel();

		// Panel Parte Asistencia
		parteAsis = new JPanel();

		// Panel Facturas
		facturas = new JPanel();

		// Panel Informes
		informes = new JPanel();

		// Añadir Paneles
		contentPane.add(creaEmple, "creaEmple");
		creaEmple.setLayout(null);
		contentPane.add(fichaEmple, "fichaEmple");
		contentPane.add(borraEmple, "borraEmple");
		contentPane.add(comisionEmple, "comisionEmple");
		contentPane.add(creaSucu, "creaSucu");
		creaSucu.setLayout(null);
		
		Panel panel = new Panel();
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panel.setBackground(new Color(87, 227, 137));
		panel.setForeground(new Color(87, 227, 137));
		panel.setBounds(241, 167, 475, 129);
		creaSucu.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{115, 111, 0, 107, 121, 0};
		gbl_panel.rowHeights = new int[]{19, 0, 19, 19, 25, 25, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNombreSucu = new JLabel("NOMBRE");
		GridBagConstraints gbc_lblNombreSucu = new GridBagConstraints();
		gbc_lblNombreSucu.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreSucu.gridx = 0;
		gbc_lblNombreSucu.gridy = 2;
		panel.add(lblNombreSucu, gbc_lblNombreSucu);
		
		txtNomSucu = new JTextField();
		GridBagConstraints gbc_txtNomSucu = new GridBagConstraints();
		gbc_txtNomSucu.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtNomSucu.insets = new Insets(0, 0, 5, 5);
		gbc_txtNomSucu.gridx = 1;
		gbc_txtNomSucu.gridy = 2;
		panel.add(txtNomSucu, gbc_txtNomSucu);
		txtNomSucu.setColumns(10);
		
		JLabel lblDirSucu = new JLabel("DIRECCIÓN");
		GridBagConstraints gbc_lblDirSucu = new GridBagConstraints();
		gbc_lblDirSucu.insets = new Insets(0, 0, 5, 5);
		gbc_lblDirSucu.gridx = 3;
		gbc_lblDirSucu.gridy = 2;
		panel.add(lblDirSucu, gbc_lblDirSucu);
		
		txtDirSucu = new JTextField();
		GridBagConstraints gbc_txtDirSucu = new GridBagConstraints();
		gbc_txtDirSucu.anchor = GridBagConstraints.NORTH;
		gbc_txtDirSucu.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDirSucu.insets = new Insets(0, 0, 5, 0);
		gbc_txtDirSucu.gridx = 4;
		gbc_txtDirSucu.gridy = 2;
		panel.add(txtDirSucu, gbc_txtDirSucu);
		txtDirSucu.setColumns(10);
		
		JLabel lblCP = new JLabel("C.P.");
		GridBagConstraints gbc_lblCP = new GridBagConstraints();
		gbc_lblCP.insets = new Insets(0, 0, 5, 5);
		gbc_lblCP.gridx = 0;
		gbc_lblCP.gridy = 3;
		panel.add(lblCP, gbc_lblCP);
		
		txtCpSucu = new JTextField();
		GridBagConstraints gbc_txtCpSucu = new GridBagConstraints();
		gbc_txtCpSucu.anchor = GridBagConstraints.NORTH;
		gbc_txtCpSucu.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCpSucu.insets = new Insets(0, 0, 5, 5);
		gbc_txtCpSucu.gridx = 1;
		gbc_txtCpSucu.gridy = 3;
		panel.add(txtCpSucu, gbc_txtCpSucu);
		txtCpSucu.setColumns(10);
		
		JLabel lblMunicipioSucu = new JLabel("MUNICIPIO");
		GridBagConstraints gbc_lblMunicipioSucu = new GridBagConstraints();
		gbc_lblMunicipioSucu.insets = new Insets(0, 0, 5, 5);
		gbc_lblMunicipioSucu.gridx = 3;
		gbc_lblMunicipioSucu.gridy = 3;
		panel.add(lblMunicipioSucu, gbc_lblMunicipioSucu);
		
		txtMunicipioSucu = new JTextField();
		GridBagConstraints gbc_txtMunicipioSucu = new GridBagConstraints();
		gbc_txtMunicipioSucu.anchor = GridBagConstraints.NORTH;
		gbc_txtMunicipioSucu.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMunicipioSucu.insets = new Insets(0, 0, 5, 0);
		gbc_txtMunicipioSucu.gridx = 4;
		gbc_txtMunicipioSucu.gridy = 3;
		panel.add(txtMunicipioSucu, gbc_txtMunicipioSucu);
		txtMunicipioSucu.setColumns(10);
		
		JLabel lblCIF = new JLabel("CIF");
		GridBagConstraints gbc_lblCIF = new GridBagConstraints();
		gbc_lblCIF.insets = new Insets(0, 0, 5, 5);
		gbc_lblCIF.gridx = 0;
		gbc_lblCIF.gridy = 4;
		panel.add(lblCIF, gbc_lblCIF);
		
		txtCifSucu = new JTextField();
		GridBagConstraints gbc_txtCifSucu = new GridBagConstraints();
		gbc_txtCifSucu.anchor = GridBagConstraints.NORTH;
		gbc_txtCifSucu.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCifSucu.insets = new Insets(0, 0, 5, 5);
		gbc_txtCifSucu.gridx = 1;
		gbc_txtCifSucu.gridy = 4;
		panel.add(txtCifSucu, gbc_txtCifSucu);
		txtCifSucu.setColumns(10);
		
		JLabel lblCCC = new JLabel("C.C.C.");
		GridBagConstraints gbc_lblCCC = new GridBagConstraints();
		gbc_lblCCC.insets = new Insets(0, 0, 5, 5);
		gbc_lblCCC.gridx = 3;
		gbc_lblCCC.gridy = 4;
		panel.add(lblCCC, gbc_lblCCC);
		
		txtCccSucu = new JTextField();
		GridBagConstraints gbc_txtCccSucu = new GridBagConstraints();
		gbc_txtCccSucu.anchor = GridBagConstraints.NORTH;
		gbc_txtCccSucu.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCccSucu.insets = new Insets(0, 0, 5, 0);
		gbc_txtCccSucu.gridx = 4;
		gbc_txtCccSucu.gridy = 4;
		panel.add(txtCccSucu, gbc_txtCccSucu);
		txtCccSucu.setColumns(10);
		
		// Acción "Crear Sucursal"
		JButton btnCreaSucu = new JButton("CREAR");
		btnCreaSucu.setBounds(427, 318, 124, 25);
		creaSucu.add(btnCreaSucu);
		btnCreaSucu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inserts.insertSucursal();
			}
		});
		contentPane.add(fichaSucu, "fichaSucu");
		contentPane.add(borraSucu, "borraSucu");
		contentPane.add(creaContr, "creaContr");
		contentPane.add(fichaContr, "fichaContr");
		contentPane.add(tipoContr, "tipoContr");
		contentPane.add(creaCli, "creaCli");
		contentPane.add(borraCli, "borraCli");
		contentPane.add(creaInci,"creaInci");
		contentPane.add(parteAsis, "parteAsis");
		contentPane.add(facturas, "facturas");
		contentPane.add(informes, "informes");

		gestorPantallas.show(contentPane, "fichaEmple");
	}
}