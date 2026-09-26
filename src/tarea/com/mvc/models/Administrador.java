package tarea.com.mvc.models;

import java.awt.Color;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import tarea.com.mvc.views.AdministratorView;
import tarea.com.mvc.views.OrdersPanel;

public class Administrador extends Thread{

	private static final int PORT = 5000;
	private ObjectOutputStream out;
	private static final String HOST = "127.0.0.1";
	private ObjectInputStream in;
	private Socket administrador;
	private AdministratorView av;
	private ArrayList<Pedido> pedidos;
	public Administrador() {
		av = new AdministratorView();
		av.init();
		this.pedidos = new ArrayList<>();
	}
	
	public void run() {
		try {
			
			administrador = new Socket(HOST, PORT);
			System.out.println("Administrador conectado!");
			
			out = new ObjectOutputStream(administrador.getOutputStream());
			in = new ObjectInputStream(administrador.getInputStream());
			while(true) {
				Pedido item = (Pedido) in.readObject();
				pedidos.add(item);
				setPanel();
				setEntregadosYNoEntregados();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public ArrayList<Pedido> getPedidos(){
		return pedidos;
	}
	
	
	public void setPanel()  {
		OrdersPanel op = new OrdersPanel();
		op.setBackground(new Color(240, 240, 240));
		for(Pedido p : pedidos) {
			op.lblNumero.setText(p.getId() + "");
			op.lblNombre.setText(p.getNombreCliente());
			op.lblPlatilloss.setText(getPlatillos(p.getListaPlatillos()));
			op.lblTotalCantidadDel.setText("TOTAL: " + getTotal(p.getListaPlatillos()));
			op.lblEstado.setText("ESTADO: " + p.getEstado());
			
			av.panelPedidos.add(op);
		}
	}
	
	public String getPlatillos(ArrayList<Platillo> platillos) {
		String data = "";
		for(Platillo p : platillos) {
			data+= "\n - " + p.getNombre() + "\n";
		}
		return data;
	}
	
	public Double getTotal(ArrayList<Platillo> platillos) {
		Double data = 0.0;
		for(Platillo p : platillos) {
			data+= p.getPrecio();
		}
		return data;
	}	
	
	public void setEntregadosYNoEntregados() {
		 int entregados= 0;
		 int noEntregados = 0;
		 int totalEntregados = 0;
		 int totalNoEntregados = 0;
		for(Pedido p : pedidos) {
			if(p.getEstado().equalsIgnoreCase("Entregado")){
				entregados++;
				totalEntregados += p.getPrecioFinal();
				av.lblEntregados.setText(entregados + "");
				av.lblTotal.setText(totalEntregados + "");

			}else{
				noEntregados++;
				totalNoEntregados += p.getPrecioFinal();
				av.lblNoEntregados.setText(noEntregados + "");
				av.llblTotaL3.setText(totalNoEntregados + "");
			}
					
		}
	}
	
}
