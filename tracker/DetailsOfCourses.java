package tracker;

import java.util.*;

public interface DetailsOfCourses {

    default void showJavaCourseDetails(Map<Integer, Student> students) {
        double javaFullPoints = 600;
        System.out.println("Java");
        System.out.printf("%-6s %-10s %-12s%n", "id", "points", "completed");
        HashMap<Integer, Integer> javaStudents = new HashMap<>();


        for (Map.Entry<Integer, Student> entry : students.entrySet()) {
            Student student = entry.getValue();
            Integer id = entry.getKey();
            int javaScore = student.getJavaScore();
            if (student.getJavaScore() > 0) {
                javaStudents.put(id, javaScore);
            }
        }

        //created a list of Map.Entry(key, value) and sorted every Entry in list by descending order, using compare 2 value  to 1
        List<Map.Entry<Integer, Integer>> sortedJavaScores = new ArrayList<>(javaStudents.entrySet());
        sortedJavaScores.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        for (Map.Entry<Integer, Integer> entry : sortedJavaScores) {
            Integer id = entry.getKey();
            Integer javaScore = entry.getValue();
            double progressPercents = javaScore / (javaFullPoints / 100);
            if(progressPercents > 100){
                progressPercents = 100;
            }
            String formattedProgress = String.format("%.1f%%", progressPercents);
            System.out.printf("%-6d %-10d %-12s%n", id, javaScore, formattedProgress);
        }
    }


    default void showDSACourseDetails(Map<Integer, Student> students) {
        double DSAFullPoints = 400;
        System.out.println("DSA");
        System.out.printf("%-6s %-10s %-12s%n", "id", "points", "completed");
        HashMap<Integer, Integer> DSAStudents = new HashMap<>();


        for (Map.Entry<Integer, Student> entry : students.entrySet()) {
            Student student = entry.getValue();
            Integer id = entry.getKey();
            int DSAScore = student.getDSAScore();
            if (student.getDSAScore() > 0) {
                DSAStudents.put(id, DSAScore);
            }
        }

        List<Map.Entry<Integer, Integer>> sortedDSAScores = new ArrayList<>(DSAStudents.entrySet());
        sortedDSAScores.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        for (Map.Entry<Integer, Integer> entry : sortedDSAScores) {
            Integer id = entry.getKey();
            Integer DSAScore = entry.getValue();
            double progressPercents = DSAScore / (DSAFullPoints / 100);
            if(progressPercents > 100){
                progressPercents = 100;
            }
            String formattedProgress = String.format("%.1f%%", progressPercents);
            System.out.printf("%-6d %-10d %-12s%n", id, DSAScore, formattedProgress);
        }
    }

    default void showDatabasesCourseDetails(Map<Integer, Student> students) {
        double databasesFullPoints = 480;
        System.out.println("Databases");
        System.out.printf("%-6s %-10s %-12s%n", "id", "points", "completed");
        HashMap<Integer, Integer> databasesStudents = new HashMap<>();


        for (Map.Entry<Integer, Student> entry : students.entrySet()) {
            Student student = entry.getValue();
            Integer id = entry.getKey();
            int databasesScore = student.getDatabasesScore();
            if (student.getDatabasesScore() > 0) {
                databasesStudents.put(id, databasesScore);
            }
        }

        List<Map.Entry<Integer, Integer>> databasesScores = new ArrayList<>(databasesStudents.entrySet());
        databasesScores.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        for (Map.Entry<Integer, Integer> entry : databasesScores) {
            Integer id = entry.getKey();
            Integer databasesScore = entry.getValue();
            double progressPercents = databasesScore / (databasesFullPoints / 100);
            if(progressPercents > 100){
                progressPercents = 100;
            }
            String formattedProgress = String.format("%.1f%%", progressPercents);
            System.out.printf("%-6d %-10d %-12s%n", id, databasesScore, formattedProgress);
        }
    }

    default void showSpringCourseDetails(Map<Integer, Student> students) {
        double springFullPoints = 550;
        System.out.println("Spring");
        System.out.printf("%-6s %-10s %-12s%n", "id", "points", "completed");
        HashMap<Integer, Integer> springStudents = new HashMap<>();


        for (Map.Entry<Integer, Student> entry : students.entrySet()) {
            Student student = entry.getValue();
            Integer id = entry.getKey();
            int springScore = student.getSpringScore();
            if (student.getSpringScore() > 0) {
                springStudents.put(id, springScore);
            }
        }

        List<Map.Entry<Integer, Integer>> sortedSpringScores = new ArrayList<>(springStudents.entrySet());
        sortedSpringScores.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        for (Map.Entry<Integer, Integer> entry : sortedSpringScores) {
            Integer id = entry.getKey();
            Integer springScore = entry.getValue();
            double progressPercents = springScore / (springFullPoints / 100);
            if(progressPercents > 100){
                progressPercents = 100;
            }
            String formattedProgress = String.format("%.1f%%", progressPercents);
            System.out.printf("%-6d %-10d %-12s%n", id, springScore, formattedProgress);
        }
    }
}

