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

			}
		});
		mnuEmpleados.add(submnuCrearEmpleado);

		JMenuItem submnuFichaEmpleados = new JMenuItem("Ver fichas de empleados");
		mnuEmpleados.add(submnuFichaEmpleados);

		JMenuItem submnuBorrarEmpleado = new JMenuItem("Borrar empleado");
		mnuEmpleados.add(submnuBorrarEmpleado);

		JMenuItem submnuComisiones = new JMenuItem("Comisiones");
		mnuEmpleados.add(submnuComisiones);

		JMenu mnuSucursal = new JMenu("Sucursal");
		menuBar.add(mnuSucursal);

		JMenuItem submnuCrearSucursal = new JMenuItem("Crear sucursal");
		mnuSucursal.add(submnuCrearSucursal);

		JMenuItem submnuFichasSucursal = new JMenuItem("Ver fichas de sucursal");
		mnuSucursal.add(submnuFichasSucursal);

		JMenuItem submnuBorrarSucursal = new JMenuItem("Borrar Sucursal");
		mnuSucursal.add(submnuBorrarSucursal);

		JMenu mnuContratos = new JMenu("Contratos");
		menuBar.add(mnuContratos);

		JMenuItem submnuContratoNuevo = new JMenuItem("Contrato nuevo");
		mnuContratos.add(submnuContratoNuevo);

		JMenuItem submnuFichasContratos = new JMenuItem("Ver fichas de contrato");
		mnuContratos.add(submnuFichasContratos);

		JMenuItem submnuTipoContrato = new JMenuItem("Añadir tipo de contrato");
		mnuContratos.add(submnuTipoContrato);

		JMenu mnuCliente = new JMenu("Clientes");
		menuBar.add(mnuCliente);

		JMenuItem submnuAñadirCliente = new JMenuItem("Añadir cliente");
		mnuCliente.add(submnuAñadirCliente);

		JMenuItem submnuBorrarCliente = new JMenuItem("Borrar cliente");
		mnuCliente.add(submnuBorrarCliente);

		JMenu mnuIncidencias = new JMenu("Incidencias");
		menuBar.add(mnuIncidencias);


		JMenuItem submnuNuevaIncidencia = new JMenuItem("Nueva incidencia");
		mnuIncidencias.add(submnuNuevaIncidencia);

		JMenuItem submnuParteAsistencia = new JMenuItem("Parte de asistencia");
		mnuIncidencias.add(submnuParteAsistencia);

		JMenu mnuFacturas = new JMenu("Facturas");
		menuBar.add(mnuFacturas);

		JMenu mnuInformes = new JMenu("Informes");
		menuBar.add(mnuInformes);


		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		gestorPantallas = new CardLayout();
		contentPane.setLayout(gestorPantallas);

		// Panel Crear Empleados
		JPanel creaEmple = new JPanel();
		creaEmple.setBackground(Color.BLUE);

		// Panel Crear Empleados
		JPanel fichaEmple = new JPanel();
		fichaEmple.setBackground(Color.RED);

		// Panel Borrar Empleados
		JPanel borraEmple = new JPanel();
		borraEmple.setBackground(Color.YELLOW);

		// Panel Comisiones Empleados
		JPanel comisionEmple = new JPanel();
		comisionEmple.setBackground(Color.BLUE);

		// Panel Crear Sucursal
		JPanel creaSucu = new JPanel();
		creaSucu.setBackground(Color.BLUE);

		// Panel Ficha Sucursal
		JPanel fichaSucu = new JPanel();
		fichaSucu.setBackground(Color.CYAN);

		// Panel Borrar Sucursal
		JPanel borraSucu = new JPanel();
		borraSucu.setBackground(Color.BLUE);

		// Panel Crea Contrato
		JPanel creaContr = new JPanel();
		creaContr.setBackground(Color.BLUE);

		// Panel Ficha Contrato
		JPanel fichaContr = new JPanel();
		fichaContr.setBackground(Color.BLUE);

		// Panel Tipo Contrato Añadir
		JPanel tipoContr = new JPanel();
		tipoContr.setBackground(Color.BLUE);

		// Panel Crear Cliente
		JPanel creaCli = new JPanel();
		creaCli.setBackground(Color.BLUE);

		// Panel Borra Clientes
		JPanel borraCli = new JPanel();
		borraCli.setBackground(Color.BLUE);

		// Panel Crea Incidnecia
		JPanel creaInci = new JPanel();
		creaInci.setBackground(Color.BLUE);

		// Panel Parte Asistencia
		JPanel parteAsis = new JPanel();
		parteAsis.setBackground(Color.BLUE);

		// Panel Facturas
		JPanel facturas = new JPanel();
		facturas.setBackground(Color.BLUE);

		// Panel Informes
		JPanel informes = new JPanel();
		informes.setBackground(Color.BLUE);

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
		contentPane.add(parteAsis, "parteAsis");
		contentPane.add(facturas, "facturas");
		contentPane.add(informes, "informes");

		gestorPantallas.show(contentPane, "fichaEmple");
	}
}