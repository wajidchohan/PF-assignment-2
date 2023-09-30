import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class DataReader {
    private static String unitName;
    private static ArrayList<Student> studentRecords = new ArrayList<Student>();

    public ArrayList<Student> getStudentRecords() {
        try {
            Scanner sc = new Scanner(new File(
            		"C:\\Users\\wajid\\Downloads\\prog5001_students_grade_2022.csv"));

            unitName = sc.nextLine().split(":", 2)[1]; // read unit name

            sc.nextLine(); // Skip header text. 

            while (sc.hasNextLine()) {

                createStudentRecord(sc.nextLine());
            }
            
        } catch (Exception e) {
            System.out.println("Something went horribly wrong!");
        }

        return studentRecords;
    }

    public void createStudentRecord(String line) {

        Unit unit;
        Student student;
        ArrayList<Assignment> assignments;
        String lastName;
        String firstName;
        String studentId;
        String A1;
        String A2;
        String A3;

        String[] studentRecord = line.split(",", -1);

        lastName = studentRecord[0];
        firstName = studentRecord[1];
        studentId = studentRecord[2];

        A1 = studentRecord[3];
        A2 = studentRecord[4];
        A3 = studentRecord[5];

        assignments = new ArrayList<Assignment>();
        assignments.add(new Assignment("A1", A1));
        assignments.add(new Assignment("A2", A2));
        assignments.add(new Assignment("A3", A3));

        unit = new Unit(unitName, assignments);

        student = new Student(lastName, firstName, studentId, unit);

        studentRecords.add(student);

    }

}
