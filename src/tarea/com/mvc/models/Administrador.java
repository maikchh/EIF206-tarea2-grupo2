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
	private static int counter;
	
	public Administrador() {
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
				pedidos.add(item);
				setPanel(item);
				counter++;
				setEntregadosYNoEntregados();
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
			op.lblPlatilloss.setText(getPlatillos(p.getListaPlatillos()));
			op.lblTotalCantidadDel.setText("TOTAL: " + p.getPrecioFinal());
			op.lblEstado.setText("ESTADO: " + p.getEstado());
			
			av.setContentOrders(op);;
		
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
	
	public void setTotales(int id) {
		int entregados= Integer.parseInt(this.av.lblEntregados.getText());
		 int noEntregados = Integer.parseInt(this.av.lblNoEntregados.getText());
		 int totalEntregados = Integer.parseInt(this.av.lblTotalEntregados.getText());
		 int totalNoEntregados = Integer.parseInt(this.av.llblTotaLNoEntregados.getText());
		 
		 Pedido p = pedidos.get(id);
		 entregados++;
		 totalEntregados+= p.getPrecioFinal();
		 noEntregados--;
		 totalNoEntregados-= p.getPrecioFinal();  
		 
		 av.lblEntregados.setText(entregados + "");
		 av.lblTotalEntregados.setText(totalEntregados + "");
		 av.lblNoEntregados.setText(noEntregados + "");
		 av.llblTotaLNoEntregados.setText(totalNoEntregados + "");
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
			}else{
				noEntregados++;
				totalNoEntregados += p.getPrecioFinal();
			}
		}
		
		av.lblEntregados.setText(entregados + "");
		av.lblTotalEntregados.setText(totalEntregados + "");
		av.lblNoEntregados.setText(noEntregados + "");
		av.llblTotaLNoEntregados.setText(totalNoEntregados + "");
	}
	
	public void changeStatus(int id) {
		for(Pedido p: pedidos) {
			if(p.getId() == id) {
				p.setEstado("Entregado");
			}
		}	
		//setEntregadosYNoEntregados();
	}
}
