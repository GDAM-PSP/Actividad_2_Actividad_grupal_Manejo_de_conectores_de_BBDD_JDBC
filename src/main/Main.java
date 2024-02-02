package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.entidad.Coche;
import modelo.persistencia.DaoCocheMySql;
import modelo.persistencia.interfaces.DaoCoche;

public class Main {
	
	private static Scanner sc = new Scanner(System.in);
	
	private static DaoCoche coche = new DaoCocheMySql();
	
	public static void main(String args[]) {
		System.out.println("Empieza el programa");
		int opcion;
		do {
			System.out.println("Escribe una opción del menú");
			menu();
			opcion = sc.nextInt();
			sc.nextLine();
			switch(opcion) {
			case 1:
				if(anadirCoche()) {
					System.out.println("Coche añadido correctamente");
				}else {
					System.out.println("Coche no a podido ser añadido");
				}
				break;
			case 2:
				borrarCoche();
				break;
			case 3:
				consultarCoche();
				break;
			case 4:
				if(modificarCoche()) {
					System.out.println("Coche modificado correctamente");
				}else {
					System.out.println("Coche no se a podido modifiacr");
				}
				break;
			case 5:
				listarCoche();
				break;
			case 0:
				break;
			}
		}while(opcion!=0);
	}
	//menu de usuario
	public static void menu() {
		System.out.println("1->Añadir nuevo coche");
		System.out.println("2->Borrar coche por ID");
		System.out.println("3->Consultar coche por ID");
		System.out.println("4->Modificar coche por ID");
		System.out.println("5->Listado de coches");
		System.out.println("0->Terminar programa");
	}
	//metodo que llama a la interfaz que crea un usuario en la base de datos con el objeto
	//que se le proporciona
	public static boolean anadirCoche() {
		Coche c = new Coche();
		System.out.println("Escribe la marca del coche");
		c.setMarca(sc.nextLine());
		System.out.println("Escribe el modelo del coche");
		c.setModelo(sc.nextLine());
		System.out.println("Escribe el año del coche");
		c.setAnio(sc.nextInt());
		System.out.println("Escribe los kilometros del coche");
		c.setKm(sc.nextInt());
		if(coche.anadir(c)) {
			return true;
		}
		return false;
	}
	//metodo que llama a la interfaz que modifica un usuario en la base de datos por el objeto
	//que se le proporciona
	public static boolean modificarCoche() {
		Coche c = new Coche();
		System.out.println("Escribe el id del coche a modificar");
		c.setId(sc.nextInt());
		sc.nextLine();
		System.out.println("Escribe la marca nueva del coche");
		c.setMarca(sc.nextLine());
		System.out.println("Escribe el modelo nuevo del coche");
		c.setModelo(sc.nextLine());
		System.out.println("Escribe el año nuevo de fabricación del coche");
		c.setAnio(sc.nextInt());
		System.out.println("Escribe los kilometros totales nuevos del coche");
		c.setKm(sc.nextInt());
		if(coche.modificar(c)) {
			return true;
		}
		return false;
	}
	//metodo que llama a la interfaz que devuelve una consulta con el coche id a consultar
	public static boolean consultarCoche() {
		System.out.println("Escribe el id del coche que quieres consultar");
		int id = sc.nextInt();
		Coche c = coche.consultar(id);
		if(c == null) {
			System.out.println("El coche con id "+id+" no a sido encontrado");
			return false;
		}
		System.out.println("El coche con id "+id+" a sido encontrado:");
		System.out.println(c.toString());
		return true;
	}
	//metodo que llama a la interfaz que devuelve una consulta que elimina un coche
	//de la base de datos
	public static boolean borrarCoche() {
		System.out.println("Escribe el id del coche que quieres borrar");
		int id = sc.nextInt();
		if(coche.borrar(id) == false) {
			System.out.println("El coche con id "+id+" no a sido borrado");
			return false;
		}
		System.out.println("El coche con id "+id+" a sido borrado");
		return true;
	}
	//metodo que llama a la interfaz que devuelve una consulta con todos los coches 
	//de la base de datos
	public static boolean listarCoche() {
		List<Coche> coches = coche.listar();
		for(Coche c : coches) {
			System.out.println(c);
		}
		return false;
	}
}
