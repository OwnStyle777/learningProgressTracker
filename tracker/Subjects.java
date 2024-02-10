package tracker;

public class Subjects {
    public int javaScore = 0;
    public int DSAScore = 0;
    public int databasesScore = 0;
    public int springScore = 0;

    public int getJavaScore() {return javaScore; }

    public void addJavaScore(int score) {
        javaScore += score;
    }

    public int getDSAScore() {
        return DSAScore;
    }

    public void addDSAScore(int score) {
        DSAScore += score;
    }

    public int getDatabasesScore() {
        return databasesScore;
    }

    public void addDatabasesScore(int score) {
        databasesScore += score;
    }

    public int getSpringScore() {return springScore;}

    public void addSpringScore(int score) {
        springScore += score;
    }
}
