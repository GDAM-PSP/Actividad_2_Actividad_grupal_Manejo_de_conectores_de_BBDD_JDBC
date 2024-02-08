package modelo.persistencia.interfaces;

import java.util.List;

import modelo.entidad.Pasajero;

//INTERFAZ PASAJEROS

public interface DaoPasajero {
	public boolean anadir(Pasajero p);

	public boolean borrar(int id);

	public Pasajero consultar(int id);

	public boolean modificar(Pasajero p);

	public List<Pasajero> listar();
}
