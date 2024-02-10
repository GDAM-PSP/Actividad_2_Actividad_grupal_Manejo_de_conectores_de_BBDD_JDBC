package modelo.negocio;

import java.util.List;

import modelo.entidad.Coche;
import modelo.entidad.Pasajero;
import modelo.persistencia.DaoPasajeroMySql;
import modelo.persistencia.interfaces.DaoPasajero;

public class GestorPasajero {
	private DaoPasajero daoPasajero = new DaoPasajeroMySql();

	/**
	 * Metodo que recibe el objeto Pasajero de la vista para solicitar a DAO la
	 * insercion
	 * 
	 * @param p El objeto pasajero que se desea añadir
	 * @return true/false>> si se ha agregado con exito.
	 */
	public boolean agregar(Pasajero p) {
		boolean agregado = false;
		p.getEdad();
		p.getId_pasajero();
		p.getNombre();
		p.getPeso();
		if (daoPasajero.agregar(p)) {
			agregado = true;
			return agregado;
		}
		return agregado;
	}

	/**
	 * Metodo que recibe el int ID Pasajero de la vista para solicitar a DAO la
	 * eliminacion
	 * 
	 * @param id El id pasajero que se desea borrar
	 * @return true/false>> si se ha borrado con exito.
	 */

	public boolean borrar(int id) {
		boolean baja = daoPasajero.borrar(id);
		return baja;
	}

	/**
	 * Metodo que recibe el int ID Pasajero de la vista para solicitar a DAO la
	 * consulta de un Pasajero por ID
	 * 
	 * @param id El id pasajero que se desea consultar
	 * @return Pasajero>> Objeto pasajero que proviene de la consulta
	 */
	public Pasajero consultar(int id) {
		Pasajero pasajero_consulta = daoPasajero.consultar(id);
		return pasajero_consulta;
	}

	/**
	 * Metodo para listar los pasajeros leidos en DAO
	 * 
	 * @return Lista>> Devuelve lsita Pasajeros
	 */
	public List<Pasajero> listar() {
		List<Pasajero> pasajero = daoPasajero.listar();
		return pasajero;
	}

	/**
	 * Metodo para asignar un pasajero a un coche
	 * 
	 * @param id_pasajero id_coche
	 * @return true/false >> Devuele boolean si la asignación fue correcta
	 */
	public boolean asignar(int id_pasajero, int id_coche) {
		boolean asignado = false;
		if (daoPasajero.asignar(id_pasajero, id_coche))
			return asignado;
		return asignado;
	}

	public List<Pasajero> listar_asignados(int id_coche) {
		List<Pasajero> pasajero = daoPasajero.listar_asignados(id_coche);
		return pasajero;
	}

}
