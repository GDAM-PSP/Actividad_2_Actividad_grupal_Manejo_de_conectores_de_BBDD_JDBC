package modelo.negocio;

import java.util.Scanner;

import modelo.entidad.Coche;
import modelo.entidad.Pasajero;
import modelo.persistencia.DaoPasajero;
import modelo.persistencia.DaoPasajeroMySql;

public class GestorPasajero {
	
	private static Scanner sc = new Scanner(System.in);
	private DaoPasajero daoPasajero = new DaoPasajeroMySql();
	private GestorCoche gestorCoche = new GestorCoche();
	
	/**
	 * 
	 */
	public boolean anadir() {
		Pasajero p = new Pasajero();
		System.out.println("Escribe el nombre del pasajero");
		p.setNombre(sc.nextLine());
		System.out.println("Escribe la edad del pasajero");
		p.setEdad(sc.nextInt());
		System.out.println("Escribe el peso del pasajero");
		p.setPeso(sc.nextFloat());
		gestorCoche.listar();
		System.out.println("Escribe de la lista de coches, selecciona el ID del coche en el que ira el pasajero");
		p.setId_coche(sc.nextInt());
		
		return daoPasajero.anadir(p);
	}

}
