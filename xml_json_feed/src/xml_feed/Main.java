//He usado el codigo de ejmplo subido a moodle pero le he hecho un par de modificaciones 
//para que funcione, imprima solo cuando se halla generado el documento y que funcione con xml o Json
package xml_feed;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	public static void generateMenu() 
	{
		System.out.println("**************************");
		System.out.println("1.- Enter data");
		System.out.println("2.- Export to xml");
		System.out.println("3.- Export to Json");
		System.out.println("4.- Mocks");
		System.out.println("0.- Quit");
	}
	
	public static Alumno showSubmenu() throws IOException 
	{
		java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String name = null;
		String surname = null;
		System.out.println("Enter name:");
		name = in.readLine();
		System.out.println("Enter surname:");
		surname = in.readLine();
		Alumno alumn = new Alumno(name, surname);
		return alumn;
	}
	
	public static void writeToFile(String txt, String fileName) throws IOException 
	{
	    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
	    try {
			writer.write(txt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}
	

	public static void main(String[] args) throws IOException {
			
			ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
			int menu = -1;
			
			java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			while (menu != 0) 
			{
				generateMenu();
				menu = Integer.parseInt(in.readLine());
				
				switch (menu) 
				{
					case 1:
						Alumno alumno_leido = showSubmenu();
						alumnos.add(alumno_leido);
						break;
					case 2:
						String header = "<?xml version=\"1.0\" encoding=\"UTF-8\">\n";
						String root = "<clase>\n";
						String xml = "";
						xml += header + root;
						for (Alumno a: alumnos) 
						{
							xml += a.toXml();
						}
						String close_root = "</clase>";
			
						xml += close_root;
	
						System.out.println(xml);
						writeToFile(xml, "xmlFile.xml");
						break;
					case 3:
						String headerJ = "{\n";
						String clase = "\t\"clase\":[\n";
						String xmlJ = "";
						xmlJ += headerJ+clase ;
						int i = 0;
						for (Alumno a: alumnos) 
						{
							xmlJ += a.toJson();
							i++;
							if (i < alumnos.size())
							{
								xmlJ += ",\n";
							}
							
						}
						String closeclase = "\n\t\t]\n";
						String close = "\n}";	
						xmlJ += closeclase+close;
						
	
						System.out.println(xmlJ);
						
						writeToFile(xmlJ, "JsonFile.xml");
						break;
					case 4:
						Direccion direccion = new Direccion("Cerro del Espino", 9, 28221, "Madrid", "Espanya");
						Localizacion localizacion1 = new Localizacion(10, "A", "AC");
						Localizacion localizacion2 = new Localizacion(11, "D", "AP");
						Producto producto1 = new Producto(213, "Alfombra fashion", "Alfombra del siglo XII", 12, localizacion1, 29);
						Producto producto2 = new Producto(209, "TV 4K Samsung", "Television curva cara", 29, localizacion2, 10029);
						ArrayList<Producto> productos = new ArrayList<Producto>();
						productos.add(producto1);
						productos.add(producto2);
						ArrayList<Integer> numeroProductos = new ArrayList();
						numeroProductos.add(3);
						numeroProductos.add(1);
						String destinatario = "Aaron Hoffman";
						
						Pedido pedido = new Pedido(productos, numeroProductos, direccion, destinatario);
						String xm =pedido.toString();
						System.out.println(xm);
						
						writeToFile(xm, "JsonFile.xml");
						break;
				}
				System.out.println("Saliendo del programa");
			}
				

	}

}
