package tarea.com.init;

import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme;

import tarea.com.mvc.controllers.ControllerCliente;

public class MainClient {
	
	public static void main(String[] args) {
		new FlatDarkFlatIJTheme().setup();
		new ControllerCliente().init();
	}

}
