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
	private JTextField txtAmbitoTrabajador;
	private JTextField txtIncidenciaObj;
	
	//Atributos comision
	JSpinner spnTotalVentas;
	JSpinner spnPorcentajeComi;
	public static JTextField txtNomComision;
	

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
		txtDniEmple.setColumns(10);
		GridBagConstraints gbc_txtDniEmple = new GridBagConstraints();
		gbc_txtDniEmple.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDniEmple.anchor = GridBagConstraints.NORTH;
		gbc_txtDniEmple.insets = new Insets(0, 0, 5, 0);
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
//		String regex = "^(0[1-9]|1\\d|2\\d|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
//		Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(txtFechAlta.getText());
		
		
		
		JLabel lblActivo = new JLabel("ACTIVO");
		GridBagConstraints gbc_lblActivo = new GridBagConstraints();
		gbc_lblActivo.insets = new Insets(0, 0, 5, 5);
		gbc_lblActivo.gridx = 3;
		gbc_lblActivo.gridy = 3;
		panel_1.add(lblActivo, gbc_lblActivo);
		
		chkbxEmpleActivo = new JCheckBox("");
		GridBagConstraints gbc_chkbxEmpleActivo = new GridBagConstraints();
		gbc_chkbxEmpleActivo.insets = new Insets(0, 0, 5, 0);
		gbc_chkbxEmpleActivo.gridx = 4;
		gbc_chkbxEmpleActivo.gridy = 3;
		panel_1.add(chkbxEmpleActivo, gbc_chkbxEmpleActivo);
		
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
		
		JLabel lblNivelComision = new JLabel("NIVEL COMISIÓN");
		GridBagConstraints gbc_lblNivelComision = new GridBagConstraints();
		gbc_lblNivelComision.anchor = GridBagConstraints.EAST;
		gbc_lblNivelComision.insets = new Insets(0, 0, 5, 5);
		gbc_lblNivelComision.gridx = 3;
		gbc_lblNivelComision.gridy = 4;
		panel_1.add(lblNivelComision, gbc_lblNivelComision);
		
		cmbxNivelComision = new JComboBox<String>();
		GridBagConstraints gbc_cmbxNivelComision = new GridBagConstraints();
		gbc_cmbxNivelComision.insets = new Insets(0, 0, 5, 0);
		gbc_cmbxNivelComision.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbxNivelComision.gridx = 4;
		gbc_cmbxNivelComision.gridy = 4;
		panel_1.add(cmbxNivelComision, gbc_cmbxNivelComision);
		
		
		
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
		
		
		
		JButton btnCreaEmple = new JButton("CREAR");
		btnCreaEmple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inserts.insertEmpleado();
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
		btnCrearComi.setBounds(501, 337, 117, 25);
		comisionEmple.add(btnCrearComi);
		contentPane.add(creaSucu, "creaSucu");
		creaSucu.setLayout(null);

		Panel panel = new Panel();
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panel.setBackground(new Color(87, 227, 137));
		panel.setForeground(new Color(87, 227, 137));
		panel.setBounds(241, 157, 492, 129);
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