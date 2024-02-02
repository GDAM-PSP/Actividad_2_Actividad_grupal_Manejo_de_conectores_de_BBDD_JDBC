package modelo.persistencia.interfaces;

import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Coche;

//Interfaz de usuario que hace de puente entre las consultas de la base de datos
//y los metodos del usuario
public interface DaoCoche {
	public boolean anadir(Coche c);
	public boolean borrar(int id);
	public Coche consultar(int id);
	public boolean modificar(Coche c);
	public List<Coche> listar();
}
