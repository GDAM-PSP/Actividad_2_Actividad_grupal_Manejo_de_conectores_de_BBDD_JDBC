package modelo.entidad;

public class Pasajero {
	private int id;
	private String nombre;
	private int edad;
	private float peso;
	private int id_coche;
	
	public Pasajero() {
		
	}
	
	public Pasajero(int id, String nombre, int edad, float peso, int id_coche) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.id_coche = id_coche;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getId_coche() {
		return id_coche;
	}

	public void setId_coche(int id_coche) {
		this.id_coche = id_coche;
	}
}
