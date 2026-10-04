package tarea.com.mvc.models;

import java.awt.Color;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import tarea.com.mvc.views.AdministratorView;
import tarea.com.mvc.views.OrdersPanel;

public class Administrador extends Thread{

	private static int entregados;
	private static int totalEntregados;
	private static int noEntregados;
	private static int totalNoEntregados;
	
	private static final int PORT = 5000;
	private ObjectOutputStream out;
	private static final String HOST = "127.0.0.1";
	private ObjectInputStream in;
	private Socket administrador;
	private AdministratorView av;
	private ArrayList<Pedido> pedidos;
	private static int counter;
	
	public Administrador() {
		entregados = 0;
		totalEntregados = 0;
		noEntregados = 0;
		totalNoEntregados = 0;
		av = new AdministratorView();
		this.pedidos = new ArrayList<>();
		counter = 1;
	}
	
	public void run() {
		try {
			av.init();
			
			administrador = new Socket(HOST, PORT);
			System.out.println("Administrador conectado!");
			
			out = new ObjectOutputStream(administrador.getOutputStream());
			in = new ObjectInputStream(administrador.getInputStream());
			
			while(true) {
				Pedido item = (Pedido) in.readObject();
				System.out.println(item.getListaPlatillos().toString());
				pedidos.add(item);
				noEntregados(item);
				setPanel(item);
				counter++;
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void setPanel(Pedido p)  {
			OrdersPanel op = new OrdersPanel(this);
			op.setBackground(new Color(240, 240, 240));
			
			op.lblNumero.setText(counter + "");
			op.lblNombre.setText(p.getNombreCliente());
			
			//System.out.println(p.getListaPlatillos().toString());
			
			getPlatillos(op);
			op.lblTotalCantidadDel.setText("TOTAL: " + p.getPrecioFinal());
			op.lblEstado.setText("ESTADO: " + p.getEstado());
			
			av.setContentOrders(op);;
		
	}
	
	public void noEntregados(Pedido p) {
		this.noEntregados+= 1;
		this.totalNoEntregados+= p.getPrecioFinal();
		
		this.av.lblNoEntregados.setText(noEntregados+"");
		this.av.llblTotaLNoEntregados.setText(totalNoEntregados+"");
	}
	
	public void getPlatillos(OrdersPanel op) {
		for(Platillo p : pedidos.get(pedidos.size() - 1).getListaPlatillos()) {
			op.model.addElement(p.getNombre());
		}
		
	}
	
	public Double getTotal(ArrayList<Platillo> platillos) {
		Double data = 0.0;
		for(Platillo p : platillos) {
			data+= p.getPrecio();
		}
		return data;
	}
	
	public void setEntregados(int id) {
		 Pedido p = pedidos.get(id);
		 
		 this.entregados++;
		 this.totalEntregados+= p.getPrecioFinal();
		 this.noEntregados--;
		 this.totalNoEntregados-= p.getPrecioFinal();  
		 
		 this.av.lblEntregados.setText(entregados + "");
		 this.av.lblTotalEntregados.setText(totalEntregados + "");
		 this.av.lblNoEntregados.setText(noEntregados + "");
		 this.av.llblTotaLNoEntregados.setText(totalNoEntregados + "");
	}
	
	public void changeStatus(int id) {
		for(Pedido p: pedidos) {
			if(p.getId() == id) {
				p.setEstado("Entregado");
			}
		}	
	}
}
