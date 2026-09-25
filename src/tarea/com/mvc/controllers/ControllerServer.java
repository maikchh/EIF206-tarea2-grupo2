package tarea.com.mvc.controllers;

import tarea.com.mvc.models.Server;

public class ControllerServer {
	
	
	public void init() {
		new  Server().start();
	}

}
