package xml_feed;

public class Localizacion {
	private Integer pasillo;
	private Integer estanteria;
	private Integer estante;
	@Override
	public String toString() {
		return "<localizacion>"
				+ "<pasillo>"+ pasillo +"</pasillo>"
				+ "<estanteria>"+estanteria+"</estanteria>"
				+ "<estante>"+estante+"</estante>"
				+"</localizacion>";
	}
	
	public Localizacion(Integer pasillo, Integer estanteria, Integer estante) {
		this.pasillo = pasillo;
		this.estanteria = estanteria;
		this.estante = estante;
	}

	public Localizacion() {
		// TODO Auto-generated constructor stub
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
	public Integer getEstanteria() {
		return estanteria;
	}

	/**
	 * @param estanteria the estanteria to set
	 */
	public void setEstanteria(Integer estanteria) {
		this.estanteria = estanteria;
	}

	/**
	 * @return the estante
	 */
	public Integer getEstante() {
		return estante;
	}

	/**
	 * @param estante the estante to set
	 */
	public void setEstante(Integer estante) {
		this.estante = estante;
	}
	
}
