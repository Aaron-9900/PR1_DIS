 //He usado el codigo de ejmplo subido a moodle pero le he hecho un par de modificaciones 
//para que funcione, imprima solo cuando se halla generado el documento y que funcione con xml o Json
package xml_feed;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

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
		System.out.println("3.- validate to Xml");
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
	
	public static String formatXML(String input) {
        Source xmlInput = new StreamSource(new StringReader(input));
        StringWriter stringWriter = new StringWriter();
        StreamResult xmlOutput = new StreamResult(stringWriter);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        transformerFactory.setAttribute("indent-number", 4);
        Transformer transformer = null;
		try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        
        try {
			transformer.transform(xmlInput, xmlOutput);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return xmlOutput.getWriter().toString();

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
						System.out.println(XMLUtils.validateWithDTDUsingDOM("xmlFile.xml"));
					    System.out.println(XMLUtils.validateWithDTDUsingSAX("xmlFile.xml"));
						break;
					case 4:
						Direccion direccion = new Direccion("Cerro del Espino", 9, 28221, "Madrid", "Espanya");
						Localizacion localizacion1 = new Localizacion(10, 1, 2);
						Localizacion localizacion2 = new Localizacion(11, 4, 2);
						Producto producto1 = new Producto(213, "Alfombra fashion", "Alfombra del siglo XII", 12, localizacion1, 29);
						Producto producto2 = new Producto(209, "TV 4K Samsung", "Television curva cara", 29, localizacion2, 10029);
						ArrayList<Producto> productos = new ArrayList<Producto>();
						productos.add(producto1);
						productos.add(producto2);
						ArrayList<Integer> numeroProductos = new ArrayList();
						numeroProductos.add(3);
						numeroProductos.add(1);
						Cliente destinatario = new Cliente("Jose", "Gil", "jose@gmail.com", 661929292, direccion);
						Pedido pedido = new Pedido(productos, numeroProductos, direccion, destinatario);
						Pedido pedido2 = new Pedido(productos, numeroProductos, direccion, destinatario);

						String xm = "<root>" 
									+ pedido.toString()
									+ "</root>";
						xm = formatXML(xm);
						System.out.println(xm);
						
						writeToFile(xm, "JsonFile.xml");
						break;
				}
				System.out.println("Saliendo del programa");
			}
				

	}

}
