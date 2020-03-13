package xml_feed;

public class Indent {

	public Indent() {
	}
	
	public String getIndents(Integer number) {
		String sol = "";
		for(int i = 0; i < number; i++) {
			sol += "\t";
		}
		return sol;
	}
	
	
}
