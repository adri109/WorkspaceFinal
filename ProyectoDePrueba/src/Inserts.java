import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
		
		//HACER CONSULTA PARA OBTENER LAS SUCURSALES	
		
		
		String nombre, fechaAlta, nivelAsist, dni;
		boolean activo;
		
		
		
		Connection cnx = Conexion.conectar();
		try {
			nombre = PantallaPrincipal.txtNomEmple.getText();
			dni = PantallaPrincipal.txtDniEmple.getText();
			nivelAsist= PantallaPrincipal.txtNivelAsist.getText();
			activo = PantallaPrincipal.chkbxEmpleActivo.isSelected();
			fechaAlta =PantallaPrincipal.txtFechAlta.getText();
			
			
			
			// OBTENER CÓDIGO SELECCIONADO
			String codseleccionado="Select cod_sucursal from sucursal where nombre= '"+PantallaPrincipal.cmbxCodSucu.getSelectedItem()+"'";
			java.sql.Statement sentencia = cnx.createStatement();
			ResultSet resultado = sentencia.executeQuery(codseleccionado);
				int cod[]=new int [1];
				while(resultado.next()) {
					cod[0]=resultado.getInt(1);
				}
				
	
				
			
			 String consulta = "INSERT INTO empleado (cod_sucursal,nombre,dni, nivel_asistencia, nivel_comision, activo, fec_alta) VALUES (?, ?, ?, ?, ?, ?, ?)";
			 
			 
	            PreparedStatement pstmt = cnx.prepareStatement(consulta);
	            pstmt.setInt(1,cod[0]);
	            pstmt.setString(2, nombre);
	            pstmt.setString(3, dni);
	            pstmt.setString(4, nivelAsist);
	            pstmt.setString(5, (String) PantallaPrincipal.cmbxNivelComision.getSelectedItem());
	            pstmt.setBoolean(6, activo);
	            pstmt.setString(7, fechaAlta);
	            pstmt.executeUpdate();
				
	            JOptionPane.showMessageDialog(null, "EMPLEADO AÑADIDO");
		} catch (SQLException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERROR EN EL FORMATO");
			System.err.println("LA CONSULTA NO HA PODIDO SER EJECUTADA.");
		} catch (NumberFormatException e2) {
			JOptionPane.showMessageDialog(null, "ERROR EN EL FORMATO");

		}
	}
}
