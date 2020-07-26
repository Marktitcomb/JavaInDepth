

public class APIFormatChangeException extends Exception {
	private String response;
	private String elementName;
	private String partner; 
	
	public APIFormatChangeException(String response, String elementName, String partner, Throwable cause) {//lower level exception{
		super("Responce: " + response + "Element: " + elementName + "Partner: " + partner, cause);
		this.response 		= response; 
		this.elementName 	= elementName;
		this.partner 		= partner;
		
	}
	
	public APIFormatChangeException() {
		super();
		// TODO Auto-generated constructor stub
	}


	public APIFormatChangeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}


	public APIFormatChangeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}


	public APIFormatChangeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}


	public APIFormatChangeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}


	


	public String getResponse() {
		return response;
	}


	public void setResponse(String response) {
		this.response = response;
	}


	public String getElementName() {
		return elementName;
	}


	public void setElementName(String elementName) {
		this.elementName = elementName;
	}


	public String getPartner() {
		return partner;
	}


	public void setPartner(String partner) {
		this.partner = partner;
	}

}
