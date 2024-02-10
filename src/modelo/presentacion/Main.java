package modelo.presentacion;

import java.util.Scanner;

import modelo.entidad.Coche;
import modelo.entidad.Pasajero;
import modelo.negocio.GestorCoche;
import modelo.negocio.GestorPasajero;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// INICIALIZACION DE VARIABLES

		Scanner sc = new Scanner(System.in);
		int seleccion;
		int aux;

		GestorCoche gestorCoche = new GestorCoche();
		GestorPasajero gestorPasajero = new GestorPasajero();

		// EJECUCION PRINCIPAL

		do {
			menu();
			System.out.print("Seleccione una opción: ");
			seleccion = sc.nextInt();
			System.out.println("\n--------------------------------------------------");
			Pasajero paux = new Pasajero();
			Coche caux = new Coche();
			switch (seleccion) {
			case 1:
				System.out.println("Introduzca Marca");
				caux.setMarca(sc.next());
				System.out.println("Introduzca Modelo");
				caux.setModelo(sc.next());
				System.out.println("Introduzca Año");
				caux.setAnio(sc.nextInt());
				System.out.println("Introduzca Kilometraje");
				caux.setKm(sc.nextInt());
				int result = gestorCoche.anadir(caux);
				if (result == 0)
					System.out.println("Coche agregado correctamente");
				else
					System.out.println("No se ha podido agregar el coche revise los datos");
				break;

			case 2:
				System.out.println("Indique ID para borrar el coche");
				aux = sc.nextInt();
				boolean borrado = gestorCoche.borrar(aux);
				if (borrado)
					System.out.println("Coche con ID " + aux + " Borrado de la base de datos");
				else
					System.out.println("El coche no ha podido ser eliminado.");
				break;

			case 3:
				System.out.println("Indique ID para buscar coche");
				caux = gestorCoche.consultar(sc.nextInt());
				System.out.println(caux.toString());
				break;

			case 4:
				System.out.println("Indique ID para modificar coche");
				caux = gestorCoche.consultar(sc.nextInt());
				System.out.println("El coche seleecionado es el siguiente: "); // IMPLEMENTAR SELECTOR DE EDICIÓN
				System.out.println(caux.toString());
				System.out.println("Escribe la marca nueva del coche");
				caux.setMarca(sc.next());
				System.out.println("Escribe el modelo nuevo del coche");
				caux.setModelo(sc.next());
				System.out.println("Escribe el año nuevo de fabricación del coche");
				caux.setAnio(sc.nextInt());
				System.out.println("Escribe los kilometros totales nuevos del coche");
				caux.setKm(sc.nextInt());
				int mod = gestorCoche.modificar(caux);
				if (mod != 0)
					System.out.println("El coche no ha sido agregado, revise los datos *MARCA *MODELO ");
				else
					System.out.println("Coche modificado con éxito");
				break;

			case 5:
				System.out.println(gestorCoche.listar().toString());
				break;
			case 6:
				do {
					System.out.println("Selecione una opcion");
					menuPasajeros();
					seleccion = sc.nextInt();
					System.out.println("\n--------------------------------------------------");
					switch (seleccion) {
					case 1:
						System.out.println("Introduzca Nombre");
						paux.setNombre(sc.next());
						System.out.println("Introduzca Edad");
						paux.setEdad(sc.nextInt());
						System.out.println("Introduzca Peso");
						paux.setPeso(sc.nextFloat());
						boolean agregado_pasajero = gestorPasajero.agregar(paux);
						if (agregado_pasajero)
							System.out.println("Pasajero agregado correctamente");
						else
							System.out.println("No se ha podido agregar el pasajero revise los datos");
						break;
					case 2:
						System.out.println("Introduzca un ID para Borrar: ");
						aux = sc.nextInt();
						boolean borrado_pasajero = gestorPasajero.borrar(aux);
						if (borrado_pasajero)
							System.out.println("Se ha borrado el pasajero con ID" + aux + " de la BBDD");
						else
							System.out.println("No se ha podido borrar el pasajero");
						break;
					case 3:
						System.out.println("Introduzca un ID para buscar un pasajero: ");
						paux = gestorPasajero.consultar(sc.nextInt());
						System.out.println(paux.toString());
						break;
					case 4:
						System.out.println(gestorPasajero.listar().toString());
						break;
					case 5:
						System.out
								.println("A continuacion se solicitan ID PASAJERO e ID COCHE para asignar al vehiculo");
						System.out.println(gestorPasajero.listar().toString());
						System.out.println("INTRODUZCA ID PASAJERO: ");
						aux = sc.nextInt();
						System.out.println(gestorCoche.listar().toString());
						System.out.println("INTRODUZCA ID COCHE A ASIGNAR: ");
						gestorPasajero.asignar(aux, sc.nextInt());

						break;
					case 6:
						gestorPasajero.desasignar(3);
						break;
					case 7:
						System.out.println("Introduzca un ID COCHE para buscar pasajeros asociados: ");
						aux = sc.nextInt();
						System.out.println(gestorPasajero.listar_asignado(aux));
						break;
					case 0:
						break;

					}
				} while (seleccion != 0);
				break;

			}
		} while (seleccion != 0);
		System.out.println(">>FINALIZANDO EJECUCIÓN");
	}

	public static void menu() {
		System.out.println("\n=== Menú Principal ===");
		System.out.println("1->Añadir nuevo coche");
		System.out.println("2->Borrar coche por ID");
		System.out.println("3->Consultar coche por ID");
		System.out.println("4->Modificar coche por ID");
		System.out.println("5->Listado de coches");
		System.out.println("6->Gestion de pasajeros");
		System.out.println("0->Terminar programa");
	}

	public static void menuPasajeros() {
		System.out.println("\n=== Gestión de Pasajeros ===");
		System.out.println("1->Crear un nuevo pasajero");
		System.out.println("2->Borrar pasajero por id");
		System.out.println("3->Consulta pasajero por id");
		System.out.println("4->Listar todos los pasajeros");
		System.out.println("5->Añadir pasajero a coche");
		System.out.println("6->Elminar pasajero de coche");
		System.out.println("7->Listar todos los pasajeros de un coche");
		System.out.println("0->Terminar programa");
	}
}
