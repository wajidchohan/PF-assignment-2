import java.util.*;

public class StudentRecord {

    // private static String unitName;
    private static ArrayList<Student> data = new ArrayList<Student>();
    private static DataReader dataReader = new DataReader();

    public static void main(String[] args) {

        System.out.println("MAIN MENU");
        System.out.println("1) Read Text File");
        System.out.println("2) Print Total Marks");
        System.out.println("3) Print Marks Less Than Threshold");
        System.out.println("4) Print Top 10 Lowest & Highest Marks");
        System.out.println("5) Exit.");
        System.out.println();
        System.out.print("> Select a menu option to continue: ");
        getMenuOption();

    }


    private static void getMenuOption() {

        String menu_option;

        Scanner input = new Scanner(System.in);

        menu_option = input.nextLine().trim();

        // validate input
        try {
            int choice = Integer.parseInt(menu_option);
            if (choice > 5 || choice < 0) {
                // input.close();
                System.out.println("Invalid Menu Option. Try Again!");
                System.out.print("> Select a menu option to continue: ");
                getMenuOption();

            }

        } catch (Exception e) {
            System.out.println("Invalid Menu Option. Try Again!");
            System.out.print("> Select a menu option to continue: ");
            getMenuOption();

        }

        if (menu_option.equals("1")) {
            // option 1
            if (data.size() == 0) {
                data = dataReader.getStudentRecords();

            }
            System.out.println("Text file successfully read!");
            System.out.print("> Select a menu option to continue: ");
            getMenuOption();
        }
        if (menu_option.equals("2")) {
            // menu option 2

            if (data.size() == 0) {
                data = dataReader.getStudentRecords();

            }
            printStudentRecords();
            System.out.print("> Select a menu option to continue: ");
            getMenuOption();
        }
        if (menu_option.equals("3")) {
            // menu option 3
            if (data.size() == 0) {
                data = dataReader.getStudentRecords();

            }
            printMarksLessThanThreshold();
            System.out.print("> Select a menu option to continue: ");
            getMenuOption();
        }
        if (menu_option.equals("4")) {
            // menu option 4
            if (data.size() == 0) {
                data = dataReader.getStudentRecords();

            }
            printTopfiveStudents();
            System.out.print("> Select a menu option to continue: ");
            getMenuOption();
        }
        if (menu_option.equals("5")) {
            System.out.println("Program exited...goodbye!");
            System.exit(0);
        }

    }

    public static void printStudentRecords() {

        double total = 0;
        int i = 1;
        String unitName;
        String studentName;
        String studentId;

        String assignment_1_name;
        String assignment_2_name;
        String assignment_3_name;

        double assignment_1_mark;
        double assignment_2_mark;
        double assignment_3_mark;

        System.out.println("List of students with their name, id, assessment marks, and total mark");
        
        for (Student student : data) {
            unitName = student.getUnit().getUnitName(); // not asked to print out unit name
            studentName = student.getStudentName();
            studentId = student.getStudentId();

            assignment_1_name = student.getUnit().getAssignments().get(0).getAssignmentName();
            assignment_1_mark = student.getUnit().getAssignments().get(0).getAssignmentMark().isEmpty() ? 0
                    : Double.parseDouble(student.getUnit().getAssignments().get(0).getAssignmentMark());

            assignment_2_name = student.getUnit().getAssignments().get(1).getAssignmentName();
            assignment_2_mark = student.getUnit().getAssignments().get(1).getAssignmentMark().isEmpty() ? 0
                    : Double.parseDouble(student.getUnit().getAssignments().get(1).getAssignmentMark());

            assignment_3_name = student.getUnit().getAssignments().get(2).getAssignmentName();
            assignment_3_mark = student.getUnit().getAssignments().get(2).getAssignmentMark().isEmpty() ? 0
                    : Double.parseDouble(student.getUnit().getAssignments().get(2).getAssignmentMark());

            ArrayList<Assignment> assignments = student.getUnit().getAssignments();

            for (Assignment assignment : assignments) {
                if (!assignment.getAssignmentMark().isEmpty()) {
                    total += Double.parseDouble(assignment.getAssignmentMark());
                }
            }
 
            System.out.println(
                    "#" + i + " Student Name: " + studentName + " , " + "ID: " + studentId + " , " + assignment_1_name
                            + ": " + assignment_1_mark + " , " + assignment_2_name
                            + ": " + assignment_2_mark + " , " + assignment_3_name
                            + ": " + assignment_3_mark + " , " + "Total Mark: " + total);
            System.out.println();
            i++;
            total = 0;

        }
        i = 1;

    }

    public static void printMarksLessThanThreshold() {

        double threshold = 0.0;
        double total = 0.0;
        int i = 1;

        Scanner input = new Scanner(System.in);
        System.out.print("> Enter Threshold: ");

        // validate input
        try {
            threshold = input.nextDouble();
            System.out.println("List of students with their total marks less than a certain threshold");

        } catch (Exception e) {
            System.out.println("Invalid Input. Please try again!");

        }

        for (Student student : data) {

            ArrayList<Assignment> assignments = student.getUnit().getAssignments();

            for (Assignment assignment : assignments) {
                if (!assignment.getAssignmentMark().isEmpty()) {
                    total += Double.parseDouble(assignment.getAssignmentMark());
                }
            }
            if (total < threshold) {
                System.out.println(
                        "#" + i + " Student Name: " + student.getStudentName() + " , " + "Total Mark: " + total);
                System.out.println();
                i++;

            }

            total = 0;

        }
        i = 1;

    }

    //F4: Print the top 5 students with the highest

    public static void printTopfiveStudents() {
        double total = 0.0;
        String studentName;
        Map<String, Double> map = new HashMap<String, Double>();
        ArrayList<Double> fiveHighestMarks = new ArrayList<Double>();
        ArrayList<Double> fiveLowestMarks = new ArrayList<Double>();

        for (Student student : data) {

            studentName = student.getStudentName();

            ArrayList<Assignment> assignments = student.getUnit().getAssignments();

            for (Assignment assignment : assignments) {
                if (!assignment.getAssignmentMark().isEmpty()) {
                    total += Double.parseDouble(assignment.getAssignmentMark());
                }
            }

            map.put(studentName, total);
            total = 0;

        }

        List<Double> totalMarks = new ArrayList<>(map.values());
        Collections.sort(totalMarks);

        Set<Double> set = new LinkedHashSet<>(); // remove duplicates

        set.addAll(totalMarks);
        totalMarks.clear();
        totalMarks.addAll(set);

        // get Lowest 5
        for (int i = 0; i < 5; i++) {
            fiveLowestMarks.add(totalMarks.get(i));
        }
        // get Highest 5
        for (int i = totalMarks.size() - 1; i >= totalMarks.size() - 5; i--) {
            fiveHighestMarks.add(totalMarks.get(i));
        }

        System.out.println("List of students with the top five highest marks");
        
        for (Double mark : fiveHighestMarks) {

            if (map.containsValue(mark)) {
                for (Map.Entry<String, Double> record : map.entrySet()) {
                    if (record.getValue().equals(mark)) {
                        System.out.println(
                                "Student Name: " + record.getKey() + " , " + "Total Mark: " + record.getValue());

                    }

                }

            }

        }

        System.out.println("List of students with the top five lowest marks");
        
        for (Double mark : fiveLowestMarks) {

            if (map.containsValue(mark)) {
                for (Map.Entry<String, Double> record : map.entrySet()) {
                    if (record.getValue().equals(mark)) {
                        System.out.println(
                                "Student Name: " + record.getKey() + " , " + "Total Mark: " + record.getValue());

                    }

                }

            }

        }

    }

}
