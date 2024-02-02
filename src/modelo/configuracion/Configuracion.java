package modelo.configuracion;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuracion {
	private Properties properties;
	//inicializamos el fichero propiedades lo cargamos con un try catch autoclosable
	public void inicializar() {
		try(InputStream ficheroPropiedades = Configuracion.class.getClassLoader()
				.getResourceAsStream("config.properties");){
			properties = new Properties();
			properties.load(ficheroPropiedades);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//creamos un metodo que nos saque el valor del key que le mandamos key/value
	//como si fuera un diccionario
	public String getProperty(String key) {
		return properties.getProperty(key);
	}
}
