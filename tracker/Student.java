package tracker;

import java.util.*;

public class Student {

    private String firstName;
    private String secondName;
    private String email;
    private Subjects subjects;
    private boolean javaCourseCompleted;
    private boolean DSACourseCompleted;
    private boolean databasesCourseCompleted;
    private boolean springCourseCompleted;


    public Student(String name, String secondName, String email) {
        this.firstName = name;
        this.secondName = secondName;
        this.email = email;
        this.subjects = new Subjects();
    }


    public int getJavaScore() {
        return subjects.getJavaScore();
    }

    public void addJavaScore(int score) {
        subjects.addJavaScore(score);
    }

    public int getDSAScore() { return subjects.getDSAScore(); }

    public void addDSAScore(int score) {
        subjects.addDSAScore(score);
    }

    public int getDatabasesScore() {
        return subjects.getDatabasesScore();
    }

    public void addDatabasesScore(int score) {
        subjects.addDatabasesScore(score);
    }

    public int getSpringScore() {
        return subjects.getSpringScore();
    }

    public void addSpringScore(int score) {
        subjects.addSpringScore(score);
    }

    public String getEmail() { return email; }

    public String getFirstName() { return firstName; }

    public String getSecondName() { return secondName; }

    public boolean isDSACourseCompleted() {
        return DSACourseCompleted;
    }

    public void setDSACourseCompleted(boolean DSACourseCompleted) {
        this.DSACourseCompleted = DSACourseCompleted;
    }

    public boolean isDatabasesCourseCompleted() {
        return databasesCourseCompleted;
    }

    public void setDatabasesCourseCompleted(boolean databasesCourseCompleted) {
        this.databasesCourseCompleted = databasesCourseCompleted;
    }

    public boolean isJavaCourseCompleted() {
        return javaCourseCompleted;
    }

    public void setJavaCourseCompleted(boolean javaCourseCompleted) {
        this.javaCourseCompleted = javaCourseCompleted;
    }

    public boolean isSpringCourseCompleted() {
        return springCourseCompleted;
    }

    public void setSpringCourseCompleted(boolean springCourseCompleted) {
        this.springCourseCompleted = springCourseCompleted;
    }


    @Override
    public String toString() {
        return "Points: Java = " + getJavaScore() + ", DSA = " + getDSAScore() + ", Databases = " + getDatabasesScore() + ", Spring = " + getSpringScore();
    }
}
