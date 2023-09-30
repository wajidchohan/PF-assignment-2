public class Assignment {
    // instance variables
    private String name;
    private String mark;

    public Assignment(String name, String mark) {
        // initialise instance variables
        this.name = name;
        this.mark = mark;
    }

    public String getAssignmentName() {
        return this.name;
    }

    public String getAssignmentMark() {
        return this.mark;
    }
}
