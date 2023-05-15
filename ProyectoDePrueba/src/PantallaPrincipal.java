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

public class PantallaPrincipal extends JFrame {

	private JPanel contentPane;

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

<<<<<<< Updated upstream
		setBounds(100, 100, 575, 358);
=======
		setBounds(100, 100, 777, 455);
>>>>>>> Stashed changes

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
		contentPane.setLayout(new CardLayout(0, 0));
	}
}