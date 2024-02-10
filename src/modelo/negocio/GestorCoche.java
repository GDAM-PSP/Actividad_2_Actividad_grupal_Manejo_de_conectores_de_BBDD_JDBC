package modelo.negocio;

import java.util.List;

import modelo.entidad.Coche;
import modelo.persistencia.DaoCocheMySql;
import modelo.persistencia.interfaces.DaoCoche;

public class GestorCoche {

	private DaoCoche daoCoche = new DaoCocheMySql();

	/**
	 * Metodo para dar de alta un coche en la base de datos. La marca y el modelo
	 * del coche no pueden estar vacios.
	 * 
	 * @param c el coche que vamos a dar de alta
	 * @return 0 en caso de que hayamos dado de alta correctamente al coche, 1 en
	 *         caso de algun error de conexion a la base de datos y 2 en caso de que
	 *         el coche no tenga marca o modelo.
	 */
	public boolean anadir(Coche c) {
		if (!c.getMarca().isEmpty() && !c.getModelo().isEmpty()) {
			return daoCoche.anadir(c);
		} else {
			return false;
		}
	}

	/**
	 * Metodo para borrar un coche por ID.
	 * 
	 * @param ID del coche que se desea borrar
	 * @return true/false Si el coche ha sido borrado con exito
	 */

	public boolean borrar(int id) {
		return daoCoche.borrar(id);
	}

	/**
	 * Metodo para modificar un coche en la base de datos. La marca y el modelo del
	 * coche no pueden estar vacios.
	 * 
	 * @param c el coche que vamos a modificar
	 * @return 0 en caso de que hayamos modificado correctamente el coche, 1 en caso
	 *         de algun error de conexion a la base de datos y 2 en caso de que el
	 *         coche no tenga marca o modelo.
	 */
	public boolean modificar(Coche c) {
		if (!c.getMarca().isEmpty() && !c.getModelo().isEmpty()) {
			return daoCoche.modificar(c);
		} else {
			return false;
		}
	}

	/**
	 * Metodo para consultar por ID un coche.
	 * 
	 * @param ID del coche que se desea consultar
	 * @return Devuelve el objeto coche con ID seleccionado
	 */
	public Coche consultar(int id) {
		Coche consulta = daoCoche.consultar(id);
		return consulta;
	}

	/**
	 * Metodo para listar todos los coches disponibles
	 * 
	 * @return Devuelve la lista de coches actual
	 */
	public List<Coche> listar() {
		List<Coche> coches = daoCoche.listar();
		return coches;
	}

}
