package PatientLayers;
import java.util.Date;
import java.util.ArrayList;

public class Visit {
	private Date visitDate;
	private double height; //in inches
	private double weight; //in pounds
	private int BP;
	private int BP2;
	private double temp;
	private ArrayList<Medication> meds;
	private String issue;
	
	public Visit(double height, double weight, int BP, int BP2, double temp, Date visitDate)
	{
		this.height = height;
		this.weight = weight;
		this.BP = BP;
		this.BP2 = BP2;
		this.temp = temp;
		this.visitDate = visitDate;
		
	}
	
	public void addDocInfo(ArrayList<Medication> meds, String issue)
	{
		
	}

}
