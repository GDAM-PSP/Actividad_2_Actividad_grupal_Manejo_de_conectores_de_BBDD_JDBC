package modelo.presentacion;

import java.util.Scanner;

import modelo.entidad.Coche;
import modelo.negocio.GestorCoche;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// INICIALIZACION DE VARIABLES

		Scanner sc = new Scanner(System.in);
		int seleccion;
		Coche caux = new Coche();
		GestorCoche gc = new GestorCoche();
		// EJECUCION PRINCIPAL
		do {
			menu();
			seleccion = sc.nextInt();
			switch (seleccion) {
			case 1:
				// PASAR OBJETO O TEXTO?
				System.out.println("Introduzca Marca");
				caux.setMarca(sc.next());
				System.out.println("Introduzca Modelo");
				caux.setModelo(sc.next());
				System.out.println("Introduzca Año");
				caux.setAnio(sc.nextInt());
				System.out.println("Introduzca Kilometraje");
				caux.setKm(sc.nextInt());
				// añades usuario, si true no false

				int result = gc.anadir(caux);
				if (result == 0)
					System.out.println("Coche agregado correctamente");
				else
					System.out.println("No se ha podido agregar el coche revise los datos");
				break;

			case 2:
				System.out.println("Indique ID para borrar el coche");
				boolean borrado = gc.borrar(sc.nextInt());
				if (borrado)
					System.out.println("Coche con ID " + seleccion + " Borrado de la base de datos");
				else
					System.out.println("El coche no ha podido ser eliminado.");
				break;

			case 3:
				System.out.println("Indique ID para buscar coche");
				gc.consultar(sc.nextInt());
				break;

			case 4:
				break;

			case 5:
				gc.listar();
				System.out.println(gc.listar().toString());
				break;
			case 6:
				break;

			}
		} while (seleccion != 0);
		System.out.println(">>FINALIZANDO EJECUCIÓN");
	}

	public static void menu() {
		System.out.println("1->Añadir nuevo coche");
		System.out.println("2->Borrar coche por ID");
		System.out.println("3->Consultar coche por ID");
		System.out.println("4->Modificar coche por ID");
		System.out.println("5->Listado de coches");
		System.out.println("6->Gestion de pasajeros");
		System.out.println("0->Terminar programa");
	}

	public static void menuPasajeros() {
		System.out.println("1->Crear un nuevo pasajero);");
		System.out.println("2->Borrar pasajero por id");
		System.out.println("3->Consulta pasajero por id");
		System.out.println("4->Listar todos los pasajeros");
		System.out.println("5->Añadir pasajero a coche");
		System.out.println("6->Listar todos los pasajeros de un coche");
		System.out.println("0->Terminar programa");
	}
}
