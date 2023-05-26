import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.*;

public class Conexion {

	private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://192.168.4.233:3306/";
	private static final String DB = "pruebas";
	private static final String USUARIO = "pelli";
	private static final String CLAVE = "pelli";


	public static Connection conectar() {
		Connection conexion = null;
		Statement consulta = null;
		
		try {
			Class.forName(CONTROLADOR);
			conexion = DriverManager.getConnection(URL + DB, USUARIO, CLAVE);
			System.out.println("Conexión OK");
			return conexion;
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();

		} catch (SQLException e) {
			System.out.println("Error en la conexión");
			e.printStackTrace();
		}
		
		return conexion;
	}


	public java.sql.Statement createStatement() {
		// TODO Auto-generated method stub
		return null;
	}
}
