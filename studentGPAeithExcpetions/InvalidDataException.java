package studentGPAeithExcpetions;

public class InvalidDataException extends Exception {
	
	private int studentId;
	
	public InvalidDataException(int studentId, MissingGradeException cause) {
		super(cause); 
		this.studentId = studentId;
	}

}
