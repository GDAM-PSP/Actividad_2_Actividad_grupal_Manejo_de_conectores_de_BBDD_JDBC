package modelo.negocio;

import modelo.persistencia.interfaces.*;

import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Coche;
import modelo.persistencia.*;

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
	public int anadir(Coche c) {
		if (!c.getMarca().isEmpty() && !c.getModelo().isEmpty()) {
			boolean alta = daoCoche.anadir(c);
			if (alta) {
				return 0;
			} else {
				return 1;
			}
		} else {
			return 2;
		}
	}

	/**
	 * Metodo para borrar un coche por ID.
	 * 
	 * @param ID del coche que se desea borrar
	 * @return true/false Si el coche ha sido borrado con exito
	 */

	public boolean borrar(int id) {
		boolean baja = daoCoche.borrar(id);
		return baja;
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
	public int modificar(Coche c) {
		if (!c.getMarca().isEmpty() && !c.getModelo().isEmpty()) {
			boolean modificado = daoCoche.modificar(c);
			if (modificado) {
				return 0;
			} else {
				return 1;
			}
		} else {
			return 2;
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
