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