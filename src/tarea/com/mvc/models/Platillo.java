package tarea.com.mvc.models;

public class Platillo {

	private static int contador;
	private int id;
	private String nombre;
	private double precio;
	public Platillo(String nombre, double precio) {
		this.id = contador++;
		this.nombre = nombre;
		this.precio = precio;
	}
	public static int getContador() {
		return contador;
	}
	public static void setContador(int contador) {
		Platillo.contador = contador;
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
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Identificador: " + id + "\nNombre: " + nombre + "\nPrecio: " + precio;
	}
	
}
