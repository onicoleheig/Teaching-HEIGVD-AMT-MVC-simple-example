package ch.heigvd.amt.mvcsimple.business;

import ch.heigvd.amt.mvcsimple.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class RegisterForm {

    // Form status
    private boolean isFormValid = true;

    // Handle forms results
    private String results;
    private Map<String, String> errors      = new HashMap<String, String>();

    public User register(HttpServletRequest request) {
        errors.clear();
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        User user = new User(email, firstName, lastName);

        if (!checkEmail(email)) {
            errors.put("email", "Email doesn't contains a @ char");
            isFormValid = false;
        }

        if (firstName.isEmpty()) {
            errors.put("firstname", "Firstname can't be empty");
            isFormValid = false;
        }

        if (lastName.isEmpty()) {
            errors.put("lastname", "Lastname can't be empty");
            isFormValid = false;
        }

        System.out.println(user.toString());
        return user;
    }

    private boolean checkEmail(String email) {
        return ! email.isEmpty() && email.contains("@");
    }

    public String getResults() {
        return results;
    }

    public Map<String, String> getErreurs() {
        return errors;
    }
}