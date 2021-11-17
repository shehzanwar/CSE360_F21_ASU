package PatientLayers;

import java.util.Date;

public class Immunization {						//Immunization class is going to be public
	private String name;
	private String dosage;
	private Date day;
	public Immunization(String name, String dosage, Date day)	
	{
		this.name = name;
		this.dosage = dosage;
		this.day = day;
		
	}
	public String toString()					//string to print out return statement
	{
		return name + " " + dosage + " " + day.toString();	
	}
}
