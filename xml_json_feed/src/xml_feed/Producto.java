package xml_feed;

import java.util.ArrayList;

public class Producto {
	private Integer codigo;
	private String nombre;
	private String descripcion;
	private Integer stock;
	private Localizacion localizacion;
	private String pendiente;

	public Producto(Integer codigo, String nombre, String descripcion, Integer stock, Localizacion localizacion, String pendiente) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.stock = stock;
		this.localizacion = localizacion;
		this.pendiente = pendiente;
	}

	/**
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the stock
	 */
	public Integer getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(Integer stock) {
		this.stock = stock;
	}

	/**
	 * @return the localizacion
	 */
	public Localizacion getLocalizacion() {
		return localizacion;
	}

	/**
	 * @param localizacion the localizacion to set
	 */
	public void setLocalizacion(Localizacion localizacion) {
		this.localizacion = localizacion;
	}

	/**
	 * @return the pendiente
	 */
	public String getPendiente() {
		return pendiente;
	}

	/**
	 * @param pendiente the pendiente to set
	 */
	public void setPendiente(String pendiente) {
		this.pendiente = pendiente;
	}	
	
}
