package tracker;

import java.util.HashSet;
import java.util.Set;

public class EmailManager {
    Set<String> emailSet = new HashSet<>();

    void addEmailToSet(Set<String> emailSet, String email) {
        emailSet.add(email);
    }

    boolean isEmailFree(Set<String> emailSet, String email) {
        if (emailSet.contains(email)) {
            return false;
        } else return true;
    }
}
