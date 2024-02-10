package tracker;

import java.util.*;


public class Main implements DetailsOfCourses {
    private static HashMap<Integer, Student> students = new HashMap<>();

    public static void main(String[] args) {

        System.out.println("Learning Progress Tracker \n");
        StudentsOperations.menu();

        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        int totalStudentsAdded = 0;
        while (!exit) {
            String command = scanner.nextLine();

            if (command.isBlank()) {
                System.out.println("No input");
            } else {
                switch (command) {
                    case "exit":
                        System.out.println("Bye!");
                        exit = true;
                        break;
                    case "back":
                        System.out.println("Enter 'exit' to exit the program.");
                        break;
                    case "add students":
                        StudentsOperations.addStudents(scanner, totalStudentsAdded, students);
                        break;
                    case "list":
                        StudentsOperations.listOfStudents(students);
                        break;
                    case "find":
                        StudentsOperations.find(scanner, students);
                        break;
                    case "add points":
                        StudentsOperations.addPoints(scanner, students);
                        break;
                    case "statistics":
                        StudentsOperations.getStatistics(scanner, students);
                        break;
                    case "notify":
                        StudentsOperations.notifyStudents(students);
                        break;
                    default:
                        System.out.println("Error: Unknown command!");
                        break;

                }
            }
        }
    }
}



