package utils;

import javax.servlet.http.HttpSession;

public class Utils {

    public static boolean sessionAttributeExists(HttpSession session, String attribute)
    {
        try {
            return !session.getAttribute(attribute).toString().isEmpty();
        } catch (NullPointerException e) {
            return false;
        }
    }

}
