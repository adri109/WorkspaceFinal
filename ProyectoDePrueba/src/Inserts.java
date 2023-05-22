import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Inserts {

	@SuppressWarnings("deprecation")
	public static void insertSucursal() {
		String nombre, direccion, municipio, ccc, cif;
		int cp;
		
		Connection cnx = Conexion.conectar();
		try {
			nombre = PantallaPrincipal.txtNomSucu.getText();
			direccion = PantallaPrincipal.txtDirSucu.getText();
			cp = Integer.parseInt(PantallaPrincipal.txtCpSucu.getText());
			municipio = PantallaPrincipal.txtMunicipioSucu.getText();
			cif = PantallaPrincipal.txtCifSucu.getText();
			ccc = PantallaPrincipal.txtCccSucu.getText();
			
			java.sql.Statement sentencia = cnx.createStatement();
			 String consulta = "INSERT INTO sucursal (nombre, direccion, cp, municipio, cif, ccc) VALUES (?, ?, ?, ?, ?, ?)";
	            PreparedStatement pstmt = cnx.prepareStatement(consulta);
	            pstmt.setString(1, nombre);
	            pstmt.setString(2, direccion);
	            pstmt.setInt(3, cp);
	            pstmt.setString(4, municipio);
	            pstmt.setString(5, cif);
	            pstmt.setString(6, ccc);
	            pstmt.executeUpdate();
				
	            JOptionPane.showMessageDialog(null, "SUCURSAL AÑADIDA");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERROR EN EL FORMATO");
			System.err.println("LA CONSULTA NO HA PODIDO SER EJECUTADA.");
		} catch (NumberFormatException e2) {
			JOptionPane.showMessageDialog(null, "ERROR EN EL FORMATO");

		}
	}
	public static void insertEmpleado() {
		String nombre, direccion, municipio, ccc, cif;
		int cp;
		
		Connection cnx = Conexion.conectar();
		try {
			nombre = PantallaPrincipal.txtNomSucu.getText();
			direccion = PantallaPrincipal.txtDirSucu.getText();
			cp = Integer.parseInt(PantallaPrincipal.txtCpSucu.getText());
			municipio = PantallaPrincipal.txtMunicipioSucu.getText();
			cif = PantallaPrincipal.txtCifSucu.getText();
			ccc = PantallaPrincipal.txtCccSucu.getText();
			
			java.sql.Statement sentencia = cnx.createStatement();
			 String consulta = "INSERT INTO sucursal (nombre, direccion, cp, municipio, cif, ccc) VALUES (?, ?, ?, ?, ?, ?)";
	            PreparedStatement pstmt = cnx.prepareStatement(consulta);
	            pstmt.setString(1, nombre);
	            pstmt.setString(2, direccion);
	            pstmt.setInt(3, cp);
	            pstmt.setString(4, municipio);
	            pstmt.setString(5, cif);
	            pstmt.setString(6, ccc);
	            pstmt.executeUpdate();
				
	            JOptionPane.showMessageDialog(null, "SUCURSAL AÑADIDA");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERROR EN EL FORMATO");
			System.err.println("LA CONSULTA NO HA PODIDO SER EJECUTADA.");
		} catch (NumberFormatException e2) {
			JOptionPane.showMessageDialog(null, "ERROR EN EL FORMATO");

		}
	}
}
