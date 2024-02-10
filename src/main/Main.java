package main;

import java.util.Scanner;

import modelo.entidad.Coche;
import modelo.entidad.Pasajero;
import modelo.negocio.GestorCoche;
import modelo.negocio.GestorPasajero;

public class Main {

	public static void main(String[] args) {
		// INICIALIZACION DE VARIABLES
		Scanner sc = new Scanner(System.in);
		int seleccion;
		int aux;
		Coche caux = new Coche();
		GestorCoche gestorCoche = new GestorCoche();
		Pasajero paux = new Pasajero();
		GestorPasajero gestorPasajero = new GestorPasajero();

		// EJECUCION PRINCIPAL
		do {
			menu();
			System.out.print("Seleccione una opción: ");
			seleccion = sc.nextInt();
			System.out.println("\n--------------------------------------------------");
			switch (seleccion) {
			// Casos 1 a 5 permanecen iguales, pero se agregan líneas separadoras
			case 1:
				// ...
				System.out.println("--------------------------------------------------\n");
				break;
			// ...
			case 6:
				do {
					System.out.println("\n=== Gestión de Pasajeros ===");
					menuPasajeros();
					System.out.print("Seleccione una opción: ");
					seleccion = sc.nextInt();
					System.out.println("\n--------------------------------------------------");
					// Casos para el manejo de pasajeros
					// ...
					System.out.println("--------------------------------------------------\n");
				} while (seleccion != 0);
				break;
			// ...
			}
			System.out.println("--------------------------------------------------\n");
		} while (seleccion != 0);
		System.out.println(">>FINALIZANDO EJECUCIÓN\n");
	}

	public static void menu() {
		System.out.println("\n=== Menú Principal ===");
		System.out.println("1->Añadir nuevo coche");
		System.out.println("2->Borrar coche por ID");
		System.out.println("3->Consultar coche por ID");
		System.out.println("4->Modificar coche por ID");
		System.out.println("5->Listado de coches");
		System.out.println("6->Gestión de pasajeros");
		System.out.println("0->Terminar programa");
	}

	public static void menuPasajeros() {
		System.out.println("\n=== Gestión de Pasajeros ===");
		System.out.println("1->Crear un nuevo pasajero");
		System.out.println("2->Borrar pasajero por id");
		System.out.println("3->Consulta pasajero por id");
		System.out.println("4->Listar todos los pasajeros");
		System.out.println("5->Añadir pasajero a coche");
		System.out.println("6->Listar todos los pasajeros de un coche");
		System.out.println("0->Volver al menú principal");
	}
}
