package PatientLayers;
import java.util.Date;

public class Medication {										//Medication class is set as Public
	private String name;
	private String dosage;
	private Date startDate;
	private Date endDate;
	
	public Medication(String name, String dosage, Date startDate, Date endDate)			//Medication method
	{
		this.name = name;									//
		this.dosage = dosage;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Date getEndDate()
	{
		return endDate;
	}
	
	public String toString()									
	{
		return name + " " + dosage + " " + startDate.toString() + " " + endDate.toString();	//string to print out our return statement
	}
}
