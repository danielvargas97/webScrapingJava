package logica;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scrapper {
	Document document;
	
	public Scrapper() {
		
	}
	
	public boolean prueba(String url) {
		
		//Creamos un objeto Document  luego de obtener el html de una url
		
		try {
			document = Jsoup.connect(url).get();
			String title = document.title();
			
			System.out.println("Título:"+title);
			
			/*
			Elements precioCasas = document.select(".list-card-price:contains($)");
			
			for(int i = 0; i < precioCasas.size(); i++) {
				System.out.println(precioCasas.get(i).text());
			}
			*/
			
			Elements elem= document.select(".price__fraction");
			Elements titulo = document.select(".main-title");
			String titular = "";
			
	        for(int j = 0; j < elem.size();j++) {
	        	titular = titulo.get(j).text()+" "+elem.get(j).text();
	        	JOptionPane.showMessageDialog(null, titular);
	        }
			


			
			return true;
		}
		catch(IOException e) {
			e.printStackTrace();
			return false;
			
		}
		
		
	}
	public boolean extraerDatosTabla(String url, int seleccionador) {
		
		//Creamos un objeto Document  luego de obtener el html de una url
		
		try {
			document = Jsoup.connect(url).get();
			String title = document.title();
			
			System.out.println("Título:"+title);
						
			
			Elements tablas= document.getElementsByTag("table");
			
			//System.out.println(elem.text());
			
			int seleccionadorTabla = seleccionador;
			
			Elements listaVendidos = tablas.get(seleccionadorTabla).getElementsByTag("tr");
			System.out.println(listaVendidos.get(0).text()+"\n\n");
			
			
			for(int i = 1; i < listaVendidos.size();i++) {
				Elements detallesLibro = listaVendidos.get(i).getElementsByTag("td");
				for(Element elem: detallesLibro) {
					String data = elem.text();
					data = limpiarTexto(data);										
					System.out.println(data);
				}
				System.out.println();
			}
			
			return true;
		}
		catch(IOException e) {
			e.printStackTrace();
			return false;
			
		}
		
		
	}
	
	
	public void extraerUrlImagen(String url) {
		
		//Creamos un objeto Document  luego de obtener el html de una url
		
		try {
			document = Jsoup.connect(url).get();
			String title = document.title();
			
			System.out.println("Título:"+title);
						
			
			Elements resultadoBusqueda = document.select("img.mimg");
			
			for(Element x : resultadoBusqueda) {
				String src = x.attr("src");				
				System.out.println(src);
				
			}
			
			
			
			
		}
		catch(IOException e) {
			e.printStackTrace();
			
		}
	}
	
	
	
	public String limpiarTexto(String texto) {
		if (texto.matches("[1-9][0-9]* millones\\[[1-9][0-9]*\\]")) {
			return texto.substring(0, texto.indexOf("["));
		}
		else {
			return texto;
		}		
	}
	
	
	
}
