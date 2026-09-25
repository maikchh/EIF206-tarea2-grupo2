package tarea.com.init;

import com.formdev.flatlaf.intellijthemes.FlatArcDarkOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme;

import tarea.com.mvc.controllers.ControllerAdministrator;

public class MainAdministrator {

	
	public static void main(String[] args) {
		new FlatDarkFlatIJTheme().setup();
		new ControllerAdministrator().init();
	}
}
