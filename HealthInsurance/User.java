import java.util.Arrays; 
public class User {
    
	private long id;
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	// add rest of the variables
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getGender(){
	    return gender;
	}
	public void setGender(String gender){
	    this.gender = gender;
	}
	public String getEmail(){
	    return email;
	}
	public void setEmail(String email){
	    this.email = email;
	}
	
	public static void main(String[] args){
	    HealthInsurancePlan insurancePlan = new PlatinumPlan();
	    Patient patient = new Patient();
	    patient.setInsurancePlan(insurancePlan);
	    
	    double[] payments = Billing.computePaymentAmount(patient, 950.0);
		
		System.out.println(Arrays.toString(payments));
	}
	
}