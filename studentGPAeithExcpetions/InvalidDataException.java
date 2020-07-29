package studentGPAeithExcpetions;

public class InvalidDataException extends Exception {
	
	private int studentId;
	
	public InvalidDataException(int studentId, Throwable cause) {
		super(cause); 
		this.studentId = studentId;
	}

}
