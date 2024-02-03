package modelo.entidad;

public class Pasajero {
	private int id_pasajero;
	private String nombre;
	private int edad;
	private float peso;
	
	public Pasajero() {
		
	}
	
	public Pasajero(int id_pasajero, String nombre, int edad, float peso) {
		super();
		this.id_pasajero = id_pasajero;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
	}


	public int getId_pasajero() {
		return id_pasajero;
	}

	public void setId_pasajero(int id_pasajero) {
		this.id_pasajero = id_pasajero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	
}
