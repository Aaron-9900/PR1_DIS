package xml_feed;

import java.util.ArrayList;

public class Pedido {
	private ArrayList<Producto> productos;
	private ArrayList<Integer> cantidades;
	private Direccion direccion;
	private Cliente destinatario;
	@Override
	public String toString() {
		return "<pedido>"
				+ "" + direccion.toString()
				+ "" + destinatario.toString()
				+ "" + getProductListXML()
				+"</pedido>";
	}
	public Pedido(ArrayList<Producto> productos, ArrayList<Integer> cantidades ,Direccion direccion, Cliente destinatario) {
		super();
		this.productos = productos;
		this.cantidades = cantidades;
		this.direccion = direccion;
		this.destinatario = destinatario;
		//TODO: Add date field (possibly with a library or with a class
	}
	private String getProductListXML() {
		String sol = "";
		sol += "<productos>";
		for(int i = 0; i < productos.size(); i++) {
			sol += productos.get(i).toString(cantidades.get(i)) + "";
		}
		sol += "</productos>";
		return sol;
	}

	/**
	 * @return the destinatario
	 */
	public Cliente getDestinatario() {
		return destinatario;
	}

	/**
	 * @param destinatario the destinatario to set
	 */
	public void setDestinatario(Cliente destinatario) {
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
