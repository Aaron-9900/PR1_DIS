 //He usado el codigo de ejmplo subido a moodle pero le he hecho un par de modificaciones 
//para que funcione, imprima solo cuando se halla generado el documento y que funcione con xml o Json
package xml_feed;

import java.io.BufferedReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

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
		System.out.println("1.- Introducir productos en fichero");
		System.out.println("2.- Leer xml");
		System.out.println("3.- validate to Xml");
		System.out.println("4.- Mocks");
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
	
	public static ArrayList<Producto> introducirProductos() throws IOException 
	{
		java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Producto> listaProductos = new ArrayList<Producto>();
		int input = 0;
		int iter = 0;
		do {
			if(iter == 0) {
				System.out.println("Ahora está introducciendo un producto.");
			}
			System.out.println("Nombre:");
			String nombre = in.readLine();
			System.out.println("Codigo:");
			Integer codigo = Integer.parseInt(in.readLine());
			System.out.println("Descripcion:");
			String descripcion = in.readLine();
			System.out.println("Stock:");
			Integer stock = Integer.parseInt(in.readLine());			
			System.out.println("Pasillo:");
			Integer pasillo = Integer.parseInt(in.readLine());
			System.out.println("Estanteria:");
			Integer estanteria = Integer.parseInt(in.readLine());
			System.out.println("Estante:");
			Integer estante = Integer.parseInt(in.readLine());
			System.out.println("Pendientes:");
			Integer pendientes = Integer.parseInt(in.readLine());
			
			Localizacion localizacion = new Localizacion(pasillo, estanteria, estante);
			Producto producto = new Producto(codigo, nombre, descripcion, stock, localizacion, pendientes);
			
			listaProductos.add(producto);
			
			System.out.println("¿Desea introducir otro producto?");
			System.out.println("1- Si");
			System.out.println("2- No");
			input = Integer.parseInt(in.readLine());
			
			
		}while(input != 2);
		String productosXML = getProductListXML(listaProductos);
		try {
	        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
	        Document document = documentBuilder.parse("productos.xml");
	        Element root = document.getDocumentElement();
	        
	        
			for(int i = 0; i < listaProductos.size(); i++) {
				Producto productoActual = listaProductos.get(i);
				Element prod = productoToXML(productoActual, document);
	            root.appendChild(prod);
			}
			
		    TransformerFactory transformerFactory = TransformerFactory.newInstance();
		    Transformer transformer = transformerFactory.newTransformer();
		    DOMSource source = new DOMSource(document);

		    StreamResult result = new StreamResult("productos.xml");
		    transformer.transform(source, result);
			
		} catch(Exception a) {
			productosXML = formatXML(productosXML);
			writeToFile(productosXML, "productos.xml");
			
		}
		
		return listaProductos;
	}
	private static Element productoToXML(Producto productoActual, Document document) {
		Element pr = document.createElement("producto");
		
        Element nombre = document.createElement("nombre");
        nombre.appendChild(document.createTextNode(productoActual.getNombre()));
        pr.appendChild(nombre);
        
        Element codigo = document.createElement("nombre");
        codigo.appendChild(document.createTextNode(productoActual.getCodigo().toString()));
        pr.appendChild(codigo);
        
        Element descripcion = document.createElement("descripcion");
        descripcion.appendChild(document.createTextNode(productoActual.getDescripcion()));
        pr.appendChild(descripcion);
        
        Element stock = document.createElement("stock");
        stock.appendChild(document.createTextNode(productoActual.getStock().toString()));
        pr.appendChild(stock);
        
        Element pendientes = document.createElement("pendientes");
        pendientes.appendChild(document.createTextNode(productoActual.getPendientes().toString()));
        pr.appendChild(pendientes);
        
        pr.appendChild(localizacionToXML(productoActual.getLocalizacion(), document));
        
        return pr;
	}
	private static Element localizacionToXML(Localizacion localizacion, Document document) {
		Element loc = document.createElement("localizacion");
		
        Element pasillo = document.createElement("pasillo");
        pasillo.appendChild(document.createTextNode(localizacion.getPasillo().toString()));
        loc.appendChild(pasillo);
        
        Element estanteria = document.createElement("estanteria");
        pasillo.appendChild(document.createTextNode(localizacion.getEstanteria().toString()));
        loc.appendChild(estanteria);
        
        Element estante = document.createElement("pasillo");
        pasillo.appendChild(document.createTextNode(localizacion.getEstante().toString()));
        loc.appendChild(estante);
        
        return loc;
        
	}
	private static Element clienteToXML(Cliente cliente,Document document) {
		
		Element cl = document.createElement("cliente");
		
        Element nombre = document.createElement("nombre");
        nombre.appendChild(document.createTextNode(cliente.getNombre()));
        cl.appendChild(nombre);
        
        Element apellido = document.createElement("apellido");
        apellido.appendChild(document.createTextNode(cliente.getApellido()));
        cl.appendChild(apellido);
        
        Element email = document.createElement("email");
        email.appendChild(document.createTextNode(cliente.getEmail()));
        cl.appendChild(email);
        
        Element telefono = document.createElement("telefono");
        telefono.appendChild(document.createTextNode(cliente.getTelf().toString()));
        cl.appendChild(telefono);
        
        
       cl.appendChild(direccionToXML(cliente.getDireccion(), document));
       return cl;
		
	}
	
	private static Element pedidoToXML(Pedido pedido, Document document) {
		Element pd = document.createElement("pedido");
		Element productos = document.createElement("productos");
		ArrayList<Producto> listaProductos = pedido.getProductos();
		for(int i = 0; i < listaProductos.size(); i++) {
			Producto productoActual = listaProductos.get(i);
			Element prod = productoToXML(productoActual, document);
            productos.appendChild(prod);
		}
		pd.appendChild(productos);
		pd.appendChild(clienteToXML(pedido.getDestinatario(), document));
		pd.appendChild(direccionToXML(pedido.getDireccion(), document));
		
		return pd;
		
	}
	private static Element direccionToXML(Direccion direccion, Document document) {
		Element dir = document.createElement("direccion");
		
		Element calle = document.createElement("calle");
		calle.appendChild(document.createTextNode(direccion.getCalle()));
        dir.appendChild(calle);
        
		Element codigoPostal = document.createElement("codigoPostal");
		codigoPostal.appendChild(document.createTextNode(direccion.getCodigoPostal().toString()));
        dir.appendChild(codigoPostal);
		
        Element numero = document.createElement("numero");
        numero.appendChild(document.createTextNode(direccion.getNumero().toString()));
        dir.appendChild(numero);
        
        Element poblacion = document.createElement("poblacion");
        poblacion.appendChild(document.createTextNode(direccion.getPoblacion()));
        dir.appendChild(poblacion);
        
        Element pais = document.createElement("pais");
        pais.appendChild(document.createTextNode(direccion.getPais()));
        dir.appendChild(pais);
        
        return dir;
        
	}
	
	private static String getProductListXML(ArrayList <Producto>productos) {
		String sol = "";
		sol += "<productos>";
		for(int i = 0; i < productos.size(); i++) {
			sol += productos.get(i).toString() + "";
		}
		sol += "</productos>";
		return sol;
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
	
	public static void readXML(String name) throws SAXException, IOException {
		File fXmlFile = new File(name);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		Document doc = dBuilder.parse(fXmlFile);
		System.out.println(doc.getDocumentElement().getTextContent());
		
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
						// Pedido pedido = showSubmenu();
						introducirProductos();
						break;
					case 2:
						/*
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
						*/
						readXML("productos.xml");
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
						
						writeToFile(xm, "xmlFile.xml");
						break;
				}
				System.out.println("Saliendo del programa");
			}
				

	}

}
