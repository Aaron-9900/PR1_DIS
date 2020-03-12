package xml_feed;

public class Direccion {
	private String calle;
	private Integer numero;
	private Integer codigoPostal;
	private String poblacion;
	private String pais;
	@Override
	public String toString() {
		return "<direccion>"
				+ "\n\t<calle>"+ calle +"</calle>"
				+ "\n\t<numero>"+numero+"</numero>"
				+ "\n\t<codigoPostal>"+codigoPostal+"</codigoPostal>"
				+ "\n\t<poblacion>"+poblacion+"</poblacion>"
				+ "\n\t<pais>"+pais+"</pais>"
				+"</direccion>";
	}
	public Direccion(String calle, Integer numero, Integer codigoPostal, String poblacion, String pais) {
		this.calle = calle;
		this.numero = numero;
		this.codigoPostal = codigoPostal;
		this.poblacion = poblacion;
		this.pais = pais;
	}

	/**
	 * @return the calle
	 */
	public String getCalle() {
		return calle;
	}

	/**
	 * @param calle the calle to set
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}

	/**
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	/**
	 * @return the codigoPostal
	 */
	public Integer getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * @param codigoPostal the codigoPostal to set
	 */
	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	/**
	 * @return the poblacion
	 */
	public String getPoblacion() {
		return poblacion;
	}

	/**
	 * @param poblacion the poblacion to set
	 */
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}
}
