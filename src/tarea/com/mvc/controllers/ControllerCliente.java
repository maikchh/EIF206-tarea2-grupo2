package tarea.com.mvc.controllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import tarea.com.mvc.models.Cliente;
import tarea.com.mvc.models.Pedido;
import tarea.com.mvc.models.Platillo;
import tarea.com.mvc.views.OrdersMenu;

public class ControllerCliente {
	
	
	private Cliente client;
	private String host;
	private String usuario;
	private ArrayList<Platillo> platillos;
	private OrdersMenu om;
	private ArrayList<Platillo> cargarPlatillos;
	private static int total = 0;
	
	public ControllerCliente() {
		platillos = new ArrayList<>();
		cargarPlatillos = new ArrayList<>();
		om = new OrdersMenu();
		loadData();
		om.init();
	}
	
	public void init() {
		index();
	}
	
	public void index() {	
		loadCombobox();
		om.allowChat(false);
		
		om.btnConectar.addActionListener(e->{
			host = om.txtHost.getText();
			client = new Cliente(host);
			client.start();
			om.allowChat(true);
		});
		
		om.btnAgregar.addActionListener(e->{
			String selected = om.comboBox.getSelectedItem().toString();
			platillos.add(searchOrderByName(selected));
			System.out.println(platillos.size());
			om.model.setDataVector(getData(), getColumns());
			om.lblCantidad.setText(total+"");
		});
		
		om.btnQuitar.addActionListener(e->{
			int selected = -1;
			selected = om.table.getSelectedRow();
			if(selected != -1) {
				remove(selected);
				om.lblCantidad.setText(total+"");
				om.model.setDataVector(getData(), getColumns());
			}else {
				JOptionPane.showMessageDialog(null, "ERROR, debes seleccionar un platillo!");
			}
		});
		
		om.btnEnviarPedido.addActionListener(e->{
			usuario = om.txtXCliente.getText();
			if(!usuario.isEmpty() && platillos.size() > 0) {
				client.send(new Pedido(usuario, platillos, total));
			}else {
				JOptionPane.showMessageDialog(null, "ERROR, el nombre no debe ir vacio y los campos deben tener información!");
			}
		});
	}
	
	private Platillo searchOrderByName(String selected) {
		for(Platillo p : cargarPlatillos) {
			if(p.getNombre().equals(selected)) {
				total += p.getPrecio();
				return p;
			}
		}
		return null;
	}
	
	public void remove(int i) {
		total-= platillos.get(i).getPrecio();
		platillos.remove(i);
	}

	public void loadData() {
		cargarPlatillos.add(new Platillo("Hamburguesa Clásica", 3500));
		cargarPlatillos.add(new Platillo("Pizza Personal", 4500));
		cargarPlatillos.add(new Platillo("Tacos de Pollo", 2800));
		cargarPlatillos.add(new Platillo("Nachos Especiales", 3200));
		cargarPlatillos.add(new Platillo("Casado con Carne", 5000));
		cargarPlatillos.add(new Platillo("Pasta Alfredo", 4800));
		cargarPlatillos.add(new Platillo("Ensalada César", 3000));
		cargarPlatillos.add(new Platillo("Sándwich Club", 3700));
		cargarPlatillos.add(new Platillo("Ceviche", 4200));
		cargarPlatillos.add(new Platillo("Batido de Fresa", 2000));
	}
	
	public void loadCombobox() {
		for(Platillo p : cargarPlatillos) {
			om.comboBox.addItem(p.getNombre());
		}
	}
	
	public String[] getColumns(){
		return new String[] {"ID", "Nombre", "Precio"};
	}
	
	public Object[][] getData(){
		Object[][] data = new Object[platillos.size()][getColumns().length];
		int i = 0;
		
		for(Platillo p : platillos) {
			data[i][0] = p.getId();
			data[i][1] = p.getNombre();
			data[i][2] = p.getPrecio();
			i++;
		}
		return data;
	}
}
