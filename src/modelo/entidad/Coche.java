package modelo.entidad;

public class Coche {
	private int id;
	private String marca;
	private String modelo;
	private int anio;
	private int km;

	public Coche(int id, String marca, String modelo, int anio, int km) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.anio = anio;
		this.km = km;
	}

	public Coche() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	@Override
	public String toString() {
		return "Coche:\n" + "   ID: " + id + "\n" + "   Marca: " + marca + "\n" + "   Modelo: " + modelo + "\n"
				+ "   Año: " + anio + "\n" + "   Kilometraje: " + km + "\n";
	}

}
