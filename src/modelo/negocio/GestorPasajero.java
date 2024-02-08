package modelo.negocio;

import java.util.List;

import modelo.entidad.Coche;
import modelo.entidad.Pasajero;
import modelo.persistencia.DaoPasajeroMySql;
import modelo.persistencia.interfaces.DaoPasajero;

public class GestorPasajero {
	private DaoPasajero daoPasajero = new DaoPasajeroMySql();

	public int anadir(Pasajero p) {
		return 0;
	}

	public boolean borrar(int id) {
		boolean baja = daoPasajero.borrar(id);
		return baja;
	}

	public Pasajero consultar(int id) {
		Pasajero consulta = daoPasajero.consultar(id);
		return consulta;
	}

	public List<Pasajero> listar() {
		List<Pasajero> pasajero = daoPasajero.listar();
		return pasajero;
	}
}
