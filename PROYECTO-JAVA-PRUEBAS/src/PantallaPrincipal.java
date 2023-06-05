import java.awt.BorderLayout;
import java.awt.EventQueue;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;
import com.mysql.cj.xdevapi.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;


@SuppressWarnings("serial")
public class PantallaPrincipal extends JFrame {

	private JPanel contentPane;
	private CardLayout gestorPantallas;
	
	static Connection cnx = Conexion.conectar();

	// Declaración de Paneles del programa
	private JPanel creaEmple;
	private JPanel fichaEmple;
	private JPanel borraEmple;
	private JPanel comisionEmple;
	private JPanel creaSucu;
	private JPanel fichaSucu;
	private JPanel borraSucu;
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
	private JTextField txtBuscaSucu;
	
	
	
	//Atributos empleado
	public static JTextField txtNomEmple;
	public static JTextField txtDniEmple;
	public static JTextField txtFechAlta;
	public static JTextField txtNivelAsist;
	public static JCheckBox chkbxEmpleActivo;
	public static JComboBox<String> cmbxCodSucu;
	public static JComboBox<String> cmbxNivelComision;
	
	
	//Atributos comision
	public static JSpinner spnTotalVentas;
	public static JSpinner spnPorcentajeComi;
	public static JTextField txtNomComision;
	public static JTextField txtAmbitoTrabajador;
	public static JTextField txtIncidenciaObj;
	
	// CLIENTE
	public static JTextField txtNomCli;
	public static JTextField txtDNICli;
	public static JTextField txtDirecCli;
	public static JTextField txtPoblaCli;
	public static JTextField txtCpCli;
	public static JTextField txtProvCli;
	public static JTextField txtTlfCli;
	

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
				Listar.list(fichaSucu, "sucursal");
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
				comboboxsucu();
				comboboxcomi();
			}
		});
		mnuEmpleados.add(submnuCrearEmpleado);

		JMenuItem submnuFichaEmpleados = new JMenuItem("Ver fichas de empleados");
		submnuFichaEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestorPantallas.show(contentPane, "fichaEmple");
				Listar.list(fichaEmple, "empleado");
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
		
		//EMPLEADO
		
		Panel panel_1 = new Panel();
		panel_1.setForeground(new Color(87, 227, 137));
		panel_1.setBackground(new Color(87, 227, 137));
		panel_1.setBounds(183, 148, 628, 154);
		creaEmple.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{115, 111, 0, 107, 121, 0};
		gbl_panel_1.rowHeights = new int[]{19, 0, 19, 19, 25, 25, 0, 0};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNombreEmple = new JLabel("NOMBRE");
		GridBagConstraints gbc_lblNombreEmple = new GridBagConstraints();
		gbc_lblNombreEmple.anchor = GridBagConstraints.EAST;
		gbc_lblNombreEmple.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreEmple.gridx = 0;
		gbc_lblNombreEmple.gridy = 2;
		panel_1.add(lblNombreEmple, gbc_lblNombreEmple);
		
		txtNomEmple = new JTextField();
		GridBagConstraints gbc_txtNomEmple = new GridBagConstraints();
		gbc_txtNomEmple.insets = new Insets(0, 0, 5, 5);
		gbc_txtNomEmple.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNomEmple.gridx = 1;
		gbc_txtNomEmple.gridy = 2;
		panel_1.add(txtNomEmple, gbc_txtNomEmple);
		txtNomEmple.setColumns(10);
		
		JLabel lblDniEmple = new JLabel("DNI");
		GridBagConstraints gbc_lblDniEmple = new GridBagConstraints();
		gbc_lblDniEmple.insets = new Insets(0, 0, 5, 5);
		gbc_lblDniEmple.gridx = 3;
		gbc_lblDniEmple.gridy = 2;
		panel_1.add(lblDniEmple, gbc_lblDniEmple);
		
		txtDniEmple = new JTextField();
		txtDniEmple.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if (txtDniEmple.getText().length()== 9) { 

			         e.consume();
			}
			
			}
		});
		txtDniEmple.setColumns(10);
		GridBagConstraints gbc_txtDniEmple = new GridBagConstraints();
		gbc_txtDniEmple.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDniEmple.anchor = GridBagConstraints.NORTH;
		gbc_txtDniEmple.insets = new Insets(0, 0, 5, 5);
		gbc_txtDniEmple.gridx = 4;
		gbc_txtDniEmple.gridy = 2;
		panel_1.add(txtDniEmple, gbc_txtDniEmple);
		
		JLabel lblFechAlta = new JLabel("FECHA ALTA");
		GridBagConstraints gbc_lblFechAlta = new GridBagConstraints();
		gbc_lblFechAlta.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechAlta.gridx = 0;
		gbc_lblFechAlta.gridy = 3;
		panel_1.add(lblFechAlta, gbc_lblFechAlta);
		
		
		
		
		txtFechAlta = new JTextField();
		txtFechAlta.setColumns(10);
		GridBagConstraints gbc_txtFechAlta = new GridBagConstraints();
		gbc_txtFechAlta.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFechAlta.anchor = GridBagConstraints.NORTH;
		gbc_txtFechAlta.insets = new Insets(0, 0, 5, 5);
		gbc_txtFechAlta.gridx = 1;
		gbc_txtFechAlta.gridy = 3;
		panel_1.add(txtFechAlta, gbc_txtFechAlta);
		
		JLabel lblNivelAsist = new JLabel("NIVEL ASISTENCIA");
		GridBagConstraints gbc_lblNivelAsist = new GridBagConstraints();
		gbc_lblNivelAsist.anchor = GridBagConstraints.EAST;
		gbc_lblNivelAsist.insets = new Insets(0, 0, 5, 5);
		gbc_lblNivelAsist.gridx = 0;
		gbc_lblNivelAsist.gridy = 4;
		panel_1.add(lblNivelAsist, gbc_lblNivelAsist);
		
		txtNivelAsist = new JTextField();
		GridBagConstraints gbc_txtNivelAsist = new GridBagConstraints();
		gbc_txtNivelAsist.insets = new Insets(0, 0, 5, 5);
		gbc_txtNivelAsist.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNivelAsist.gridx = 1;
		gbc_txtNivelAsist.gridy = 4;
		panel_1.add(txtNivelAsist, gbc_txtNivelAsist);
		txtNivelAsist.setColumns(10);
		//		String regex = "^(0[1-9]|1\\d|2\\d|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
		//		Pattern pattern = Pattern.compile(regex);
		//        Matcher matcher = pattern.matcher(txtFechAlta.getText());
				
				
				
				JLabel lblActivo = new JLabel("ACTIVO");
				GridBagConstraints gbc_lblActivo = new GridBagConstraints();
				gbc_lblActivo.insets = new Insets(0, 0, 5, 5);
				gbc_lblActivo.gridx = 3;
				gbc_lblActivo.gridy = 4;
				panel_1.add(lblActivo, gbc_lblActivo);
		
		chkbxEmpleActivo = new JCheckBox("");
		GridBagConstraints gbc_chkbxEmpleActivo = new GridBagConstraints();
		gbc_chkbxEmpleActivo.insets = new Insets(0, 0, 5, 5);
		gbc_chkbxEmpleActivo.gridx = 4;
		gbc_chkbxEmpleActivo.gridy = 4;
		panel_1.add(chkbxEmpleActivo, gbc_chkbxEmpleActivo);
		
		
		
		JLabel lblCodSucuEmple = new JLabel("SUCURSAL");
		GridBagConstraints gbc_lblCodSucuEmple = new GridBagConstraints();
		gbc_lblCodSucuEmple.anchor = GridBagConstraints.EAST;
		gbc_lblCodSucuEmple.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodSucuEmple.gridx = 0;
		gbc_lblCodSucuEmple.gridy = 5;
		panel_1.add(lblCodSucuEmple, gbc_lblCodSucuEmple);
		
		cmbxCodSucu = new JComboBox<String>();
		GridBagConstraints gbc_cmbxCodSucu = new GridBagConstraints();
		gbc_cmbxCodSucu.insets = new Insets(0, 0, 5, 5);
		gbc_cmbxCodSucu.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbxCodSucu.gridx = 1;
		gbc_cmbxCodSucu.gridy = 5;
		panel_1.add(cmbxCodSucu, gbc_cmbxCodSucu);
		
		JLabel lblNivelComision = new JLabel("NIVEL COMISIÓN");
		GridBagConstraints gbc_lblNivelComision = new GridBagConstraints();
		gbc_lblNivelComision.anchor = GridBagConstraints.EAST;
		gbc_lblNivelComision.insets = new Insets(0, 0, 5, 5);
		gbc_lblNivelComision.gridx = 3;
		gbc_lblNivelComision.gridy = 5;
		panel_1.add(lblNivelComision, gbc_lblNivelComision);
		
		cmbxNivelComision = new JComboBox<String>();
		GridBagConstraints gbc_cmbxNivelComision = new GridBagConstraints();
		gbc_cmbxNivelComision.insets = new Insets(0, 0, 5, 5);
		gbc_cmbxNivelComision.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbxNivelComision.gridx = 4;
		gbc_cmbxNivelComision.gridy = 5;
		panel_1.add(cmbxNivelComision, gbc_cmbxNivelComision);
		
		
		
		JButton btnCreaEmple = new JButton("CREAR");
		btnCreaEmple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtDniEmple.getText().length()== 9) {
					Inserts.insertEmpleado();
				}else {
					JOptionPane.showMessageDialog(null, "LONGITUD DE DNI NO VÁLIDO");
				}
				
			}
		});
		btnCreaEmple.setBounds(490, 327, 117, 25);
		creaEmple.add(btnCreaEmple);
		contentPane.add(fichaEmple, "fichaEmple");
		contentPane.add(borraEmple, "borraEmple");
		contentPane.add(comisionEmple, "comisionEmple");
		comisionEmple.setLayout(null);
		
		//COMISIONES
		
		Panel panel_Comisiones = new Panel();
		panel_Comisiones.setBounds(227, 121, 637, 170);
		panel_Comisiones.setForeground(new Color(87, 227, 137));
		panel_Comisiones.setBackground(new Color(87, 227, 137));
		comisionEmple.add(panel_Comisiones);
		GridBagLayout gbl_panel_Comisiones = new GridBagLayout();
		gbl_panel_Comisiones.columnWidths = new int[]{115, 111, 0, 136, 121, 0, 0};
		gbl_panel_Comisiones.rowHeights = new int[]{0, 19, 19, 0, 25, 0, 0};
		gbl_panel_Comisiones.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_Comisiones.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_Comisiones.setLayout(gbl_panel_Comisiones);
		
		JLabel lblNivelComi = new JLabel("NIVEL COMISIÓN");
		GridBagConstraints gbc_lblNivelComi = new GridBagConstraints();
		gbc_lblNivelComi.anchor = GridBagConstraints.EAST;
		gbc_lblNivelComi.insets = new Insets(0, 0, 5, 5);
		gbc_lblNivelComi.gridx = 0;
		gbc_lblNivelComi.gridy = 2;
		panel_Comisiones.add(lblNivelComi, gbc_lblNivelComi);
		
		
		
		txtNomComision = new JTextField();
		GridBagConstraints gbc_txtNomComision = new GridBagConstraints();
		gbc_txtNomComision.insets = new Insets(0, 0, 5, 5);
		gbc_txtNomComision.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNomComision.gridx = 1;
		gbc_txtNomComision.gridy = 2;
		panel_Comisiones.add(txtNomComision, gbc_txtNomComision);
		txtNomComision.setColumns(10);
		
		JLabel lblTotalVentas = new JLabel("TOTAL VENTAS");
		GridBagConstraints gbc_lblTotalVentas = new GridBagConstraints();
		gbc_lblTotalVentas.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalVentas.gridx = 3;
		gbc_lblTotalVentas.gridy = 2;
		panel_Comisiones.add(lblTotalVentas, gbc_lblTotalVentas);
		
		
		SpinnerNumberModel model =new SpinnerNumberModel();
		model.setMinimum(0);
		SpinnerNumberModel model2 =new SpinnerNumberModel();
		model2.setMinimum(0);
		
		
		spnTotalVentas = new JSpinner();
		spnTotalVentas.setModel(model);
		GridBagConstraints gbc_spnTotalVentas = new GridBagConstraints();
		gbc_spnTotalVentas.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnTotalVentas.insets = new Insets(0, 0, 5, 5);
		gbc_spnTotalVentas.gridx = 4;
		gbc_spnTotalVentas.gridy = 2;
		panel_Comisiones.add(spnTotalVentas, gbc_spnTotalVentas);
		
		JLabel lblAmbitoTrabajador = new JLabel("AMBITO TRABAJADOR");
		GridBagConstraints gbc_lblAmbitoTrabajador = new GridBagConstraints();
		gbc_lblAmbitoTrabajador.insets = new Insets(0, 0, 5, 5);
		gbc_lblAmbitoTrabajador.gridx = 0;
		gbc_lblAmbitoTrabajador.gridy = 3;
		panel_Comisiones.add(lblAmbitoTrabajador, gbc_lblAmbitoTrabajador);
		
		txtAmbitoTrabajador = new JTextField();
		txtAmbitoTrabajador.setColumns(10);
		GridBagConstraints gbc_txtAmbitoTrabajador = new GridBagConstraints();
		gbc_txtAmbitoTrabajador.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAmbitoTrabajador.anchor = GridBagConstraints.NORTH;
		gbc_txtAmbitoTrabajador.insets = new Insets(0, 0, 5, 5);
		gbc_txtAmbitoTrabajador.gridx = 1;
		gbc_txtAmbitoTrabajador.gridy = 3;
		panel_Comisiones.add(txtAmbitoTrabajador, gbc_txtAmbitoTrabajador);
		
		JLabel lblPorcentajeComision = new JLabel("% COMISIÓN");
		GridBagConstraints gbc_lblPorcentajeComision = new GridBagConstraints();
		gbc_lblPorcentajeComision.insets = new Insets(0, 0, 5, 5);
		gbc_lblPorcentajeComision.gridx = 3;
		gbc_lblPorcentajeComision.gridy = 3;
		panel_Comisiones.add(lblPorcentajeComision, gbc_lblPorcentajeComision);
		
		
		spnPorcentajeComi = new JSpinner();
		spnPorcentajeComi.setModel(model2);
		GridBagConstraints gbc_spnPorcentajeComi = new GridBagConstraints();
		gbc_spnPorcentajeComi.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnPorcentajeComi.insets = new Insets(0, 0, 5, 5);
		gbc_spnPorcentajeComi.gridx = 4;
		gbc_spnPorcentajeComi.gridy = 3;
		panel_Comisiones.add(spnPorcentajeComi, gbc_spnPorcentajeComi);
		
		JLabel lblIncidenciaObjetivo = new JLabel("INCIDENCIA OBJETIVO");
		GridBagConstraints gbc_lblIncidenciaObjetivo = new GridBagConstraints();
		gbc_lblIncidenciaObjetivo.anchor = GridBagConstraints.EAST;
		gbc_lblIncidenciaObjetivo.insets = new Insets(0, 0, 5, 5);
		gbc_lblIncidenciaObjetivo.gridx = 0;
		gbc_lblIncidenciaObjetivo.gridy = 4;
		panel_Comisiones.add(lblIncidenciaObjetivo, gbc_lblIncidenciaObjetivo);
		
		txtIncidenciaObj = new JTextField();
		txtIncidenciaObj.setColumns(10);
		GridBagConstraints gbc_txtIncidenciaObj = new GridBagConstraints();
		gbc_txtIncidenciaObj.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIncidenciaObj.insets = new Insets(0, 0, 5, 5);
		gbc_txtIncidenciaObj.gridx = 1;
		gbc_txtIncidenciaObj.gridy = 4;
		panel_Comisiones.add(txtIncidenciaObj, gbc_txtIncidenciaObj);
		
		JButton btnCrearComi = new JButton("CREAR");
		btnCrearComi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inserts.insertComision();
			}
		});
		btnCrearComi.setBounds(501, 337, 117, 25);
		comisionEmple.add(btnCrearComi);
		contentPane.add(creaSucu, "creaSucu");
		creaSucu.setLayout(null);

		Panel panel = new Panel();
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panel.setBackground(new Color(87, 227, 137));
		panel.setForeground(new Color(87, 227, 137));
		panel.setBounds(163, 157, 685, 190);
		creaSucu.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{115, 111, 0, 107, 210, 0};
		gbl_panel.rowHeights = new int[]{19, 0, 19, 19, 25, 25, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNoSeDebe = new JLabel("No se debe dejar ningún campo vacío");
		lblNoSeDebe.setFont(new Font("Dialog", Font.BOLD, 10));
		GridBagConstraints gbc_lblNoSeDebe = new GridBagConstraints();
		gbc_lblNoSeDebe.insets = new Insets(0, 0, 5, 5);
		gbc_lblNoSeDebe.gridx = 1;
		gbc_lblNoSeDebe.gridy = 0;
		panel.add(lblNoSeDebe, gbc_lblNoSeDebe);

		JLabel lblNombreSucu = new JLabel("NOMBRE");
		GridBagConstraints gbc_lblNombreSucu = new GridBagConstraints();
		gbc_lblNombreSucu.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreSucu.gridx = 0;
		gbc_lblNombreSucu.gridy = 2;
		panel.add(lblNombreSucu, gbc_lblNombreSucu);

		txtNomSucu = new JTextField();
		GridBagConstraints gbc_txtNomSucu = new GridBagConstraints();
		gbc_txtNomSucu.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNomSucu.anchor = GridBagConstraints.NORTH;
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
		txtCpSucu.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if (txtCpSucu.getText().length()== 5) {
					e.consume();
				}
				
				if(txtCpSucu.getText().length()<= 4) {
					txtCpSucu.setBackground(Color.RED);
				}else if(txtCpSucu.getText().length()== 5) {
					txtCpSucu.setBackground(Color.WHITE);
				}

			         
			}
			
		});
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
		
		JLabel lblCarcteresExactos_1 = new JLabel("5 carácteres exactos");
		lblCarcteresExactos_1.setFont(new Font("Dialog", Font.BOLD, 10));
		GridBagConstraints gbc_lblCarcteresExactos_1 = new GridBagConstraints();
		gbc_lblCarcteresExactos_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCarcteresExactos_1.gridx = 1;
		gbc_lblCarcteresExactos_1.gridy = 4;
		panel.add(lblCarcteresExactos_1, gbc_lblCarcteresExactos_1);
						
								txtCifSucu = new JTextField();
								txtCifSucu.addKeyListener(new KeyAdapter() {
									@Override
									public void keyTyped(KeyEvent e) {
										
										if (txtCifSucu.getText().length()== 9) {
											e.consume();
										}

									         if(txtCifSucu.getText().length()< 9) {
									        	 txtCifSucu.setBackground(Color.red);	 
												}else {
													txtCifSucu.setBackground(Color.WHITE);
												}
										
									}
								});
								
										JLabel lblCIF = new JLabel("CIF");
										GridBagConstraints gbc_lblCIF = new GridBagConstraints();
										gbc_lblCIF.insets = new Insets(0, 0, 5, 5);
										gbc_lblCIF.gridx = 0;
										gbc_lblCIF.gridy = 5;
										panel.add(lblCIF, gbc_lblCIF);
								GridBagConstraints gbc_txtCifSucu = new GridBagConstraints();
								gbc_txtCifSucu.anchor = GridBagConstraints.NORTH;
								gbc_txtCifSucu.fill = GridBagConstraints.HORIZONTAL;
								gbc_txtCifSucu.insets = new Insets(0, 0, 5, 5);
								gbc_txtCifSucu.gridx = 1;
								gbc_txtCifSucu.gridy = 5;
								panel.add(txtCifSucu, gbc_txtCifSucu);
								txtCifSucu.setColumns(10);
								
										txtCccSucu = new JTextField();
										txtCccSucu.addKeyListener(new KeyAdapter() {
											@Override
											public void keyTyped(KeyEvent e) {
												
												if (txtCccSucu.getText().length()== 24) {
													e.consume();
												}
												if(txtCccSucu.getText().length()< 24) {
													txtCccSucu.setBackground(Color.red);	 
													}else {
														txtCccSucu.setBackground(Color.WHITE);
													}
												
											}
										});
										
												JLabel lblCCC = new JLabel("C.C.C.");
												GridBagConstraints gbc_lblCCC = new GridBagConstraints();
												gbc_lblCCC.insets = new Insets(0, 0, 5, 5);
												gbc_lblCCC.gridx = 3;
												gbc_lblCCC.gridy = 5;
												panel.add(lblCCC, gbc_lblCCC);
										GridBagConstraints gbc_txtCccSucu = new GridBagConstraints();
										gbc_txtCccSucu.anchor = GridBagConstraints.NORTH;
										gbc_txtCccSucu.fill = GridBagConstraints.HORIZONTAL;
										gbc_txtCccSucu.insets = new Insets(0, 0, 5, 0);
										gbc_txtCccSucu.gridx = 4;
										gbc_txtCccSucu.gridy = 5;
										panel.add(txtCccSucu, gbc_txtCccSucu);
										txtCccSucu.setColumns(10);
								
								JLabel lblCarcteresExactos = new JLabel("9 carácteres exactos");
								lblCarcteresExactos.setFont(new Font("Dialog", Font.BOLD, 10));
								GridBagConstraints gbc_lblCarcteresExactos = new GridBagConstraints();
								gbc_lblCarcteresExactos.insets = new Insets(0, 0, 0, 5);
								gbc_lblCarcteresExactos.gridx = 1;
								gbc_lblCarcteresExactos.gridy = 6;
								panel.add(lblCarcteresExactos, gbc_lblCarcteresExactos);
								
								JLabel lblCarcteresSin = new JLabel("24 carácteres sin espacios");
								lblCarcteresSin.setFont(new Font("Dialog", Font.BOLD, 10));
								GridBagConstraints gbc_lblCarcteresSin = new GridBagConstraints();
								gbc_lblCarcteresSin.gridx = 4;
								gbc_lblCarcteresSin.gridy = 6;
								panel.add(lblCarcteresSin, gbc_lblCarcteresSin);

		// Acción "Crear Sucursal"
		JButton btnCreaSucu = new JButton("CREAR");
		btnCreaSucu.setBounds(422, 353, 124, 25);
		creaSucu.add(btnCreaSucu);
		btnCreaSucu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtCifSucu.getText().length()== 9 && txtCpSucu.getText().length()== 5 && txtCccSucu.getText().length()== 24 
						&& txtNomSucu.getText().length() > 0 && txtDirSucu.getText().length() > 0 && txtMunicipioSucu.getText().length() > 0 ) {
					Inserts.insertSucursal(); 
					
				}else if(txtCifSucu.getText().length() != 9) {
					JOptionPane.showMessageDialog(null, "ERROR EN LA LONGITUD DEL CIF DE LA SUCURSAL");
				}else if(txtCpSucu.getText().length() != 5) {
					JOptionPane.showMessageDialog(null, "ERROR EN LA LONGITUD DEL CÓDIGO POSTAL DE LA SUCURSAL");
				}else if(txtCccSucu.getText().length() != 24) {
					JOptionPane.showMessageDialog(null, "ERROR EN LA LONGITUD DEL CCC DE LA SUCURSAL");
				}else if(txtNomSucu.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "ERROR EN LA LONGITUD DEL NOMBRE DE LA SUCURSAL");
				}else if(txtDirSucu.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "ERROR EN LA LONGITUD DE LA DIRECCIÓN DE LA SUCURSAL");
				}else if(txtMunicipioSucu.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "ERROR EN LA LONGITUD DEL MUNICIPIO DE LA SUCURSAL");
				}
				
				
			}
		});
		
		contentPane.add(fichaSucu, "fichaSucu");
		
				// Panel Borrar Sucursal
				borraSucu = new JPanel();
				contentPane.add(borraSucu, "borraSucu");
				
				JButton btnBuscaSucu = new JButton("Buscar");
				btnBuscaSucu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Buscar.sucursal(borraSucu, txtBuscaSucu, btnBuscaSucu);
					}
				});
				
				txtBuscaSucu = new JTextField();
				borraSucu.add(txtBuscaSucu);
				txtBuscaSucu.setColumns(10);
				borraSucu.add(btnBuscaSucu);
				
				
				
		contentPane.add(creaContr, "creaContr");
		contentPane.add(fichaContr, "fichaContr");
		contentPane.add(tipoContr, "tipoContr");
		contentPane.add(creaCli, "creaCli");
		creaCli.setLayout(null);
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(261, 113, 495, 181);
		panel_2.setForeground(new Color(87, 227, 137));
		panel_2.setBackground(new Color(87, 227, 137));
		creaCli.add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{115, 111, 98, 109, 0};
		gbl_panel_2.rowHeights = new int[]{19, 0, 0, 0, 0, 14, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNomCli = new JLabel("Nombre Cliente");
		GridBagConstraints gbc_lblNomCli = new GridBagConstraints();
		gbc_lblNomCli.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomCli.gridx = 0;
		gbc_lblNomCli.gridy = 1;
		panel_2.add(lblNomCli, gbc_lblNomCli);
		
		txtNomCli = new JTextField();
		GridBagConstraints gbc_txtNomCli = new GridBagConstraints();
		gbc_txtNomCli.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNomCli.insets = new Insets(0, 0, 5, 5);
		gbc_txtNomCli.gridx = 1;
		gbc_txtNomCli.gridy = 1;
		panel_2.add(txtNomCli, gbc_txtNomCli);
		txtNomCli.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CP");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 1;
		panel_2.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtCpCli = new JTextField();
		GridBagConstraints gbc_txtCpCli = new GridBagConstraints();
		gbc_txtCpCli.insets = new Insets(0, 0, 5, 0);
		gbc_txtCpCli.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCpCli.gridx = 3;
		gbc_txtCpCli.gridy = 1;
		panel_2.add(txtCpCli, gbc_txtCpCli);
		txtCpCli.setColumns(10);
		
		JLabel lblDNICli = new JLabel("DNI");
		GridBagConstraints gbc_lblDNICli = new GridBagConstraints();
		gbc_lblDNICli.insets = new Insets(0, 0, 5, 5);
		gbc_lblDNICli.gridx = 0;
		gbc_lblDNICli.gridy = 2;
		panel_2.add(lblDNICli, gbc_lblDNICli);
		
		txtDNICli = new JTextField();
		txtDNICli.setText("");
		GridBagConstraints gbc_txtDNICli = new GridBagConstraints();
		gbc_txtDNICli.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDNICli.insets = new Insets(0, 0, 5, 5);
		gbc_txtDNICli.gridx = 1;
		gbc_txtDNICli.gridy = 2;
		panel_2.add(txtDNICli, gbc_txtDNICli);
		txtDNICli.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Provincia");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 2;
		panel_2.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txtProvCli = new JTextField();
		GridBagConstraints gbc_txtProvCli = new GridBagConstraints();
		gbc_txtProvCli.insets = new Insets(0, 0, 5, 0);
		gbc_txtProvCli.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtProvCli.gridx = 3;
		gbc_txtProvCli.gridy = 2;
		panel_2.add(txtProvCli, gbc_txtProvCli);
		txtProvCli.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Dirección");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		panel_2.add(lblNewLabel, gbc_lblNewLabel);
		
		txtDirecCli = new JTextField();
		GridBagConstraints gbc_txtDirecCli = new GridBagConstraints();
		gbc_txtDirecCli.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDirecCli.insets = new Insets(0, 0, 5, 5);
		gbc_txtDirecCli.gridx = 1;
		gbc_txtDirecCli.gridy = 3;
		panel_2.add(txtDirecCli, gbc_txtDirecCli);
		txtDirecCli.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Tlf");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 3;
		panel_2.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		txtTlfCli = new JTextField();
		GridBagConstraints gbc_txtTlfCli = new GridBagConstraints();
		gbc_txtTlfCli.insets = new Insets(0, 0, 5, 0);
		gbc_txtTlfCli.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTlfCli.gridx = 3;
		gbc_txtTlfCli.gridy = 3;
		panel_2.add(txtTlfCli, gbc_txtTlfCli);
		txtTlfCli.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Población");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 4;
		panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtPoblaCli = new JTextField();
		GridBagConstraints gbc_txtPoblaCli = new GridBagConstraints();
		gbc_txtPoblaCli.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPoblaCli.insets = new Insets(0, 0, 5, 5);
		gbc_txtPoblaCli.gridx = 1;
		gbc_txtPoblaCli.gridy = 4;
		panel_2.add(txtPoblaCli, gbc_txtPoblaCli);
		txtPoblaCli.setColumns(10);
		contentPane.add(borraCli, "borraCli");
		contentPane.add(creaInci,"creaInci");
		contentPane.add(parteAsis, "parteAsis");
		contentPane.add(facturas, "facturas");
		contentPane.add(informes, "informes");
		
		gestorPantallas.show(contentPane, "fichaEmple");
	}
	public static void comboboxsucu() {
String sql = "SELECT nombre FROM sucursal";
		
		try {
			java.sql.Statement sentencia =cnx.createStatement();
			ResultSet resultado = sentencia.executeQuery(sql);
			while (resultado.next()) {
				String[] ln = new String[8];
				ln[0] = resultado.getString(1);
				cmbxCodSucu.addItem(ln[0]);
			}
		}
		catch(Exception e) {
			
		}
	}
	public static void comboboxcomi() {
		//HACER CONSULTA PARA OBTENER LOS NIVELES DE COMISION
		String sqlNivelComi = "SELECT nivel_comision FROM comision";
		
		try {
			java.sql.Statement sentencia = cnx.createStatement();
			ResultSet resultado = sentencia.executeQuery(sqlNivelComi);
			while (resultado.next()) {
				String[] ln = new String[8];
				ln[0] = resultado.getString(1);
				cmbxNivelComision.addItem(ln[0]);
			}
		}
		catch(Exception e) {
			
		}
	}
}