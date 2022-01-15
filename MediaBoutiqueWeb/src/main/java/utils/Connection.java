package utils;

import javax.servlet.http.HttpSession;

public class Connection {

    public static boolean isLoggedIn(HttpSession session)
    {
        return Utils.sessionAttributeExists(session, "client");
    }

}
