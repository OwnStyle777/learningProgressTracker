package tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface InitCoursesCategories {

    //Most and least active course depends on  points contributions by course
    default String getTheMostActiveCourse(int java, int DSA, int databases, int spring) {

        List<String> listOfCourses = new ArrayList<>();
        String theMostActive = "n/a";
        if (java > 1 || DSA > 1 || databases > 1 || spring > 1) {
            int maximum = Math.max(Math.max(java, DSA), Math.max(databases, spring));
            if (java == maximum) {
                listOfCourses.add("Java");
            }
            if (DSA == maximum) {
                listOfCourses.add("DSA");
            }
            if (databases == maximum) {
                listOfCourses.add("Databases");
            }
            if (spring == maximum) {
                listOfCourses.add("Spring");
            }
        }
        if (!listOfCourses.isEmpty()) {
            return String.join(", ", listOfCourses);
        }
        return theMostActive;
    }

    default String getTheLeastActiveCourse(int java, int DSA, int databases, int spring) {
        List<String> listOfCourses = new ArrayList<>();
        String theLeastActive = "n/a";

        if (java > 1 || DSA > 1 || databases > 1 || spring > 1) {
            int minimum = Math.min(Math.min(java, DSA), Math.min(databases, spring));
            if (java == minimum) {
                listOfCourses.add("Java");
            }
            if (DSA == minimum) {
                listOfCourses.add("DSA");
            }
            if (databases == minimum) {
                listOfCourses.add("Databases");
            }
            if (spring == minimum) {
                listOfCourses.add("Spring");
            }
        }
        if (!listOfCourses.isEmpty()) {
            if (String.join(", ", listOfCourses).equalsIgnoreCase(getTheMostActiveCourse(java, DSA, databases, spring))) {
                return "n/a";
            }
            return String.join(", ", listOfCourses);
        }

        return theLeastActive;
    }


    //Most and least popular course depends on enrolled students
    default String getTheMostPopularCourse(HashMap<Integer, Student> students) {
        int javaStudents = 0;
        int DSAStudents = 0;
        int databasesStudents = 0;
        int springStudents = 0;

        //if student has more than 0 points is automatically enrolled to course
        for (Map.Entry<Integer, Student> entry : students.entrySet()) {
            Student student = entry.getValue();
            if (student.getJavaScore() > 0) {
                javaStudents++;
            }
            if (student.getDSAScore() > 0) {
                DSAStudents++;
            }
            if (student.getDatabasesScore() > 0) {
                databasesStudents++;
            }
            if (student.getSpringScore() > 0) {
                springStudents++;
            }
        }

        return getTheMostActiveCourse(javaStudents, DSAStudents, databasesStudents, springStudents);
    }

    default String getTheLeastPopularCourse(HashMap<Integer, Student> students) {
        int javaStudents = 0;
        int DSAStudents = 0;
        int databasesStudents = 0;
        int springStudents = 0;

        for (Map.Entry<Integer, Student> entry : students.entrySet()) {
            Student student = entry.getValue();
            if (student.getJavaScore() > 0) {
                javaStudents++;
            }
            if (student.getDSAScore() > 0) {
                DSAStudents++;
            }
            if (student.getDatabasesScore() > 0) {
                databasesStudents++;
            }
            if (student.getSpringScore() > 0) {
                springStudents++;
            }
        }
        //if least popular equals most popular (cause that only one student is enrolled) marked least popular "n/a"
        if (getTheMostActiveCourse(javaStudents, DSAStudents, databasesStudents, springStudents).equalsIgnoreCase(getTheLeastActiveCourse(javaStudents, DSAStudents, databasesStudents, springStudents))) {
            return "n/a";
        }
        return getTheLeastActiveCourse(javaStudents, DSAStudents, databasesStudents, springStudents);
    }

    //hardest and easiest course depends on total points gained by all students
    default String getTheHardestCourse(HashMap<Integer, Student> students) {

        int javaPoints = 0;
        int DSAPoints = 0;
        int databasesPoints = 0;
        int springPoints = 0;

        for (Map.Entry<Integer, Student> entry : students.entrySet()) {
            Student student = entry.getValue();
            javaPoints += student.getJavaScore();
            DSAPoints += student.getDSAScore();
            databasesPoints += student.getDatabasesScore();
            springPoints += student.getSpringScore();
        }
        return getTheLeastActiveCourse(javaPoints, DSAPoints, databasesPoints, springPoints);
    }

    default String getTheEasiestCourse(HashMap<Integer, Student> students) {

        int javaPoints = 0;
        int DSAPoints = 0;
        int databasesPoints = 0;
        int springPoints = 0;

        for (Map.Entry<Integer, Student> entry : students.entrySet()) {
            Student student = entry.getValue();
            javaPoints += student.getJavaScore();
            DSAPoints += student.getDSAScore();
            databasesPoints += student.getDatabasesScore();
            springPoints += student.getSpringScore();
        }
        return getTheMostActiveCourse(javaPoints, DSAPoints, databasesPoints, springPoints);
    }
}
