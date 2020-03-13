package xml_feed;

public class Cliente {
	
	private String nombre;
	private String apellido;
	private String email;
	private Integer Telf;
	private Direccion direccion;
	@Override
	public String toString() {
		return "<cliente>"
				+ "<nombre>" + nombre +"</nombre>"
				+ "<apellido>" + apellido +"</apellido>"
				+ "<email>" + email +"</email>"
				+ "<telefono>" + Telf +"</telefono>"
				+ "" + direccion.toString()
				+"</cliente>";
	}
	public Cliente(String nombre, String apellido, String email, Integer Telf, Direccion direccion) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.Telf = Telf;
		this.direccion = direccion;
	}
	public Cliente() {
		// TODO Auto-generated constructor stub
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
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the Telf
	 */
	public Integer getTelf() {
		return Telf;
	}
	/**
	 * @param telf the telf to set
	 */
	public void setTelf(Integer telf) {
		Telf = telf;
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
