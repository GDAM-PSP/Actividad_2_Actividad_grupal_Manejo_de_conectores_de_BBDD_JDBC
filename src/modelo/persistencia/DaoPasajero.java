package modelo.persistencia;

import java.util.List;

import modelo.entidad.Coche;
import modelo.entidad.Pasajero;

/**
 * Interfaz de usuario que hace de puente entre las consultas de la base de datos y los metodos del usuario
 */
public interface DaoPasajero {
	public boolean anadir(Pasajero p);
	public boolean borrar(int id);
	public Pasajero consultar(int id);
	public boolean modificar(Pasajero p);
	public List<Pasajero> listar();
}
