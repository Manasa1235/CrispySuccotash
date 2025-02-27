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
    }

    public static String getErrorMessage(String key) {
        return errorMessages.get(key);
    }
}
