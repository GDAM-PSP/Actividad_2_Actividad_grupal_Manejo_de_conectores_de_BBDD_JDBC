package modelo.negocio;

import java.util.List;

import modelo.entidad.Coche;
import modelo.persistencia.DaoCoche;
import modelo.persistencia.DaoCocheMySql;

public class GestorCoche {
	
	private DaoCoche daoCoche = new DaoCocheMySql();
	
	
	/**
	 * Metodo para dar de alta un coche en la base de datos. La marca y el modelo del coche no pueden estar vacios.
	 * @param c el coche que vamos a dar de alta
	 * @return 0 en caso de que hayamos dado de alta correctamente al coche, 1 en caso de algun error de conexion a la base de datos
	 * y 2 en caso de que el coche no tenga  marca o  modelo.
	 */
	public boolean anadir(Coche c) {
		if(!c.getMarca().isEmpty() && !c.getModelo().isEmpty()) {
			boolean alta = daoCoche.anadir(c);
			if(alta) {
				return false;
			}else {
				return true;
			}
		}else {
			return false;
		}
			
		
	}
	
	public boolean borrar(int id) {
		boolean baja = daoCoche.borrar(id);
		return baja;
	}
	
	/**
	 * Metodo para modificar un coche en la base de datos. La marca y el modelo del coche no pueden estar vacios.
	 * @param c el coche que vamos a modificar
	 * @return 0 en caso de que hayamosmodificado correctamente el coche, 1 en caso de algun error de conexion a la base de datos
	 * y 2 en caso de que el coche no tenga  marca o  modelo.
	 */
	public boolean modificar(Coche c) {
		if(!c.getMarca().isEmpty() && !c.getModelo().isEmpty()) {
			return daoCoche.modificar(c);
		}else {
			return false;
		}
	}
	
	public Coche consultar(int id) {
		Coche consulta = daoCoche.consultar(id);
		return consulta;
	}
	
	
	public List<Coche> listar(){
		List<Coche> coches = daoCoche.listar();
		return coches;
		
	}
	
	
	
}
