package main;

import java.util.List;
import java.util.Scanner;

import modelo.entidad.Coche;
import modelo.entidad.Pasajero;
import modelo.negocio.GestorCoche;
import modelo.negocio.GestorPasajero;
import modelo.persistencia.DaoCoche;
import modelo.persistencia.DaoCocheMySql;

public class Main {
	
	private static Scanner sc = new Scanner(System.in);
	
	private static GestorCoche gestorCoche = new GestorCoche();
	private static GestorPasajero gestorPasajero = new GestorPasajero();
	
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
			case 6:
				int opcionPasajeros = -1;
				do {
					System.out.println("Escribe la opción del menú");
					menuPasajeros();
					opcionPasajeros = sc.nextInt();
					switch(opcionPasajeros) {
					case 1:
						if(gestorPasajero.anadir()) {
							System.out.println("Pasajero creado");
						} else {
							System.out.println("No se ha podido crear el pasajero");
						}
						break;
					case 2:
						
						break;
					case 3:
						
						break;
					case 4:
						
						break;
					case 5:
						
						break;
					case 6:
						
						break;
					}
				}while(opcionPasajeros !=0);
				break;
			case 0:
				break;
			}
		}while(opcion!=0);
	}
	
	//menu de opciones de usuario principal
	public static void menu() {
		System.out.println("1->Añadir nuevo coche");
		System.out.println("2->Borrar coche por ID");
		System.out.println("3->Consultar coche por ID");
		System.out.println("4->Modificar coche por ID");
		System.out.println("5->Listado de coches");
		System.out.println("6->Gestion de pasajeros");
		System.out.println("0->Terminar programa");
	}
	//menu de pasajeros
	public static void menuPasajeros() {
		System.out.println("1->Crear un nuevo pasajero);");
		System.out.println("2->Borrar pasajero por id");
		System.out.println("3->Consulta pasajero por id");
		System.out.println("4->Listar todos los pasajeros");
		System.out.println("5->Añadir pasajero a coche");
		System.out.println("6->Listar todos los pasajeros de un coche");
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

		return gestorCoche.anadir(c);
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
		System.out.println("Escribe el nuevo año de fabricación del coche");
		c.setAnio(sc.nextInt());
		System.out.println("Escribe los kilometros totales nuevos del coche");
		c.setKm(sc.nextInt());

		return gestorCoche.modificar(c);
	}
	
	//metodo que llama a la interfaz que devuelve una consulta con el coche id a consultar
	public static boolean consultarCoche() {
		System.out.println("Escribe el id del coche que quieres consultar");
		int id = sc.nextInt();
		Coche c = gestorCoche.consultar(id);
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
		if(gestorCoche.borrar(id) == false) {
			System.out.println("El coche con id "+id+" no a sido borrado");
			return false;
		}
		System.out.println("El coche con id "+id+" a sido borrado");
		return true;
	}
	
	//metodo que llama a la interfaz que devuelve una consulta con todos los coches 
	//de la base de datos
	public static boolean listarCoche() {
		List<Coche> coches = gestorCoche.listar();
		for(Coche c : coches) {
			System.out.println(c);
		}
		return false;
	}
}
