public class Patient extends User{
    
    private long patientId;
    private boolean insured; 
    private HealthInsurancePlan insurancePlan; 
    
    public HealthInsurancePlan getInsurancePlan(){
        return insurancePlan;
    }
    public void setInsurancePlan(HealthInsurancePlan insurancePlan){//poloymorphic benefit as it can set any of the other classes
        this.insurancePlan = insurancePlan;
    }
    
    public long getId(){
        return patientId;
    }
    public void setId(long patientId){
        this.patientId =  patientId;
    }
    
    public boolean isInsured(){
        return insured; 
    }
    public void setInsured(boolean insured){
        this.insured = insured; 
    }
    
    
}