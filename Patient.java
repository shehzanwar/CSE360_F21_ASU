package PatientLayers;
import java.time.LocalDate;
import java.util.ArrayList;


public class Patient {
	//patient constructor
	private String firstName;
	private String lastName;
	private LocalDate birthLocalDate;
	private String phoneNum;
	private String email;
	private String insuranceProvider;
	private String prefPharmacy;
	private String insuranceID;
	private String insurancePhone;
	private String pharmacyPhone;
	private ArrayList<Medication> meds;
	private ArrayList<Immunization> immunizations;
	private ArrayList<String> allergies;
	//private ArrayList
	// need attribute for medical records (current height/weight/BP, temp)
	//need reference to past visits, past medical issues, current medications
	// create class for Medication (name, dosage, startLocalDate, endLocalDate)
	// in patient class store an array of Medications. If endLocalDate is past today, show as current Medication. If LocalDate is past, show as past Medication. This is shown in all 3 views.
	//create vectors or arrays for them
	
	//create a separate class for DoctorVisit. The nurse interaction is in first and then hand to doc. It interacts with the nurse and upLocalDates the values in the Patient Object. 
	//create a separate class for DoctorVisit. This is the class the doctor interaction is in. The doc upLocalDates the records for patients medical issues and any new medication.
	//When the patient logs in again, in the patient view, they see their medical history : current medications, previous doctor visits, current cotact info (that they can upLocalDate), 
	// preferred pharmacy and insurance they can upLocalDate.
	//3 separate UI screens (Patient, Doc, Nurse). 
	private double height; //in inches
	private double weight; //in pounds
	private int BP;
	private int BP2;
	private double temp;
	private String userName;
	private String password;
	
	
	
	public Patient(String firstName, String lastName, LocalDate birthLocalDate, String userName, String password)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthLocalDate = birthLocalDate;
		this.userName = userName;
		this.password = password;
	}
	
	public void addPharmacy(String pName, String pPhone)
	{
		this.prefPharmacy = pName;
		this.pharmacyPhone = pPhone;
	}
	
	public void addInsurance(String iName, String iPhone, String id)
	{
		this.insuranceProvider = iName;
		this.insurancePhone = iPhone;
		this.insuranceID = id;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public LocalDate getBirthLocalDate()
	{
		return birthLocalDate;
	}
	
	public String getUserName()
	{
		return userName;
	}
	public void addMedication(Medication m1)
	{
		meds.add(m1);
	}
	public ArrayList<Medication> getMedications()
	{
		return meds;
	}
	public void addImmunization(Immunization i1)
	{
		immunizations.add(i1);
	}
	public ArrayList<Immunization> getImmunizations()
	{
		return immunizations;
	}
	
	public void addAllergy(String allergy)
	{
		allergies.add(allergy);
	}
	public ArrayList<String> getAllergies()
	{
		return allergies;
	}
	
	
	//method to upLocalDate insurance (takes all 3)
	//gettors to get each string
	//method to upLocalDate pharmacy phone and name
	//gettors to get each string
	//method to upLocalDate contact phone and separatepy email
	

}
