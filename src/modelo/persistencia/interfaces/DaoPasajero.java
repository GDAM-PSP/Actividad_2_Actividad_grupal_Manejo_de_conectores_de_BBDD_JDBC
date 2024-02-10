package modelo.persistencia.interfaces;

import java.util.List;

import modelo.entidad.Pasajero;

//INTERFAZ PASAJEROS

public interface DaoPasajero {
	public boolean agregar(Pasajero p);

	public boolean borrar(int id);

	public Pasajero consultar(int id);

	public boolean asignar(int id_pasajero, int id_coche);

	public List<Pasajero> listar_asignados(int id_coche);

	public List<Pasajero> listar();
}
