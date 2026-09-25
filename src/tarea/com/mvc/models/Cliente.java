package tarea.com.mvc.models;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class Cliente extends Thread{

	private static final int PORT = 5000;
	private Socket client;
	private ObjectOutputStream out;

	private String host;

	public Cliente(String host) {
		this.host = host;
	}

	public void run() {
		try {
			client = new Socket(host,PORT);
			System.out.println("Cliente conectado!");

			out = new ObjectOutputStream(client.getOutputStream());
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void send(Pedido pedido) {
		try {
			out.writeObject(pedido);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			out.close();
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
