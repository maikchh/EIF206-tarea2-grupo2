package tarea.com.mvc.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Platillo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int contador;
	private int id;
	private String nombre;
	private int precio;
	
	
	public Platillo(String nombre, int precio) {
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
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Identificador: " + id + "\nNombre: " + nombre + "\nPrecio: " + precio;
	}
	
}
