package xml_feed;

public class Localizacion {
	private Integer pasillo;
	private String estanteria;
	private String estante;
	@Override
	public String toString() {
		return "<localizacion>"
				+ "\n\t<pasillo>"+ pasillo +"</pasillo>"
				+ "\n\t<estanteria>"+estanteria+"</estanteria>"
				+ "\n\t<estante>"+estante+"</estante>"
				+"</localizacion>";
	}
	public Localizacion(Integer pasillo, String estanteria, String estante) {
		this.pasillo = pasillo;
		this.estanteria = estanteria;
		this.estante = estante;
	}

	/**
	 * @return the pasillo
	 */
	public Integer getPasillo() {
		return pasillo;
	}

	/**
	 * @param pasillo the pasillo to set
	 */
	public void setPasillo(Integer pasillo) {
		this.pasillo = pasillo;
	}

	/**
	 * @return the estanteria
	 */
	public String getEstanteria() {
		return estanteria;
	}

	/**
	 * @param estanteria the estanteria to set
	 */
	public void setEstanteria(String estanteria) {
		this.estanteria = estanteria;
	}

	/**
	 * @return the estante
	 */
	public String getEstante() {
		return estante;
	}

	/**
	 * @param estante the estante to set
	 */
	public void setEstante(String estante) {
		this.estante = estante;
	}
}
