package xml_feed;

public class Alumno {
	private String name;
	private String surname;
	
	
	
	public String toXml() 
	{
		return "\t<alumn>\n\t\t<name>"+name +"</name>\n\t\t<surname>"+surname+"</surname>\n\t</alumn>\n";
	}
	
	public String toJson() 
	{
		return "\n\t\t{\n\t\t\t\"name\": \""+name +"\",\n\t\t\t\"surname\": \""+surname+"\"\n\t\t}";
	}

	public Alumno(String name, String surname) 
	{
		super();
		this.name = name;
		this.surname = surname;
	}
	
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getSurname() 
	{
		return surname;
	}
	public void setSurname(String surname) 
	{
		this.surname = surname;
	}
}
