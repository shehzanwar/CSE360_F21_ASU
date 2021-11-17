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
		this.height = height;		//obtain Patient's height(inches)
		this.weight = weight;		//obtain Patient's visit weight(lbs)
		this.BP = BP;
		this.BP2 = BP2;
		this.temp = temp;		//obtain Patient's temp
		this.visitDate = visitDate;	//obtain Patient's visit date
		
	}
	
	public void addDocInfo(ArrayList<Medication> meds, String issue)
	{
		
	}

}
