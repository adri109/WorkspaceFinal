import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.Color;

public class PantallaPrincipal extends JFrame {

	private JPanel contentPane;
	private CardLayout gestorPantallas;
	
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

		setBounds(100, 100, 575, 358);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

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
				gestorPantallas.show(contentPane, "creaEmple");
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
		mnuFacturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestorPantallas.show(contentPane, "facturas");
			}
		});
		menuBar.add(mnuFacturas);

		JMenu mnuInformes = new JMenu("Informes");
		mnuInformes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestorPantallas.show(contentPane, "informes");
			}
		});
		menuBar.add(mnuInformes);


		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		gestorPantallas = new CardLayout();
		contentPane.setLayout(gestorPantallas);

		// Panel Crear Empleados
		creaEmple = new JPanel();
		creaEmple.setBackground(Color.BLUE);

		// Panel Crear Empleados
		fichaEmple = new JPanel();
		fichaEmple.setBackground(Color.RED);

		// Panel Borrar Empleados
		borraEmple = new JPanel();
		borraEmple.setBackground(Color.YELLOW);

		// Panel Comisiones Empleados
		comisionEmple = new JPanel();
		comisionEmple.setBackground(Color.ORANGE);

		// Panel Crear Sucursal
		creaSucu = new JPanel();
		creaSucu.setBackground(Color.DARK_GRAY);

		// Panel Ficha Sucursal
		fichaSucu = new JPanel();
		fichaSucu.setBackground(Color.CYAN);

		// Panel Borrar Sucursal
		borraSucu = new JPanel();
		borraSucu.setBackground(Color.LIGHT_GRAY);

		// Panel Crea Contrato
		creaContr = new JPanel();
		creaContr.setBackground(Color.MAGENTA);

		// Panel Ficha Contrato
		fichaContr = new JPanel();
		fichaContr.setBackground(Color.BLACK);

		// Panel Tipo Contrato Añadir
		tipoContr = new JPanel();
		tipoContr.setBackground(Color.GREEN);

		// Panel Crear Cliente
		creaCli = new JPanel();
		creaCli.setBackground(Color.PINK);

		// Panel Borra Clientes
		borraCli = new JPanel();
		borraCli.setBackground(Color.WHITE);

		// Panel Crea Incidnecia
		creaInci = new JPanel();
		creaInci.setBackground(Color.BLUE);

		// Panel Parte Asistencia
		parteAsis = new JPanel();
		parteAsis.setBackground(Color.BLUE);

		// Panel Facturas
		facturas = new JPanel();
		facturas.setBackground(Color.PINK);

		// Panel Informes
		informes = new JPanel();
		informes.setBackground(Color.CYAN);

		// Añadir Paneles
		contentPane.add(creaEmple, "creaEmple");
		contentPane.add(fichaEmple, "fichaEmple");
		contentPane.add(borraEmple, "borraEmple");
		contentPane.add(comisionEmple, "comisionEmple");
		contentPane.add(creaSucu, "creaSucu");
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