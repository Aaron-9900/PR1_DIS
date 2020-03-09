package xml_feed;

import java.util.ArrayList;

public class Pedido {
	private ArrayList<Producto> productos;
	private ArrayList<Integer> cantidades;
	private Direccion direccion;
	private String destinatario;

	public Pedido(ArrayList<Producto> productos, ArrayList<Integer> cantidades ,Direccion direccion, String destinatario) {
		super();
		this.productos = productos;
		this.cantidades = cantidades;
		this.direccion = direccion;
		this.destinatario = destinatario;
		//TODO: Add date field (possibly with a library or with a class
	}

	/**
	 * @return the destinatario
	 */
	public String getDestinatario() {
		return destinatario;
	}

	/**
	 * @param destinatario the destinatario to set
	 */
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	/**
	 * @return the productos
	 */
	public ArrayList<Producto> getProductos() {
		return productos;
	}

	/**
	 * @param productos the productos to set
	 */
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	/**
	 * @return the cantidades
	 */
	public ArrayList<Integer> getCantidades() {
		return cantidades;
	}

	/**
	 * @param cantidades the cantidades to set
	 */
	public void setCantidades(ArrayList<Integer> cantidades) {
		this.cantidades = cantidades;
	}

	/**
	 * @return the direccion
	 */
	public Direccion getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
}
