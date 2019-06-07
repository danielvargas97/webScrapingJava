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
	
	
	
	
}
