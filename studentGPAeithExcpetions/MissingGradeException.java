package studentGPAeithExcpetions;

import java.lang.Throwable; 

public class MissingGradeException extends RuntimeException{
	
	private int studentId;

	public MissingGradeException(int studentId) {
		super();
		this.studentId = studentId;
		// TODO Auto-generated constructor stub
	}



	public int getStudentId() {
		return studentId;
	}
	

}
