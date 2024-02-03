package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import modelo.configuracion.Configuracion;

public class DaoMySql {
	
	private Connection conexion;
	
	//abre la conexion con la base de datos
		public Connection abrirConexion(Connection con) {
			//Estamos iniciando el fichero properties para poder realizar su lectura
			Configuracion conf = new Configuracion();
			conf.inicializar();
			
			//Cargamos las propiedades del fichero config.properties
			String url = conf.getProperty("url");
			String usuario = conf.getProperty("usuario");
			String password = conf.getProperty("password");
			try {
				//Si todo va bien se hará la conexión
				con = DriverManager.getConnection(url,usuario,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			return con;
		}
		//Cierra la conexion de la base de datos
		public boolean cerrarConexion(Connection con) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			return true;
		}
}
