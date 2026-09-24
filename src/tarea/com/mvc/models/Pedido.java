package tarea.com.mvc.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Pedido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int contador;
	private int id;
	private String nombreCliente;
	private ArrayList<Pedido> listaPedidos;
	private double precioFinal;
	private String estado;
	public Pedido(String nombreCliente, ArrayList<Pedido> listaPedidos, double precioFinal) {
		this.id = contador++;
		this.nombreCliente = nombreCliente;
		this.listaPedidos = listaPedidos;
		this.precioFinal = precioFinal;
		this.estado = "No entregado";
	}
	public static int getContador() {
		return contador;
	}
	public static void setContador(int contador) {
		Pedido.contador = contador;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public ArrayList<Pedido> getListaPedidos() {
		return listaPedidos;
	}
	public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}
	public double getPrecioFinal() {
		return precioFinal;
	}
	public void setPrecioFinal(double precioFinal) {
		this.precioFinal = precioFinal;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Identificador: " + id
				+ "\nNombre de Cliente: " + nombreCliente
				+ "\nLista de Pedidos: " + listaPedidos
				+ "\nPrecio Final: " + precioFinal 
				+ "\nEstado: " + estado;
	}
	
	
	



}
