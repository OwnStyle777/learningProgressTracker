package tracker;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class StudentsOperations implements VerificationOfCredentials {

    private static VerificationOfCredentials verification = new VerificationOfCredentials() {
    };
    private static DetailsOfCourses details = new DetailsOfCourses() {
    };
    private static InitCoursesCategories initCoursesCategories = new InitCoursesCategories() {
    };
    static int studentID = 10000;
    static int contributionsJava = 0, contributionsDSA = 0, contributionsDatabases = 0, contributionsSpring = 0;

    public static void menu() {
        System.out.println("Write your command: ");
        System.out.println("(add students, list, find, add points, statistics, notify, exit.)");
    }

    public static void addStudents(Scanner scanner, int totalStudentsAdded, HashMap<Integer, Student> students) {
        System.out.println("Enter student credentials or 'back' to return (name, last name, email)");
        boolean back = false;
        while (!back) {
            String studentsCredentials = scanner.nextLine();
            if (studentsCredentials.equals("back")) {
                back = true;
                System.out.println("Total " + totalStudentsAdded + " students have been added.");
            } else if (verification.validateCredentials(studentsCredentials, students, studentID)) {
                System.out.println("The student has been added.");
                totalStudentsAdded++;
                studentID++;
            }
        }
    }

    public static void listOfStudents(HashMap<Integer, Student> students) {

        if (students.isEmpty()) {
            System.out.println("No students found");
        } else {
            System.out.println("Students: ");
            for (Map.Entry<Integer, Student> entry : students.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue().getFirstName() + " " + entry.getValue().getSecondName());
            }
        }
    }

    public static void addPoints(Scanner scanner, HashMap<Integer, Student> students) {
        boolean back = false;
        System.out.println("Enter an id and points(id, Java, DSA, Databases, Spring) or 'back' to return:");
        while (!back) {
            try {
                String userIdAndSubjectPoints = scanner.nextLine();
                if (userIdAndSubjectPoints.equals("back")) {
                    back = true;
                } else {

                    String[] subjectPoints = userIdAndSubjectPoints.split(" ");
                    String id = subjectPoints[0];
                    int javaPoints = Integer.parseInt(subjectPoints[1]);
                    int DSAPoints = Integer.parseInt(subjectPoints[2]);
                    int databasesPoints = Integer.parseInt(subjectPoints[3]);
                    int springPoints = Integer.parseInt(subjectPoints[4]);


                    boolean rightPointsFormat = javaPoints >= 0 && DSAPoints >= 0 && databasesPoints >= 0 && springPoints >= 0;
                    try {
                        if (students.containsKey(Integer.parseInt(id))) {
                            if (rightPointsFormat && subjectPoints.length == 5) {
                                if (javaPoints > 0) {
                                    contributionsJava++;
                                }
                                students.get(Integer.parseInt(id)).addJavaScore(javaPoints);
                                if (DSAPoints > 0) {
                                    contributionsDSA++;
                                }
                                students.get(Integer.parseInt(id)).addDSAScore(DSAPoints);
                                if (databasesPoints > 0) {
                                    contributionsDatabases++;
                                }
                                students.get(Integer.parseInt(id)).addDatabasesScore(databasesPoints);
                                if (springPoints > 0) {
                                    contributionsSpring++;
                                }
                                students.get(Integer.parseInt(id)).addSpringScore(springPoints);
                                System.out.println("Points updated.");
                            } else {
                                System.out.println("Incorrect points format");
                            }

                        } else {
                            System.out.println("No student is found for id= " + id + ".");
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("No student is found for id= " + id + ".");
                    }
                }
            } catch (InputMismatchException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Incorrect points format");
            }
        }
    }

    public static void find(Scanner scanner, HashMap<Integer, Student> students) {
        System.out.println("Enter an id or 'back' to return:");
        boolean back = false;

        while (!back) {
            String backOrEnterId = scanner.nextLine();
            if (backOrEnterId.equals("back")) {
                back = true;
            } else {
                try {
                    int id = Integer.parseInt(backOrEnterId);

                    if (students.containsKey(id)) {
                        System.out.println("Id:" + id + " " + students.get(id).toString());
                    } else {
                        System.out.println("No student is found for id= " + id + ".");
                    }
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Incorrect id format.");
                }
            }
        }
    }

    public static void getStatistics(Scanner scanner, HashMap<Integer, Student> students) {
        System.out.println("Type the name of a course to see details or 'back' to quit");
        System.out.println("Most popular: " + initCoursesCategories.getTheMostPopularCourse(students) + " \nLeast popular: " + initCoursesCategories.getTheLeastPopularCourse(students));
        System.out.println("Highest activity: " + initCoursesCategories.getTheMostActiveCourse(contributionsJava, contributionsDSA, contributionsDatabases, contributionsSpring));
        System.out.println("Lowest activity: " + initCoursesCategories.getTheLeastActiveCourse(contributionsJava, contributionsDSA, contributionsDatabases, contributionsSpring));
        System.out.println("Easiest course: " + initCoursesCategories.getTheEasiestCourse(students) + " \nHardest course: " + initCoursesCategories.getTheHardestCourse(students));

        boolean back = false;
        while (!back) {
            String chooseCourse = scanner.nextLine();
            if (chooseCourse.equals("back")) {
                back = true;
            } else {
                if (chooseCourse.equalsIgnoreCase("java")) {
                    details.showJavaCourseDetails(students);
                } else if (chooseCourse.equalsIgnoreCase("dsa")) {
                    details.showDSACourseDetails(students);
                } else if (chooseCourse.equalsIgnoreCase("databases")) {
                    details.showDatabasesCourseDetails(students);
                } else if (chooseCourse.equalsIgnoreCase("spring")) {
                    details.showSpringCourseDetails(students);
                } else {
                    System.out.println("Unknown course");
                }

            }
        }
    }

    public static void printNotification(String email, String firstName, String secondName, String course) {
        System.out.println("To: " + email);
        System.out.println("Re: Your Learning Progress");
        System.out.println("Hello, " + firstName + " " + secondName + "! You have accomplished our " + course + " course!");
    }

    public static void notifyStudents(HashMap<Integer, Student> students) {
        int studentsNotified = 0;
        for (Map.Entry<Integer, Student> entry : students.entrySet()) {
            int coursesCompleted = 0;
            Student student = entry.getValue();

            if (student.getJavaScore() >= 600 && !student.isJavaCourseCompleted()) {
                printNotification(student.getEmail(), student.getFirstName(), student.getSecondName(), "Java");
                coursesCompleted++;
                student.setJavaCourseCompleted(true);
            }
            if (student.getDSAScore() >= 400 && !student.isDSACourseCompleted()) {
                printNotification(student.getEmail(), student.getFirstName(), student.getSecondName(), "DSA");
                coursesCompleted++;
                student.setDSACourseCompleted(true);
            }
            if (student.getDatabasesScore() >= 480 && !student.isDatabasesCourseCompleted()) {
                printNotification(student.getEmail(), student.getFirstName(), student.getSecondName(), "Databases");
                coursesCompleted++;
                student.setDatabasesCourseCompleted(true);
            }
            if (student.getSpringScore() >= 550 && !student.isSpringCourseCompleted()) {
                printNotification(student.getEmail(), student.getFirstName(), student.getSecondName(), "Spring");
                coursesCompleted++;
                student.setSpringCourseCompleted(true);
            }
            if (coursesCompleted > 0) {
                studentsNotified++;
            }
        }
        System.out.println("Total " + studentsNotified + " students have been notified");
    }
}


