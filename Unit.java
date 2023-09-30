import java.util.*;

public class Unit {
    // instance variables
    private String name;
    private ArrayList<Assignment> assignments;

    public Unit(String name, ArrayList<Assignment> assignments) {

        this.name = name;
        this.assignments = assignments;
    }

    public String getUnitName() {
        return this.name;
    }

    public ArrayList<Assignment> getAssignments() {
        return this.assignments;
    }

}
