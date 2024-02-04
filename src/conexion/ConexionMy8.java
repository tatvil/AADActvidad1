
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

/**

 * Clase con los datos para realizar la conexion singleton

 * 

 * @author Alberto Arroyo Santofimia

 * 

 * @version v1.0

 *

 */

public class ConexionMy8 {

	private static String url,user,pwd;
	private static Connection conn;

	static {

		url = "jdbc:mysql://localhost:3306/clientes_proyectos_empleados_2023?serverTimezone=UTC";
		user = "root";
		pwd = null;

	}

	
	private ConexionMy8() {

		try {

			conn=DriverManager.getConnection(url, user, pwd);

			System.out.println("CONEXION CORRECTA");

		} catch (SQLException e) {

			e.printStackTrace();

			System.out.println("****NO CONECTADO*****");

		}

	}

 

	public static Connection getConexion() {

		if (conn==null) {

			new ConexionMy8();

		}

		return conn;


	}

}
ALBERTO ARROYO SANTOFIMIA
ALBERTO ARROYO SANTOFIMIA

18:04

public abstract class AbstractDaoMy8 {

	

	//Atributos 

	protected Connection conn;

	protected PreparedStatement ps;

	protected ResultSet rs;

	protected String sql;

	protected int filas;

	

	//Metodo para hacer la conexion

	public AbstractDaoMy8() {

		conn = ConexionMy8.getConexion();

	}


}
