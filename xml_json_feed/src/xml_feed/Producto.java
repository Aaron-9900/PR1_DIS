package xml_feed;

public class Producto {
	private Integer codigo;
	private String nombre;
	private String descripcion;
	private Integer stock;
	private Localizacion localizacion;
	private Integer pendientes;
	private String cantidad;
	@Override
	public String toString() {
		return "<producto>"
				+ "<codigo>"+ codigo +"</codigo>"
				+ "<nombre>"+nombre+"</nombre>"
				+ "<descripcion>"+descripcion+"</descripcion>"
				+ "<stock>"+stock+"</stock>"
				+ "<pendientes>"+pendientes+"</pendientes>"
				+ "" + localizacion.toString()
				+"</producto>";
	}
	public String toString(Integer cantidad) {
		return "<producto>"
				+ "<codigo>"+ codigo +"</codigo>"
				+ "<nombre>"+nombre+"</nombre>"
				+ "<descripcion>"+descripcion+"</descripcion>"
				+ "<stock>"+stock+"</stock>"
				+ "<pendientes>"+pendientes+"</pendientes>"
				+ "<cantidad>"+cantidad+"</cantidad>"
				+"</producto>";
	}
	public Producto(Integer codigo, String nombre, String descripcion, Integer stock, Localizacion localizacion, Integer pendientes,String cantidad) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.stock = stock;
		this.localizacion = localizacion;
		this.pendientes = pendientes;
		this.cantidad = cantidad;
	}
	public Producto() {
		
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
	 * @return the pendientes
	 */
	public Integer getPendientes() {
		return pendientes;
	}

	/**
	 * @param pendientes the pendientes to set
	 */
	public void setPendientes(Integer pendientes) {
		this.pendientes = pendientes;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
}
