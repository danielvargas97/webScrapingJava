package logica;

public class Controlador {

	public static void main(String[] args) {
		Scrapper ejemplo = new Scrapper();
		//ejemplo.prueba("http://www.zillow.com/homes/for_sale/Denver-CO");
		//ejemplo.prueba("https://listado.mercadolibre.com.co/playstation-4#D[A:playstation%204]");
		//ejemplo.extraerDatosTabla("https://es.wikipedia.org/wiki/Anexo:Libros_m%C3%A1s_vendidos",4);
		ejemplo.extraerUrlImagen("https://www.bing.com/images/search?q=gatos&go=Buscar&qs=ds&form=QBIR");
	}

}
