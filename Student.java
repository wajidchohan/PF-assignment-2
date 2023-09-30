public class Student {
    // instance variables
    private String lastName;
    private String firstName;
    private String studentId;
    private Unit unit;

    public Student(String lastName, String firstName, String studentId, Unit unit) {
        // initialise instance variables
        this.lastName = lastName;
        this.firstName = firstName;
        this.studentId = studentId;
        this.unit = unit;
    }

    public String getStudentName() {
        return this.lastName + " " + this.firstName;
    }

    public String getStudentId() {
        return this.studentId;
    }

    public Unit getUnit() {
        return this.unit;
    }

}
