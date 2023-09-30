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
            //printStudentRecords();
            System.out.print("> Select a menu option to continue: ");
            getMenuOption();
        }
        if (menu_option.equals("3")) {
            // menu option 3
            if (data.size() == 0) {
                data = dataReader.getStudentRecords();

            }
            //printMarksLessThanThreshold();
            System.out.print("> Select a menu option to continue: ");
            getMenuOption();
        }
        if (menu_option.equals("4")) {
            // menu option 4
            if (data.size() == 0) {
                data = dataReader.getStudentRecords();

            }
            //printTopTenStudents();
            System.out.print("> Select a menu option to continue: ");
            getMenuOption();
        }
        if (menu_option.equals("5")) {
            System.out.println("Program exited...goodbye!");
            System.exit(0);
        }

    }
}