import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Statement;

public class Listar {

	/*
	 * 	LISTAR SUCURSALES
	 */
	public static void list(JPanel panel, String origen) {
		panel.removeAll();
		Connection cnx = Conexion.conectar();


		String comandoCampos = "SHOW COLUMNS FROM " + origen;
		String[] columnNames = null;
<<<<<<< HEAD

		try {
<<<<<<< 127519ae447dbf416448294623f2776123c217be
			java.sql.Statement sentencia = cnx.createStatement();
			ResultSet resultado = sentencia.executeQuery(sql);
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
=======
			java.sql.Statement consulta;
			consulta = cnx.createStatement();
			ResultSet data = consulta.executeQuery(comandoCampos);
			String columnas = "";
			while(data.next()) {
				columnas = columnas + data.getString("Field") + " ";
			}
			columnNames = columnas.split(" ");

			@SuppressWarnings("serial")
			DefaultTableModel model = new DefaultTableModel(columnNames, 0) {

				@Override
				public Class<?> getColumnClass(int columnIndex) {
					return String.class;
				}

			};

			JTable table = new JTable(model);
			table.setBackground(Color.white);

			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setPreferredSize(new Dimension(1000, 400));
			panel.add(scrollPane);

			String sql = "SELECT * FROM " + origen;

			try {
				java.sql.Statement sentencia = cnx.createStatement();
				ResultSet resultado = sentencia.executeQuery(sql);
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

				table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			} catch (SQLException sqlE1) {
				// TODO Auto-generated catch block
				sqlE1.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		panel.revalidate();
		panel.repaint();
>>>>>>> Nuevo metodo Listar.List funcional para todas las pantallas
	}
	public static void Empleados(JPanel fichaEmple) {
		fichaEmple.removeAll();
		Connection cnx = Conexion.conectar();
		
		String[] columnNames = {"COD_EMPLEADO","COD_SUCURSAL","NOMBRE EMPLEADO", "DNI", "NIVEL ASISTENCIA", "NIVEL COMISIÓN", "ACTIVO", "FECHA ALTA"};
		DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return String.class;
			}
			
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 1 || column == 2 || column == 3 || column == 4 || column == 5 || column == 6 || column == 7 || column == 8;
			}
		};
		
		JTable table = new JTable(model);
		table.setBackground(Color.white);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(1000, 400));
		
		fichaEmple.add(scrollPane);
		
		String sql = "SELECT * FROM empleado";
		

		try {
			java.sql.Statement sentencia = cnx.createStatement();
			ResultSet resultado = sentencia.executeQuery(sql);
			while (resultado.next()) {
				String[] ln = new String[8];
				ln[0] = resultado.getString(1);
				ln[1] = resultado.getString(2);
				ln[2] = resultado.getString(3);
				ln[3] = resultado.getString(4);
				ln[4] = resultado.getString(5);
				ln[5] = resultado.getString(6);
				ln[6] = resultado.getString(7);
				ln[7] = resultado.getString(8);
				model.addRow(ln);
=======

		try {
			java.sql.Statement consulta;
			consulta = cnx.createStatement();
			ResultSet data = consulta.executeQuery(comandoCampos);
			String columnas = "";
			while(data.next()) {
				columnas = columnas + data.getString("Field") + " ";
>>>>>>> main
			}
			columnNames = columnas.split(" ");

			@SuppressWarnings("serial")
			DefaultTableModel model = new DefaultTableModel(columnNames, 0) {

				@Override
				public Class<?> getColumnClass(int columnIndex) {
					return String.class;
				}

			};

			JTable table = new JTable(model);
			table.setBackground(Color.white);

			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setPreferredSize(new Dimension(1000, 400));
			panel.add(scrollPane);

			String sql = "SELECT * FROM " + origen;

			try {
				java.sql.Statement sentencia = cnx.createStatement();
				ResultSet resultado = sentencia.executeQuery(sql);
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

				table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			} catch (SQLException sqlE1) {
				// TODO Auto-generated catch block
				sqlE1.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
<<<<<<< HEAD
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		fichaEmple.revalidate();
		fichaEmple.repaint();
=======

		panel.revalidate();
		panel.repaint();
>>>>>>> main
	}
}
