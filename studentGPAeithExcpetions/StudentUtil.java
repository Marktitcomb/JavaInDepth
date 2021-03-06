package studentGPAeithExcpetions;

import java.lang.Throwable;

public class StudentUtil {

	public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) throws MissingGradeException{
		// Your code: throw IllegalArgumentException with the message that lengths of
		// input arrays are out-of-sync
		// because length us a final variable for arrays
		if (studentIdList.length != studentsGrades.length) {
			// parameter validation
			throw new IllegalArgumentException("studentIdList & studentsGrades are out-of-sync. studentIdList.length: "
					+ studentIdList.length + ",studentsGrades.legth" + studentsGrades.length);

		}

		double[] gpaList = new double[studentIdList.length];

		for (int i = 0; i < studentsGrades.length; i++) {
			double gpa = 0.0;

			for (int j = 0; j < studentsGrades[i].length; j++) {
				if (studentsGrades[i][j] == 'A') {
					gpa += 4.0;
				} else if (studentsGrades[i][j] == 'B') {
					gpa += 3.0;
				} else if (studentsGrades[i][j] == 'C') {
					gpa += 2.0;
				} else if (studentsGrades[i][j] == ' ') {
					throw new MissingGradeException(studentIdList[i]);
					// student is yet to receive a grade
					// Your code: throw checked exception MissingGradeException with student ID
				}
			}

			gpaList[i] = gpa / studentsGrades[i].length;
		}

		return gpaList;
	}

	public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) 
	throws InvalidDataException{
		try {
			if (lower < 0 || higher < 0 || lower > higher) {
				return null;
			}

			double[] gpaList = new double[studentIdList.length];
			// Your code: catch MissingGradeException and re-throw runtime exception
			// InvalidDataException initialized with the cause MissingGradeException
			gpaList = calculateGPA(studentIdList, studentsGrades);

			int count = 0;
			for (double gpa : gpaList) {
				if (gpa >= lower && gpa <= higher) {
					count++;
				}
			}

			int[] result = new int[count];
			int index = 0;
			for (int i = 0; i < gpaList.length; i++) {
				if (gpaList[i] >= lower && gpaList[i] <= higher) {
					result[index++] = studentIdList[i];
				}
			}
			return result; 

			
		} catch (MissingGradeException e) {
			//System.out.println(e.toString());
			throw new InvalidDataException(e.getStudentId(),e);//this is the chaining
			
		
		}
		

	}

}
