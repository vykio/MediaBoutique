package utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;

public class Utils {

    public static boolean sessionAttributeExists(HttpSession session, String attribute)
    {
        try {
            return !session.getAttribute(attribute).toString().isEmpty();
        } catch (NullPointerException e) {
            return false;
        }
    }

    public static boolean requestAttributeExists(HttpServletRequest request, String attribute)
    {
        try {
            return !request.getAttribute(attribute).toString().isEmpty();
        } catch (NullPointerException e) {
            return false;
        }
    }

}
