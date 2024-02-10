package tracker;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface VerificationOfCredentials {
    EmailManager emailManager = new EmailManager();

    default boolean validateCredentials(String credentials, HashMap<Integer, Student> students, int studentID) {

        String emailRegex = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z0-9]{1,}";
        String regex = "(^[A-Za-z]+[-']?[A-Za-z]+)\\s([A-Za-z]+[-']?[A-Za-z]+)(\\s[A-Za-z]+([-']?[A-Za-z]+)*)*\\s(" + emailRegex + ")";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(credentials.trim());

        if (matcher.find()) {
            String firstName = matcher.group(1);
            String lastName = matcher.group(2);
            String email = matcher.group(5);
            //after success validation automatically create and add student
            if (emailManager.isEmailFree(emailManager.emailSet, email)) {
                emailManager.addEmailToSet(emailManager.emailSet, email);
                students.put(studentID, createNewStudent(firstName, lastName, email));
                return true;
            } else {
                System.out.println("This email is already taken.");
                return false;
            }


        } else if (!firstNameValid(credentials) && lastNameValid(credentials) && emailValid(credentials)) {
            System.out.println("Incorrect first name.");
            return false;
        } else if (!lastNameValid(credentials) && firstNameValid(credentials) && emailValid(credentials)) {
            System.out.println("Incorrect last name.");
            return false;
        } else if (!emailValid(credentials) && firstNameValid(credentials) && lastNameValid(credentials)) {
            System.out.println("Incorrect email.");
            return false;
        } else {
            System.out.println("Incorrect credentials: " + credentials);
            return false;
        }
    }

    default boolean firstNameValid(String credentials) {
        String firstNameRegex = "^[A-Za-z]+[-']?[A-Za-z]+\\s";

        Pattern firstNamePattern = Pattern.compile(firstNameRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcherFirstName = firstNamePattern.matcher(credentials.trim());

        return matcherFirstName.find();
    }

    default boolean lastNameValid(String credentials) {
        String lastNameRegex = "\\s[A-Za-z]+[-']?[A-Za-z]+(\\s[A-Za-z]+[-']?[A-Za-z]+)*\\s";

        Pattern lastNamePattern = Pattern.compile(lastNameRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcherLastName = lastNamePattern.matcher(credentials.trim());

        return matcherLastName.find();

    }

    default boolean emailValid(String credentials) {
        String emailRegex = "\\s[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z0-9]{1,}";
        Pattern emailPattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);

        Matcher matcherEmail = emailPattern.matcher(credentials.trim());
        return matcherEmail.find();
    }

    default Student createNewStudent(String firstName, String secondName, String email) {
        Student student = new Student(firstName, secondName, email);
        return student;
    }
}
