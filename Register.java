package PatientLayers;
import java.util.ArrayList;
import java.time.LocalDate;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;



// List of UIs we need to implement (assumption - only 1 doc, 1 nurse, multiple patients)
// 1. Welcome screen for Patients that has 2 choices (Login or Register)
// 2. Login screen for Patient - if successful, show Patient view, else error message to reset password.
// 3. Register Patient (must take first, last, bdate and check if already there. If not, create new patient. Optional fields for contact number, email, pharmacy, insurance)
// 4. Nurse View (select patient name or bdate to look up info). Show patient history and allow update on pateitn info and update medical records (like height/weight etc)
// 5. Doctor View (select pateitn name to look up info). Show pateitne history and current updates from nurse. Add new medicines and issues.



//for welcome screen you need to create welcome title and 2 buttons ("Register" or "Login")
// if Register then call the below createRegistrationPane else go to Login pane and display Patient View
// you can put PaitentView as a separate class that works on the Patient Object

public class Register extends Application {

	private Stage myStage;
	private ArrayList<Patient> patients = new ArrayList<Patient>();
    public void start(Stage primaryStage) throws Exception {
    	myStage = primaryStage;
        myStage.setTitle("ASU Medical Center");
        //GridPane gridPane = createRegistrationPane();
        
        //RegistrationUI(gridPane);
        Scene scene = createWelcomeScene();
        myStage.setScene(scene);
        myStage.show();
    }
    

   // private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
       // Alert alert = new Alert(alertType);
        //alert.setTitle(title);
        //alert.setHeaderText(null);
        //alert.setContentText(message);
       // alert.initOwner(owner);
       // alert.show();
   // }
    
  
    private Scene createWelcomeScene()
    {
    	GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(40,40,40,40));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);
        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);
        Label label = new Label("Welcome to the Patient\n Health Portal");
        label.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(label, 0,0,2,1);
        GridPane.setHalignment(label, HPos.CENTER);
        GridPane.setMargin(label, new Insets(20, 0,20,0));
        Button login = new Button("Login");
        login.setPrefHeight(40);
        login.setDefaultButton(true);
        login.setPrefWidth(100);
        gridPane.add(login, 0,4,2,1);
        GridPane.setHalignment(login, HPos.CENTER);
        GridPane.setMargin(login, new Insets(20,0,20,0));
        
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override

            public void handle(ActionEvent event) {
            	myStage.setScene(createLoginScene());
                

            }
        
        });
        Button register = new Button("Register");
        register.setPrefHeight(40);
        register.setDefaultButton(true);
        register.setPrefWidth(100);
        gridPane.add(register, 0,3, 2,1);
        GridPane.setHalignment(register, HPos.CENTER);
        GridPane.setMargin(register, new Insets(20,0,20,0));
        //final OuterClass self = this;
        register.setOnAction(new EventHandler<ActionEvent>() {
            @Override

            public void handle(ActionEvent event) {
            	myStage.setScene(createRegistrationScene());
                

            }
        
        });
        return new Scene(gridPane);
    }

    
    private Scene createRegistrationScene() {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(40,40,40,40));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);
        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);
        RegistrationUI(gridPane);
        return new Scene(gridPane);
    }

    private Scene createLoginScene() {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(40,40,40,40));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);
        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);
        LoginUI(gridPane);
        return new Scene(gridPane);
    }
    
    private Scene createPatientScene(Patient p1) {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(40,40,40,40));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);
        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);
        PatientUI(gridPane, p1);
        return new Scene(gridPane);
    }
    
    
    private void NurseUI(GridPane gridPane)
    {
    	Label title = new Label("Nurse Portal");
    	title.setFont(Font.font("Arial", FontWeight.BOLD, 24));
    	gridPane.add(title, 0,0,2,1);
    	GridPane.setHalignment(title, HPos.CENTER);
        GridPane.setMargin(title, new Insets(20, 0,20,0));
        Button patientButton;
        Patient p1;
        Button logout = new Button("Logout");
        logout.setPrefHeight(20);
        logout.setDefaultButton(true);
        logout.setPrefWidth(100);
        gridPane.add(logout, 4,0,1,1);
        GridPane.setHalignment(logout, HPos.CENTER);
        GridPane.setMargin(logout, new Insets(20,0,20,0));
        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override

            public void handle(ActionEvent event) {
            	myStage.setScene(createWelcomeScene());
               
            }});
        
    	// find patient
        Label nameL = new Label("First Name: ");
        gridPane.add(nameL, 0, 1);
        TextField name = new TextField();
        name.setPrefHeight(40);
        gridPane.add(name,1,1);

        Label name2L = new Label("Last Name: ");
        gridPane.add(name2L, 0, 2);
        TextField name2 = new TextField();
        name2.setPrefHeight(40);
        gridPane.add(name2,1,2);

        Label bDateL = new Label("Birth Date: ");
        gridPane.add(bDateL, 0, 3);
        DatePicker bDate = new DatePicker();
        bDate.setPrefHeight(40);
        gridPane.add(bDate,1,3);
        
        Button submit = new Button("Search");
        submit.setPrefHeight(40);
        submit.setDefaultButton(true);
        submit.setPrefWidth(100);
        gridPane.add(submit, 2,3,2,1);
        GridPane.setHalignment(submit, HPos.CENTER);
        GridPane.setMargin(submit, new Insets(20,0,20,0));

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override

            public void handle(ActionEvent event) {
                
            	boolean exists = false;
                Patient p1 = null;
                // search for patient
                for (int i =0; i < patients.size(); i++)
                {
                	if (name.getText().equals(patients.get(i).getFirstName()) &&
                    		name2.getText().equals(patients.get(i).getLastName()) &&
                    		bDate.getValue().equals(patients.get(i).getBirthLocalDate()))
                	{
                		
                		exists = true;
                		p1 = patients.get(i);
                		
                		break;
                	}
                		
                } 
                if (exists) {
                	
                	myStage.setScene(createNurseEntryScene(p1));
                }
                else {
                	showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Patient not found");
                }
            }
        });
    }
           
   private Scene createNurseEntryScene(Patient p1)
   {
	   GridPane gridPane = new GridPane();
       gridPane.setPadding(new Insets(40,40,40,40));
       gridPane.setAlignment(Pos.CENTER);
       gridPane.setHgap(10);
       gridPane.setVgap(10);
       ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
       columnOneConstraints.setHalignment(HPos.RIGHT);
       ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
       columnTwoConstrains.setHgrow(Priority.ALWAYS);
       gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);
       NurseEntryUI(gridPane, p1);
       return new Scene(gridPane);
   }
   
 private void NurseEntryUI(GridPane gridPane, Patient p1) 
 {
                	// show patient details and enter temp/bp data
                	Label label = new Label("Patient Info for  " + p1.getFirstName());
                    label.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                    gridPane.add(label, 0,5,2,1);
                                        
                    Label temp = new Label("Temp in\n Farhenheit: ");
                    gridPane.add(temp, 0, 6);
                    TextField tempTxt = new TextField();
                    
                    gridPane.add(tempTxt,1,6);

                    Label height = new Label("Height in inches: ");
                    gridPane.add(height, 0, 7);
                    TextField heightTxt = new TextField();
                    
                    gridPane.add(heightTxt,1,7);

                    Label weight = new Label("Weight in Lbs: ");
                    gridPane.add(weight, 0, 8);
                    TextField weightTxt = new TextField();
                    
                    gridPane.add(weightTxt,1,8);
                    
                    Label bp = new Label("Blood Pressure\n Systolic: ");
                    gridPane.add(bp, 0, 9);
                    TextField bpText = new TextField();
                    
                    gridPane.add(bpText,1,9);
                    
                    Label bp2 = new Label("Blood Pressure\n Diastolic: ");
                    gridPane.add(bp2, 0, 10);
                    TextField bpText2 = new TextField();
                    
                    gridPane.add(bpText2,1,10);
                    
                    Button submit = new Button("Submit");
                    submit.setPrefHeight(40);
                    submit.setDefaultButton(true);
                    submit.setPrefWidth(100);
                    gridPane.add(submit, 0,12,2,1);
                    GridPane.setHalignment(submit, HPos.CENTER);
                    GridPane.setMargin(submit, new Insets(20,0,20,0));
                    submit.setOnAction(new EventHandler<ActionEvent>() {
                        @Override

                        public void handle(ActionEvent event) {
                        	double height = Double.parseDouble(heightTxt.getText());
                        	double weight = Double.parseDouble(weightTxt.getText());
                        	double temp = Double.parseDouble(tempTxt.getText());
                        	int bpOne = Integer.parseInt(bpText.getText());
                        	int bpTwo = Integer.parseInt(bpText2.getText());
                        	
                        	p1.addVisit(new Visit(height,weight, bpOne, bpTwo, temp, LocalDate.now()));
                        	myStage.setScene(createWelcomeScene());
                        }
                    });
                	//save a new visit in patient record with this, update patient current ht/weight
                	
 }
        
        
   
    
    private Scene createNurseScene() {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(40,40,40,40));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);
        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);
        NurseUI(gridPane);
        return new Scene(gridPane);
    }
    
    private void PatientUI(GridPane gridPane, Patient p1)
    {
    	Label label = new Label("Patient Portal for  " + p1.getFirstName());
        label.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(label, 0,0,2,1);
        GridPane.setHalignment(label, HPos.CENTER);
        GridPane.setMargin(label, new Insets(20, 0,20,0));
        Button logout = new Button("Logout");
        logout.setPrefHeight(20);
        logout.setDefaultButton(true);
        logout.setPrefWidth(100);
        gridPane.add(logout, 4,0,1,1);
        GridPane.setHalignment(logout, HPos.CENTER);
        GridPane.setMargin(logout, new Insets(20,0,20,0));
        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override

            public void handle(ActionEvent event) {
            	myStage.setScene(createWelcomeScene());
               
            }});
        
        
        
        Label patientInfoL = new Label("Patient Information ");
        patientInfoL.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        gridPane.add(patientInfoL, 0,0,2,2);
        GridPane.setHalignment(patientInfoL, HPos.CENTER);
        GridPane.setMargin(patientInfoL, new Insets(20, 0,20,0));
        // Edit Contact Info for self/
        Label emailL = new Label("Email: ");
        gridPane.add(emailL, 0, 1);
        System.out.println(p1.getEmail());
        TextField email = new TextField(p1.getEmail());
        email.setPrefHeight(40);
        gridPane.add(email,1,1);
        Button submit = new Button("Update");
        submit.setPrefHeight(20);
        submit.setDefaultButton(true);
        submit.setPrefWidth(100);
        gridPane.add(submit, 2,1,1,1);
        GridPane.setHalignment(submit, HPos.CENTER);
        GridPane.setMargin(submit, new Insets(20,0,20,0));
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override

            public void handle(ActionEvent event) {
                
               if (email.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a valid email");
                    return;
                }
               p1.setEmail(email.getText());
            }});
        
        
        

        Label phL = new Label("Phone: ");
        gridPane.add(phL, 0, 2);
        TextField phone = new TextField(p1.getPhoneNum());
        phone.setPrefHeight(40);
        gridPane.add(phone,1,2);
        Button submit2 = new Button("Update");
        submit2.setPrefHeight(20);
        submit2.setDefaultButton(true);
        submit2.setPrefWidth(100);
        gridPane.add(submit2, 2,2,1,1);
        GridPane.setHalignment(submit2, HPos.CENTER);
        GridPane.setMargin(submit2, new Insets(20,0,20,0));
        submit2.setOnAction(new EventHandler<ActionEvent>() {
            @Override

            public void handle(ActionEvent event) {
                
               if (phone.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a phone number");
                    return;
                }
               p1.setPhoneNum(phone.getText());
            }});
        
                
        
        // Medication History
        patientInfoL = new Label("Current Medicines");
        patientInfoL.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        gridPane.add(patientInfoL, 0,3,2,2);
        GridPane.setHalignment(patientInfoL, HPos.CENTER);
        GridPane.setMargin(patientInfoL, new Insets(20, 0,20,0));
        
        if (p1.getMedications().isEmpty()) {
        	label = new Label("No current medications");
             gridPane.add(label, 0,4,2,1);
        } else {
        	for (int i=0; i< p1.getMedications().size(); i++)
        	{
        		label = new Label(p1.getMedications().get(i).toString());
        		gridPane.add(label, 0, 5+i, 2,1);
        	}
        }
        
        // Visit history
        patientInfoL = new Label("Doctor Visits");
        patientInfoL.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        gridPane.add(patientInfoL, 0,5,2,2);
        GridPane.setHalignment(patientInfoL, HPos.CENTER);
        GridPane.setMargin(patientInfoL, new Insets(20, 0,20,0));
        
        if (p1.getVisits().isEmpty()) {
        	label = new Label("No past visits");
             gridPane.add(label, 0,6,2,1);
        } else {
        	for (int i=0; i< p1.getVisits().size(); i++)
        	{
        		label = new Label(p1.getVisits().get(i).toString());
        		gridPane.add(label, 0, 7+i, 2,1);
        	}
        }
        
        // Immunization record
        
    }
    
    private void LoginUI(GridPane gridPane)
    {
        Label label = new Label("Login");
        label.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(label, 0,0,2,1);
        GridPane.setHalignment(label, HPos.CENTER);
        GridPane.setMargin(label, new Insets(20, 0,20,0));

        Label nameL = new Label("User Name: ");
        gridPane.add(nameL, 0, 1);
        TextField name = new TextField();
        name.setPrefHeight(40);
        gridPane.add(name,1,1);

        Label passwordL = new Label("Password: ");
        gridPane.add(passwordL,0,3);
        PasswordField passwordField = new PasswordField();
        passwordField.setPrefHeight(40);
        gridPane.add(passwordField,1,3);

        Button submit = new Button("Submit");
        submit.setPrefHeight(40);
        submit.setDefaultButton(true);
        submit.setPrefWidth(100);
        gridPane.add(submit, 0,4,2,1);
        GridPane.setHalignment(submit, HPos.CENTER);
        GridPane.setMargin(submit, new Insets(20,0,20,0));

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override

            public void handle(ActionEvent event) {
                
                if (passwordField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a password");
                    return;
                }
                if (name.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your user name");
                    return;
                }


                //showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registration Successful!", "Welcome " + name.getText());
                // retrieve patient from userName and display Patient Records
                //if login by Nurse, display Nurse View
                //if login by Doc, display Doc View
                if (name.getText().equals("Doctor"))
                {
                	// show Doctor view
                	
                }
                else if (name.getText().equals("Nurse")) 
                {
                	//show Nurse View
                	myStage.setScene(createNurseScene());
                }
                else {
                boolean exists = false;
                Patient p1 = null;
                // search for patient
                for (int i =0; i < patients.size(); i++)
                {
                	if (name.getText().equals(patients.get(i).getUserName()))
                	{
                		
                		exists = true;
                		p1 = patients.get(i);
                		//System.out.println(p1.getEmail());
                		break;
                	}
                		
                } 
                if (exists) {
                	// show patient view
                	myStage.setScene(createPatientScene(p1));
                }
                else {
                	showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Patient not found");
                }
            }
            }
        });
    }
    
    
    private void RegistrationUI(GridPane gridPane)
    {
        Label label = new Label("Registration form");
        label.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(label, 0,0,2,1);
        GridPane.setHalignment(label, HPos.CENTER);
        GridPane.setMargin(label, new Insets(20, 0,20,0));

        Label nameL = new Label("First Name: ");
        gridPane.add(nameL, 0, 1);
        TextField name = new TextField();
        name.setPrefHeight(40);
        gridPane.add(name,1,1);

        Label name2L = new Label("Last Name: ");
        gridPane.add(name2L, 0, 2);
        TextField name2 = new TextField();
        name2.setPrefHeight(40);
        gridPane.add(name2,1,2);

        

        Label bDateL = new Label("Birth Date: ");
        gridPane.add(bDateL, 0, 3);
        DatePicker bDate = new DatePicker();
        bDate.setPrefHeight(40);
        gridPane.add(bDate,1,3);

        Label emailL = new Label("Email: ");
        gridPane.add(emailL, 0, 4);
        TextField email = new TextField();
        email.setPrefHeight(40);
        gridPane.add(email,1,4);

        Label phL = new Label("Phone: ");
        gridPane.add(phL, 0, 5);
        TextField phone = new TextField();
        phone.setPrefHeight(40);
        gridPane.add(phone,1,5);
        
        Label insNameL = new Label("Insurance \nProvider Name: ");
        gridPane.add(insNameL, 0, 6);
        TextField insName = new TextField();
        insName.setPrefHeight(40);
        gridPane.add(insName,1,6);

        Label insphL = new Label("Insurance \nProvider Phone: ");
        gridPane.add(insphL, 0, 7);
        TextField insPhone = new TextField();
        insPhone.setPrefHeight(40);
        gridPane.add(insPhone,1,7);
        
        Label inIDL = new Label("Insurance \nProvider ID: ");
        gridPane.add(inIDL, 0, 8);
        TextField insId = new TextField();
        insId.setPrefHeight(40);
        gridPane.add(insId,1,8);
        
        Label pNameL = new Label("Pharmacy \nName: ");
        gridPane.add(pNameL, 0, 9);
        TextField pName = new TextField();
        pName.setPrefHeight(40);
        gridPane.add(pName,1,9);

        Label pphL = new Label("Pharmacy\n Phone: ");
        gridPane.add(pphL, 0, 10);
        TextField pPhone = new TextField();
        pPhone.setPrefHeight(40);
        gridPane.add(pPhone,1,10);
        
                
        Label userL = new Label("User Name: ");
        gridPane.add(userL, 0, 11);
        TextField userName = new TextField();
        userName.setPrefHeight(40);
        gridPane.add(userName,1,11);
        
        Label passwordL = new Label("Password: ");
        gridPane.add(passwordL,0,12);
        PasswordField passwordField = new PasswordField();
        passwordField.setPrefHeight(40);
        gridPane.add(passwordField,1,12);

        Button submit = new Button("Submit");
        submit.setPrefHeight(40);
        submit.setDefaultButton(true);
        submit.setPrefWidth(100);
        gridPane.add(submit, 0,13,2,1);
        GridPane.setHalignment(submit, HPos.CENTER);
        GridPane.setMargin(submit, new Insets(20,0,20,0));

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override

            public void handle(ActionEvent event) {
                if (email.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your email id");
                    return;
                }
                if (passwordField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a password");
                    return;
                }
                if (name.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your name");
                    return;
                }
                boolean exists = false;
                // add new patient to master patient list if doesn't exist
                for (int i =0; i < patients.size(); i++)
                {
                	if (name.getText().equals(patients.get(i).getFirstName()) &&
                		name2.getText().equals(patients.get(i).getLastName()) &&
                		bDate.getValue().equals(patients.get(i).getBirthLocalDate()))
                	{
                		showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Patient already registered");
                		exists = true;
                		break;
                	}
                		
                } 
                if (exists == false) {
                	Patient p1 = new Patient(name.getText(), name2.getText(), bDate.getValue(), userName.getText(), passwordField.getText() );
                	p1.addInsurance(insName.getText(), insPhone.getText(), insId.getText());
                	p1.addPharmacy(pName.getText(), pPhone.getText());
                	p1.setEmail(email.getText()); 
                	p1.setPhoneNum(phone.getText());
                	patients.add(p1);
                	showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registration Successful!", "Welcome " + name.getText());
                	myStage.setScene(createWelcomeScene());
                }
            }
        });
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
    
    
    
    
    
    public static void main(String[] args) {
        launch(args);
    }

}
