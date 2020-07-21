public class Billing {
    
    public Patient patient; 
    public double amount;
   
    public static double[] computePaymentAmount(Patient patient, double amount) {
        double[] payments = new double[2];
		int discount = 20;
        
        HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();
		if(patientInsurancePlan == null){return new double[] {0.0, amount-discount};}
        
		double coverage = patientInsurancePlan.getCoverage();
        
		
		
        
        if(coverage == 0.9){discount = 50;}
        if(coverage == 0.8){discount = 40;}
        if(coverage == 0.7){discount = 30;}
        if(coverage == 0.6){discount = 25;}

        double patientPayment = (amount - amount*coverage)-discount;
        double insurancePayment = amount * coverage  ;
        
        payments[0] = insurancePayment; 
        payments[1] = patientPayment;
       

        return payments;
    }

}