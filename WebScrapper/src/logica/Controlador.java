package logica;

import javax.swing.JOptionPane;

public class Controlador {

	public static void main(String[] args) {
		Scrapper ejemplo = new Scrapper();
		//ejemplo.prueba("http://www.zillow.com/homes/for_sale/Denver-CO");
		//ejemplo.prueba("https://listado.mercadolibre.com.co/playstation-4#D[A:playstation%204]");
		//ejemplo.extraerDatosTabla("https://es.wikipedia.org/wiki/Anexo:Libros_m%C3%A1s_vendidos",2);
		
		String  urlEquipo  = JOptionPane.showInputDialog("Ingrese url del equipo que desea consultar");
		
		ejemplo.extraerDatosTabla(urlEquipo,0);
		ejemplo.extraerDatosTabla(urlEquipo,1);
		ejemplo.extraerDatosTabla(urlEquipo,2);
		ejemplo.extraerDatosTabla(urlEquipo,3);
		
		//ejemplo.extraerUrlImagen("https://www.bing.com/images/search?q=gatos&go=Buscar&qs=ds&form=QBIR");
	}

}
