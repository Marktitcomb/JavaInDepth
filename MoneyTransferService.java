public class MoneyTransferService{
	
	CurrencyConverter cc = new CurrencyConverter();


    
	double computeTransferAmount(int countryIndex, double amount) {

            return cc.computeTransferAmount(countryIndex, amount); 

        }
		
	double computeTransferFee(int countryIndex, double amount) {

            return (double)0.02 * computeTransferAmount(countryIndex, amount); 

        }	 
		
	public static void main(String[] args){
		
		MoneyTransferService payPal = new MoneyTransferService(); 
		
		double transferAmount = payPal.computeTransferAmount(0, 1000);
		double transferFree = payPal.computeTransferFee(0, 1000);
		
		System.out.println("Transfer Amount:" + transferAmount);
		System.out.println("Transfer Free:" + transferFree);
	}
}
