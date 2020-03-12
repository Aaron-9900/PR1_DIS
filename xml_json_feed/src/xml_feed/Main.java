 //He usado el codigo de ejmplo subido a moodle pero le he hecho un par de modificaciones 
//para que funcione, imprima solo cuando se halla generado el documento y que funcione con xml o Json
package xml_feed;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

public class Main {
	
	public static void generateMenu() 
	{
		System.out.println("**************************");
		System.out.println("1.- Enter data");
		System.out.println("2.- Save to xml");
		System.out.println("3.- Export to xml");
		System.out.println("4.- validate to Xml");
		System.out.println("0.- Quit");
	}
	
	public static void generateMenuData() 
	{
		System.out.println("**************************");
		System.out.println("1.- Enter data");
		System.out.println("2.- Save to xml");
		System.out.println("3.- Export to Json");
		System.out.println("4.- validate to Xml");
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
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}
	

	public static void main(String[] args) throws IOException, Exception {
			
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
						String header = "<?xml version=\"1.0\" encoding=\"UTF-8\">\n<!DOCTYPE pedido SYSTEM  \"pedidos.dtd\"\r\n" + 
								"";
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
						System.out.println(XMLUtils.validateWithDTDUsingDOM("xmlFile.xml"));
					    System.out.println(XMLUtils.validateWithDTDUsingSAX("xmlFile.xml"));
						break;
				}
				System.out.println("Saliendo del programa");
			}
				

	}

}
