import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Prueba {

	public static JPanel lista() {
		JPanel panel = new JPanel();
		
		panel.removeAll();
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
		
		panel.add(scrollPane);
		
		String sql = "SELECT * FROM sucursal";
		

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
		} catch (SQLException sqlE1) {
			// TODO Auto-generated catch block
			sqlE1.printStackTrace();
		}
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		panel.revalidate();
		panel.repaint();
		
		return panel;
	}
	
}
