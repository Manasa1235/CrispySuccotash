package utils;

import java.util.HashMap;
import java.util.Map;

public class CommonContent {

    private static final Map<String, String> errorMessages = new HashMap<>();

    static {
        errorMessages.put("InvalidUserNameError", "Enter a valid username. This value may contain only letters, numbers and @/./+/-/_ characters.");
        errorMessages.put("ShortPasswordError","");
        errorMessages.put("ShortPasswordConfirmError","This password is too short. It must contain at least 8 characters.");
        errorMessages.put("EmptyFieldError","This field is required.");
        errorMessages.put("LoginCommonError","Please enter a correct username and password. Note that both fields may be case-sensitive.");
        errorMessages.put("FeedExistingError","Feed with this Feed URL already exists.");
    }

    public static String getErrorMessage(String key) {
        return errorMessages.get(key);
    }
}
