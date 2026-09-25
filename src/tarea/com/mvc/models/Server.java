package tarea.com.mvc.models;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
	
	
	private static final int PORTH = 5000;
	private ServerSocket server;
	private ObjectOutputStream outA;
	private ObjectInputStream inA;
	private AdministratorHandler admin;
	
	
	public Server() {
	}

	public void run() {
		try {

			server = new ServerSocket(PORTH);
			System.out.println("Servidor iniciado!");
			
			Socket administrador = server.accept();
			outA = new ObjectOutputStream(administrador.getOutputStream());
			inA = new ObjectInputStream(administrador.getInputStream());
			
			while(true) {
				Socket client = server.accept();
				 
				admin = new AdministratorHandler(client);
				admin.start();
				
				// ESPERAMOS 1 SEGUNDO PARA LA SIGUIENTE CONEXIÓN
				sleep(1000);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public class AdministratorHandler extends Thread {
		
		private Socket client;
		private ObjectOutputStream out;
		private ObjectInputStream in;
		
		public AdministratorHandler(Socket client) {
			this.client = client;
		}
		
		public void run() {
			try {
				out = new ObjectOutputStream(client.getOutputStream());
				in = new ObjectInputStream(client.getInputStream());
				
				while(true) {
					Pedido p = (Pedido) in.readObject();
					outA.writeObject(p);
					outA.flush();
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}	
	}
}

