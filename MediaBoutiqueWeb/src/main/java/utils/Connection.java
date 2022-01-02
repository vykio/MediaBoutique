package utils;

import javax.servlet.http.HttpSession;

public class Connection {

    public static boolean isLoggedIn(HttpSession session)
    {
        try {
            return !session.getAttribute("client").toString().isEmpty();
        } catch (NullPointerException e) {
            return false;
        }
    }

}
