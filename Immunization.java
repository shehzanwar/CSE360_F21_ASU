package PatientLayers;

import java.util.Date;

public class Immunization {						//Immunization class is set as Public
	private String name;
	private String dosage;
	private Date day;
	public Immunization(String name, String dosage, Date day)	
	{
		this.name = name;
		this.dosage = dosage;
		this.day = day;
		
	}
	public String toString()					
	{
		return name + " " + dosage + " " + day.toString();	//string to print out our return statement
	}
}
